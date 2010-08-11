package com.g2d.display;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

import com.g2d.Tools;
import com.g2d.Version;
import com.g2d.annotation.Property;
import com.g2d.display.event.Event;

public abstract class DisplayObjectContainer extends DisplayObject
{
	private static final long serialVersionUID = Version.VersionG2D;
	
//	-------------------------------------------------------------

	/** true 如果不在父节点的local_bounds内,则忽略事件处理 (包括孩子的) */
	protected boolean 					ignore_render_without_parent_bounds = false;
	
	ConcurrentHashMap<DisplayObject, DisplayObject>
										elements_set	= new ConcurrentHashMap<DisplayObject, DisplayObject>();
	
	private ReentrantLock				elements_lock	= new ReentrantLock();
	private Vector<DisplayObject>		elements_buffer = new Vector<DisplayObject>();
	private Queue<DisplayObjectEvent>	events 			= new ConcurrentLinkedQueue<DisplayObjectEvent>();

	DisplayObject						always_top_element;
	DisplayObject						always_bottom_element;
	
//	-------------------------------------------------------------
	Comparator<DisplayObject>			sorter 			= new DefaultObjectSorter();
//	-------------------------------------------------------------
	
	public DisplayObjectContainer() {}
	
	/**
	 * 该方法已无用
	 */
	@Deprecated
	final public void processEvent(){}
	
	final private void processEvents()
	{
		while (!events.isEmpty())
		{
			DisplayObjectEvent event = events.poll();
			
			switch (event.event_type)
			{
			case DisplayObjectEvent.EVENT_SORT:
				synchronized (elements_lock) {
				Collections.sort(elements_buffer, sorter);
				}
				break;

			case DisplayObjectEvent.EVENT_ADD:
				elements_buffer.add(event.source);
				event.source.parent = this;
				event.source.root	= this.root;
				event.source.onAdded(this);
				break;
				
			case DisplayObjectEvent.EVENT_DELETE:
				elements_buffer.remove(event.source);
				event.source.onRemoved(this);
				event.source.parent = null;
				break;
				
			case DisplayObjectEvent.EVENT_MOVE_TOP:
				synchronized (elements_lock) {
					if (elements_set.contains(event.source)) {
						elements_buffer.remove(event.source);
						elements_buffer.add(event.source);
					}
				}
				break;
				
			case DisplayObjectEvent.EVENT_MOVE_BOT:
				synchronized (elements_lock) {
					if (elements_set.contains(event.source)) {
						elements_buffer.remove(event.source);
						elements_buffer.add(0, event.source);
					}
				}
				break;
			}
		}
	
	}
	
	
	boolean onPoolEvent(com.g2d.display.event.Event<?> event) 
	{
		if (always_top_element!=null) {
			return always_top_element.onPoolEvent(event);
		}else{
			synchronized (elements_lock) {
				for (int i = elements_buffer.size() - 1; i >= 0; --i) {
					if (elements_buffer.get(i).onPoolEvent(event)) {
						return true;
					}
				}
			}
		}
		// 如果孩子没有处理该消息则直接跳过该消息
		return false;
	}
	
	final void onAdded(DisplayObjectContainer parent) 
	{
		for (int i = elements_buffer.size() - 1; i >= 0; --i) {
			elements_buffer.get(i).onAdded(parent);
		}
		this.added(parent);
	}
	
	final void onRemoved(DisplayObjectContainer parent) 
	{
		for (int i = elements_buffer.size() - 1; i >= 0; --i) {
			elements_buffer.get(i).onRemoved(parent);
		}
		this.removed(parent);
	}
	
//	-----------------------------------------------------------------------------------------------------------------------
	
	void onUpdate(DisplayObjectContainer parent) 
	{
		super.onUpdate(parent);
	}
	
	@Override
	final void updateBefore(DisplayObjectContainer parent) {
		processEvents();
		updateChilds();
	}
	
	@Override
	final void updateAfter(DisplayObjectContainer parent) {
		if (always_top_element != null) {		
			if (always_top_element.parent != this) {
				setAlwaysTopFocus(null);
			}
			else if (elements_buffer.get(elements_buffer.size()-1) != always_top_element) {
				focus(always_top_element);
			}
		}
	}
	
	protected void updateChilds() {
		for (int i = elements_buffer.size() - 1; i >= 0; --i) {
			elements_buffer.get(i).onUpdate(this);
		}
	}
	
//	-----------------------------------------------------------------------------------------------------------------------
	
	
	void onRender(Graphics2D g) 
	{
		if (ignore_render_without_parent_bounds && !g.hitClip(
				(int)x + local_bounds.x, 
				(int)y + local_bounds.y, 
				local_bounds.width, 
				local_bounds.height)){
			return;
		} else {
			super.onRender(g);
		}
	}
	
	@Override
	void renderInteractive(Graphics2D g) {
		renderChilds(g);
	}
	
	protected void renderChilds(Graphics2D g) {
		int size = elements_buffer.size();
		for (int i = 0; i < size; i++) {
			elements_buffer.get(i).onRender(g);
		}
	}
	
//	-----------------------------------------------------------------------------------------------------------



	public void setDebug(boolean d) {
		super.setDebug(d);
		for (int i = elements_buffer.size() - 1; i >= 0; --i) {
			elements_buffer.get(i).setDebug(d);
		}
	}
	
	final public void sort() {
		events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_SORT));
	}
	
	final public void setSorter(Comparator<DisplayObject> sorter) {
		if (sorter != null) {
			this.sorter = sorter;
		}
	}
	
	// focus
	/**
	 * 找到当前控件聚焦的子控件
	 * @return
	 */
	final public DisplayObject getFocus() {
		if (!elements_buffer.isEmpty()) {
			return elements_buffer.get(elements_buffer.size()-1);
		}
		return null;
	}
	
	/**
	 * 找到当前控件聚焦的最上层节点，该节点可能是子节点的子节点...
	 * @return
	 */
	final public DisplayObject getFocusLeaf() {
		return getFocusLeaf(this);
	}
	
	private static DisplayObject getFocusLeaf(DisplayObject obj) {
		if (obj instanceof DisplayObjectContainer) {
			DisplayObjectContainer c = (DisplayObjectContainer)obj;
			if (c.elements_buffer.isEmpty()) {
				return c;
			} else {
				return getFocusLeaf(c.getFocus());
			}
		} else {
			return obj;
		}
	}
	
	final public void focus(DisplayObject child){
		if (always_top_element != null) {
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_TOP, always_top_element));
		} else if (child == always_bottom_element){
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_BOT, child));
		} else {
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_TOP, child));
		}
	}
	
//	top element
	final public void removeAlwaysTopFocus(){
		setAlwaysTopFocus(null);
	}
	
	final public void setAlwaysTopFocus(DisplayObject child) {
		if (child != null) {
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_TOP, child));
		}
		always_top_element = child;
	}
	
	final public DisplayObject getAlwaysTopFocus() {
		return always_top_element;
	}
	
//	bottom element
	final public void removeAlwaysBottom(){
		setAlwaysBottom(null);
	}
	
	final public void setAlwaysBottom(DisplayObject child) {
		if (child != null) {
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_BOT, child));
		}
		always_bottom_element = child;
	}
	final public DisplayObject getAlwaysBottom() {
		return always_bottom_element;
	}


//	-----------------------------------------------------------------------------------------------------------
	
	public boolean addChild(DisplayObject child){
		if (child.parent == null) {
			child.parent = this;
			child.root = this.getRoot();
			elements_set.put(child, child);
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_ADD, child));
			if (always_top_element != null) {
				events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_MOVE_TOP, always_top_element));
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeChild(DisplayObject child) {
		if (child.parent == this) {
			elements_set.remove(child);
			child.parent = null;
			if (always_top_element == child) {
				always_top_element = null;
			}
			events.offer(new DisplayObjectEvent(DisplayObjectEvent.EVENT_DELETE, child));
			return true;
		}
		return false;
	}

	final public boolean addChild(DisplayObject child, boolean immediately){
		if (addChild(child) && immediately) {
			return true;
		}
		return false;
	}
	
	final public boolean removeChild(DisplayObject child, boolean immediately) {
		if (removeChild(child, false) && immediately) {
			return true;
		}
		return false;
	}

	final public void addChilds(Collection<? extends DisplayObject> childs){
		for (DisplayObject child : childs) {
			addChild(child);
		}
	}
	
	final public void removeChilds(Collection<? extends DisplayObject> childs) {
		for (DisplayObject child : childs) {
			removeChild(child);
		}
	}
	
	final public void clearChilds() {
		removeChilds(getChilds());
	}
	
	
//	-----------------------------------------------------------------------------------------------------------

	final public boolean contains(DisplayObject child) {
		return elements_set.contains(child);
	}
	
	final public int getChildCount() {
		return elements_set.size();
	}

	@SuppressWarnings("unchecked")
	final public Vector<DisplayObject> getChilds() {
		return new Vector<DisplayObject>(elements_set.values());
	}
	
	/**
	 * 得到该类赋值兼容的对象(不包括子类的)
	 * @param <T>
	 * @param c 
	 * @return
	 */
	final public<T> Vector<T> getChilds(Class<T> c) {
		Vector<T> actors = new Vector<T>();
		for (DisplayObject obj : elements_set.values()) {
			if (c.equals(obj.getClass())) {
				actors.add(c.cast(obj));
			}
		}
		return actors;
	}

	/**
	 * 得到该类赋值兼容的对象(包括子类的)
	 * @param <T>
	 * @param c 
	 * @return
	 */
	final public<T> Vector<T> getChildsSubClass(Class<T> c) {
		Vector<T> actors = new Vector<T>();
		for (DisplayObject obj : elements_set.values()) {
			if (c.isInstance(obj)) {
				actors.add(c.cast(obj));
			}
		}
		return actors;
	}
	
//	final public DisplayObject getChildAt(int index) {
//		return elements_set.elementAt(index);
//	}

	final public DisplayObject findChild(Object object) {
		for (DisplayObject child : elements_set.values()) {
			if (object.equals(child)) {
				return child;
			}
		}
		return null;
	}

//	final public int getChildIndex(DisplayObject child) {
//		return elements_set.indexOf(child);
//	}
	
//	-------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 得到该类赋值兼容的对象(不包括子类的)
	 * @param <T>
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
	public<T> T getChildAtPos(int x, int y, Class<T> c) {
		for (DisplayObject obj : elements_set.values()) {
			if (obj.local_bounds.contains(x-obj.x, y-obj.y)) {
				if (c.equals(obj.getClass())) {
					return c.cast(obj);
				}
			}
		}
		return null;
	}

	/***
	 * 得到该类赋值兼容的对象(包括子类的)
	 * @param <T>
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
	public<T> T getChildAtPosSubClass(int x, int y, Class<T> c) {
		for (DisplayObject obj : elements_set.values()) {
			if (obj.local_bounds.contains(x-obj.x, y-obj.y)) {
				if (c.isInstance(obj)) {
					return c.cast(obj);
				}
			}
		}
		return null;
	}
	
	public DisplayObject getChildAtPos(int x, int y) {
		for (DisplayObject obj : elements_set.values()) {
			if (obj.local_bounds.contains(x-obj.x, y-obj.y)) {
				return obj;
			}
		}
		return null;
	}

//	-------------------------------------------------------------------------------------------------------------------------------------

	class DisplayObjectEvent extends Event<DisplayObject> implements Serializable
	{
		private static final long serialVersionUID = Version.VersionG2D;
		
		final static public byte EVENT_SORT 		= 0;
		final static public byte EVENT_ADD 			= 1;
		final static public byte EVENT_DELETE 		= 2;

		final static public byte EVENT_MOVE_TOP 	= 11;
		final static public byte EVENT_MOVE_BOT 	= 12;
		
		byte event_type = 0;
		
		DisplayObject source;
		
		public DisplayObjectEvent(byte type, DisplayObject source) {
			this.event_type = type;
			this.source = source;
		}
		
		public DisplayObjectEvent(byte type) {
			this.event_type = type;
		}
	}
	
	public static class DefaultObjectSorter implements Comparator<DisplayObject> {
		@Override
		public int compare(DisplayObject o1, DisplayObject o2) {
			return (int)((o1.z+o1.priority) - (o2.z+o2.priority));
		}
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------------
	
	
}