package com.g2d.studio.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.g2d.util.AbstractDialog;

public abstract class G2DListSelectDialog<T extends G2DListItem>  extends AbstractDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	G2DList<T> list;
	
	JButton ok 		= new JButton("确定");
	JButton cancel 	= new JButton("取消");
	
	T object;
	
	public G2DListSelectDialog(Component owner, G2DList<T> list)
	{
		super(owner);
		super.setLayout(new BorderLayout());
		super.setSize(600, 400);
		super.setCenter();
		
		this.list = list;
		this.list.setLayoutOrientation(JList.HORIZONTAL_WRAP);		
		this.list.setVisibleRowCount(list.getModel().getSize()/5+1);
		this.add(new JScrollPane(list), BorderLayout.CENTER);
		
		{
			JPanel south = new JPanel(new FlowLayout());
			
			south.add(ok);
			ok.addActionListener(this);
			
			south.add(cancel);
			cancel.addActionListener(this);
			
			this.add(south, BorderLayout.SOUTH);
		}
	}
	
	protected G2DList<T> getList(){
		return this.list;
	}
	
	public T getSelectedObject() {
		return list.getSelectedItem();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			if (checkOK()) {
				object = list.getSelectedItem();
				this.setVisible(false);
			}
		} else if (e.getSource() == cancel) {
			list.setSelectedValue(null, false);
			this.setVisible(false);
		}
	}
	
	public T showDialog() {
		super.setVisible(true);
		return object;
	}
	
	protected boolean checkOK() {
		return true;
	}
}
