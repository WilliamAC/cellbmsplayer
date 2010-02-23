package com.g2d.studio.gameedit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cell.reflect.Parser;
import com.cell.rpg.template.TEffect;
import com.g2d.display.particle.Layer;
import com.g2d.display.particle.OriginShape;
import com.g2d.studio.particles.ParticleViewer;


public class EffectEditor extends JSplitPane implements ActionListener, ListSelectionListener
{
	final static ParticleViewer viewer = new ParticleViewer();
	
	final TEffect effect;
	
	Vector<LayerEdit> layer_list = new Vector<LayerEdit>();
	
	JList 	layers 		= new JList();
	JButton layer_add	= new JButton("添加层");
	JButton layer_del	= new JButton("删除层");
	JButton show		= new JButton("查看");
	
	public EffectEditor(TEffect e) 
	{
		this.effect		= e;
		
		JPanel left = new JPanel(new BorderLayout());
		setLeftComponent(left);
		setRightComponent(new JPanel());
		
		// init left
		{
			JToolBar bar = new JToolBar();
			bar.add(layer_add);
			bar.add(layer_del);
			bar.add(show);
			layer_add.addActionListener(this);
			layer_del.addActionListener(this);
			show.addActionListener(this);
			layers.addListSelectionListener(this);
			layers.setPreferredSize(new Dimension(400, 400));
			left.add(bar, BorderLayout.NORTH);
			left.add(new JScrollPane(layers), BorderLayout.CENTER);
		}
		
		for (Layer layer : e.particles) {
			LayerEdit edit = new LayerEdit(layer);
			layer_list.add(edit);
		}
		
		layers.setListData(layer_list);
	}

	public TEffect getData() {
		try{
			for (LayerEdit edit : layer_list) {
				edit.getData();
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return effect;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object obj = layers.getSelectedValue();
		if (obj instanceof LayerEdit) {
			LayerEdit right = (LayerEdit)obj;
			setRightComponent(right);
		} else {
			setRightComponent(new JPanel());
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == layer_add) 
		{
			Layer layer = new Layer();
			effect.particles.addLayer(layer);
			LayerEdit edit = new LayerEdit(layer);
			layer_list.add(edit);
			layers.setListData(layer_list);
			layers.setSelectedValue(edit, true);
		}
		else if (e.getSource() == layer_del) 
		{
			Object obj = layers.getSelectedValue();
			if (obj instanceof LayerEdit) {
				LayerEdit right = (LayerEdit)obj;
				effect.particles.removeLayer(right.layer);
				layer_list.remove(right);
				setRightComponent(new JPanel());
				layers.setListData(layer_list);
			}
		}
		else if (e.getSource() == show)
		{
			viewer.setParticleData(this);
			viewer.setVisible(true);
		}
		
	}
		


//	--------------------------------------------------------------------------------------------------------------------

	static class LayerEdit extends JTabbedPane
	{
		final Layer layer;
		
		PageAppearance	page_appearance	= new PageAppearance();
		PageScene		page_scene		= new PageScene();
		PageOrigin 		page_origin		= new PageOrigin();
		PageInfluences	page_influences	= new PageInfluences();
		
		public LayerEdit(Layer layer) {
			this.layer = layer;
			addTab("外观", page_appearance);
			addTab("场景", page_scene);
			addTab("发射", page_origin);
			addTab("影响", page_influences);
			setData(layer);
		}
		
		void setData(Layer layer) {
			page_scene.setData(layer);
			page_origin.setData(layer);
		}
		
		void getData() {
			page_scene.getData(layer);
			page_origin.getData(layer);
		}
		
		@Override
		public String toString() {
			return layer + "";
		}
		
//		-------------------------------------------------------------------------------------------------------------------------------
		
		abstract class PropertyPage extends JPanel
		{
			public PropertyPage() {
				super(null);
			}
			
			abstract void setData(Layer layer);
			abstract void getData(Layer layer);
		}
		
		class PageAppearance extends PropertyPage
		{
			@Override
			void getData(Layer layer) {}
			@Override
			void setData(Layer layer) {}
		}
	
		class PageScene extends PropertyPage
		{
			JLabel		particles_capacity		= new JLabel("粒子容量");
			JSpinner	particles_capacity_v 	= new JSpinner(new SpinnerNumberModel(300, 0, Integer.MAX_VALUE, 1));
			JLabel		particle_age			= new JLabel("粒子生命周期时间范围(帧)");
			JSpinner	particle_min_age_v		= new JSpinner(new SpinnerNumberModel(30, 1, Integer.MAX_VALUE, 1)), 
						particle_max_age_v		= new JSpinner(new SpinnerNumberModel(60, 1, Integer.MAX_VALUE, 1));
			JLabel		particles_per_frame		= new JLabel("粒子每帧释放多少个");
			JSpinner	particles_per_frame_v 	= new JSpinner(new SpinnerNumberModel(10, 0, Integer.MAX_VALUE, 1));
			
			public PageScene() 
			{
				int sx = 20, sy = 20;
				{
					particles_capacity		.setBounds(sx, sy, 200, 24); sy += 25;
					particles_capacity_v	.setBounds(sx, sy, 200, 24); sy += 25;
					super.add(particles_capacity);
					super.add(particles_capacity_v);
					
					particle_age		.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					particle_min_age_v	.setBounds(sx + 0,   sy, 99,  24);
					particle_max_age_v	.setBounds(sx + 101, sy, 99,  24); sy += 25;
					super.add(particle_age);
					super.add(particle_min_age_v);
					super.add(particle_max_age_v);
					
					particles_per_frame		.setBounds(sx, sy, 200, 24); sy += 25;
					particles_per_frame_v	.setBounds(sx, sy, 200, 24); sy += 25;
					super.add(particles_per_frame);
					super.add(particles_per_frame_v);
				}
			}
			
			void setData(Layer layer) {
				particles_capacity_v	.setValue(layer.particles_capacity);
				particle_min_age_v		.setValue(layer.particle_min_age);
				particle_max_age_v		.setValue(layer.particle_max_age);
				particles_per_frame_v	.setValue(layer.particles_per_frame);
			}
			
			void getData(Layer layer) {
				layer.particles_capacity	= Parser.castNumber(particles_capacity_v.getValue(), Integer.class);
				layer.particle_min_age		= Parser.castNumber(particle_min_age_v.getValue(), Integer.class);
				layer.particle_max_age		= Parser.castNumber(particle_max_age_v.getValue(), Integer.class);
				layer.particles_per_frame	= Parser.castNumber(particles_per_frame_v.getValue(), Integer.class);
			}
		}
		
		class PageOrigin extends PropertyPage implements ActionListener
		{
			JLabel		origin_pos				= new JLabel("发射基地位置");
			JSpinner	origin_x_v 				= new JSpinner(new SpinnerNumberModel(0, -Float.MAX_VALUE, Float.MAX_VALUE, 1f)),
						origin_y_v				= new JSpinner(new SpinnerNumberModel(0, -Float.MAX_VALUE, Float.MAX_VALUE, 1f));
			JLabel		origin_rotation_angle	= new JLabel("发射基地变换角度");
			JSpinner	origin_rotation_angle_v	= new JSpinner(new SpinnerNumberModel(-90f, -360d, 360d, 1f));
			JLabel		origin_scale			= new JLabel("发射基地拉伸");
			JSpinner	origin_scale_x_v		= new JSpinner(new SpinnerNumberModel(1f, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f)),
						origin_scale_y_v		= new JSpinner(new SpinnerNumberModel(1f, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
			
			JLabel		origin_shape			= new JLabel("发射基地几何造型");
			OriginShapeType	origin_shape_rect	= new Rectangle();
			OriginShapeType origin_shape_ring	= new Ring();
			JComboBox	origin_shape_list		= new JComboBox(new OriginShapeType[]{
					origin_shape_rect,
					origin_shape_ring,
			});
			JScrollPane	orgin_shape_pane		= new JScrollPane(new JPanel());
			
			JLabel		spawn_angle				= new JLabel("发射角度");
			JSpinner	spawn_angle_v			= new JSpinner(new SpinnerNumberModel(-90f, -360d, 360d, 1f));
			JLabel		spawn_angle_range		= new JLabel("发射角度随机±范围");
			JSpinner	spawn_angle_range_v		= new JSpinner(new SpinnerNumberModel(-90f, -360d, 360d, 1f));
			JLabel		spawn_velocity			= new JLabel("发射速度");
			JSpinner	spawn_velocity_v		= new JSpinner(new SpinnerNumberModel(4.0f, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
			JLabel		spawn_velocity_range	= new JLabel("发射速度随机±范围");
			JSpinner	spawn_velocity_range_v	= new JSpinner(new SpinnerNumberModel(2.0f, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));

			@Override
			public void update(Graphics g) {
				// TODO Auto-generated method stub
				super.update(g);
				System.out.println("update");
			}
			
			public PageOrigin() 
			{
				int sx = 20, sy = 20;
				{
					origin_pos.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					origin_x_v.setBounds(sx + 0,   sy, 99,  24);
					origin_y_v.setBounds(sx + 101, sy, 99,  24); sy += 25;
					super.add(origin_pos);
					super.add(origin_x_v);
					super.add(origin_y_v);
				
					origin_rotation_angle	.setBounds(sx, sy, 200, 24); sy += 25;
					origin_rotation_angle_v	.setBounds(sx, sy, 200, 24); sy += 25;
					super.add(origin_rotation_angle);
					super.add(origin_rotation_angle_v);
				
					origin_scale	.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					origin_scale_x_v.setBounds(sx + 0,   sy, 99,  24);
					origin_scale_y_v.setBounds(sx + 101, sy, 99,  24); sy += 25;
					super.add(origin_scale);
					super.add(origin_scale_x_v);
					super.add(origin_scale_y_v);
				
					origin_shape		.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					origin_shape_list	.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					orgin_shape_pane	.setBounds(sx + 0,   sy, 200, 200); sy += 200;
					super.add(origin_shape);
					super.add(origin_shape_list);
					super.add(orgin_shape_pane);
					
					origin_shape_list.addActionListener(this);
					origin_shape_list.setSelectedIndex(0);
				}
				
				sy = 20; sx += 250;
				{
					spawn_angle				.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_angle_v			.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_angle_range		.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_angle_range_v		.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					super.add(spawn_angle);
					super.add(spawn_angle_v);
					super.add(spawn_angle_range);
					super.add(spawn_angle_range_v);
				
					spawn_velocity			.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_velocity_v		.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_velocity_range	.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					spawn_velocity_range_v	.setBounds(sx + 0,   sy, 200, 24); sy += 25;
					super.add(spawn_velocity);
					super.add(spawn_velocity_v);
					super.add(spawn_velocity_range);
					super.add(spawn_velocity_range_v);
				}
			}
			
			void setData(Layer layer)
			{
				origin_x_v				.setValue(layer.origin_x);
				origin_y_v				.setValue(layer.origin_y);
				origin_rotation_angle_v	.setValue(Math.toDegrees(layer.origin_rotation_angle));
				origin_scale_x_v		.setValue(layer.origin_scale_x);
				origin_scale_y_v		.setValue(layer.origin_scale_y);
				
				if (layer.origin_shape instanceof OriginShape.Rectangle) {
					origin_shape_rect.setShape(layer.origin_shape);
					origin_shape_list.setSelectedItem(origin_shape_rect);
				} 
				else if (layer.origin_shape instanceof OriginShape.Ring) {
					origin_shape_ring.setShape(layer.origin_shape);
					origin_shape_list.setSelectedItem(origin_shape_ring);
				}
				
				spawn_angle_v			.setValue(Math.toDegrees(layer.spawn_angle));
				spawn_angle_range_v		.setValue(Math.toDegrees(layer.spawn_angle_range));
				spawn_velocity_v		.setValue(layer.spawn_velocity);
				spawn_velocity_range_v	.setValue(layer.spawn_velocity_range);
				
			}
			
			void getData(Layer layer) 
			{
				layer.origin_x				= Parser.castNumber(origin_x_v.getValue(), Float.class);
				layer.origin_y				= Parser.castNumber(origin_y_v.getValue(), Float.class);
				layer.origin_rotation_angle	= (float)Math.toRadians((Double)(origin_rotation_angle_v.getValue()));
				layer.origin_scale_x		= Parser.castNumber(origin_scale_x_v.getValue(), Float.class);
				layer.origin_scale_y		= Parser.castNumber(origin_scale_y_v.getValue(), Float.class);
				
				if (origin_shape_list.getSelectedItem() instanceof OriginShapeType) {
					OriginShapeType type	= (OriginShapeType)origin_shape_list.getSelectedItem();
					layer.origin_shape		= type.getShape();
				}
				
				layer.spawn_angle			= (float)Math.toRadians((Double)(spawn_angle_v.getValue()));
				layer.spawn_angle_range		= (float)Math.toRadians((Double)(spawn_angle_range_v.getValue()));
				layer.spawn_velocity		= Parser.castNumber(spawn_velocity_v.getValue(), Float.class);
				layer.spawn_velocity_range	= Parser.castNumber(spawn_velocity_range_v.getValue(), Float.class);
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == origin_shape_list) {
					Object obj = origin_shape_list.getSelectedItem();
					if (obj instanceof OriginShapeType) {
						orgin_shape_pane.setViewportView((OriginShapeType)obj);
					}
				}
			}
			
			
			abstract class OriginShapeType extends JPanel
			{
				final String 	name;
				final Class<?> 	type;
				public OriginShapeType(String name, Class<?> cls) {
					this.name = name;
					this.type = cls;
				}
				public String toString() {
					return name;
				}
				
				abstract OriginShape getShape() ;
				
				abstract void setShape(OriginShape shape);
			}
			
			class Rectangle extends OriginShapeType
			{
				JLabel lbl_x = new JLabel("X");
				JLabel lbl_y = new JLabel("Y");
				JLabel lbl_w = new JLabel("宽");
				JLabel lbl_h = new JLabel("高");
				JSpinner x = new JSpinner(new SpinnerNumberModel(-100, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
				JSpinner y = new JSpinner(new SpinnerNumberModel(-100, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
				JSpinner w = new JSpinner(new SpinnerNumberModel(200, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
				JSpinner h = new JSpinner(new SpinnerNumberModel(200, -Float.MAX_VALUE, Float.MAX_VALUE, 0.1f));
				
				public Rectangle()
				{
					super("矩形", OriginShape.Rectangle.class);
					super.setLayout(null);
					
					lbl_x.setHorizontalAlignment(SwingConstants.RIGHT);
					lbl_y.setHorizontalAlignment(SwingConstants.RIGHT);
					lbl_w.setHorizontalAlignment(SwingConstants.RIGHT);
					lbl_h.setHorizontalAlignment(SwingConstants.RIGHT);
					
					lbl_x.setBounds(0,   0, 80, 24); x.setBounds(80,   0, 100, 24); 
					lbl_y.setBounds(0,  25, 80, 24); y.setBounds(80,  25, 100, 24); 
					lbl_w.setBounds(0,  50, 80, 24); w.setBounds(80,  50, 100, 24); 
					lbl_h.setBounds(0,  75, 80, 24); h.setBounds(80,  75, 100, 24); 
					
					super.add(lbl_x); super.add(x);
					super.add(lbl_y); super.add(y);
					super.add(lbl_w); super.add(w);
					super.add(lbl_h); super.add(h);
					
				}
				
				@Override
				public void setShape(OriginShape shape) {
					if (shape instanceof OriginShape.Rectangle) {
						OriginShape.Rectangle s = (OriginShape.Rectangle)shape;
						x.setValue(s.x);
						y.setValue(s.y);
						w.setValue(s.w);
						h.setValue(s.h);
					}
				}
				
				@Override
				public OriginShape getShape() {
					OriginShape.Rectangle ret = new OriginShape.Rectangle();
					ret.x = Parser.castNumber(x.getValue(), Float.class);
					ret.y = Parser.castNumber(y.getValue(), Float.class);
					ret.w = Parser.castNumber(w.getValue(), Float.class);
					ret.h = Parser.castNumber(h.getValue(), Float.class);
					return ret;
				}
			}
			
			class Ring extends OriginShapeType
			{
				JLabel lbl_r1 = new JLabel("内圆半径");
				JLabel lbl_r2 = new JLabel("外圆半径");
				JSpinner r1 = new JSpinner(new SpinnerNumberModel(100, 0, Float.MAX_VALUE, 0.1f));
				JSpinner r2 = new JSpinner(new SpinnerNumberModel(200, 0, Float.MAX_VALUE, 0.1f));
				
				public Ring() {
					super("圆环", OriginShape.Ring.class);
					super.setLayout(null);
					
					lbl_r1.setHorizontalAlignment(SwingConstants.RIGHT);
					lbl_r2.setHorizontalAlignment(SwingConstants.RIGHT);
					
					lbl_r1.setBounds(0,   0, 80, 24); r1.setBounds(80,   0, 100, 24); 
					lbl_r2.setBounds(0,  25, 80, 24); r2.setBounds(80,  25, 100, 24); 
					
					super.add(lbl_r1); super.add(r1);
					super.add(lbl_r2); super.add(r2);
				}
				
				@Override
				public void setShape(OriginShape shape) {
					if (shape instanceof OriginShape.Ring) {
						OriginShape.Ring s = (OriginShape.Ring)shape;
						r1.setValue(s.radius1);
						r2.setValue(s.radius2);
					}
				}
				
				@Override
				public OriginShape getShape() {
					OriginShape.Ring ret = new OriginShape.Ring();
					ret.radius1 = Parser.castNumber(r1.getValue(), Float.class);
					ret.radius2 = Parser.castNumber(r2.getValue(), Float.class);
					return ret;
				}
			}
			
		}
		
		class PageInfluences extends PropertyPage
		{
			@Override
			void getData(Layer layer) {}
			
			@Override
			void setData(Layer layer) {}
			
			
		}
	}
	
//	--------------------------------------------------------------------------------------------------------------------

}

