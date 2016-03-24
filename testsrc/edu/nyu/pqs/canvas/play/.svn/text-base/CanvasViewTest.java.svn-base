package edu.nyu.pqs.canvas.play;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CanvasViewTest {
	static CanvasModel model;
	static List<ICanvasListener> listeners;
	static List<Shape> shapes;
	static List<Color> colors;
	static ICanvasListener listener1; 
	static ICanvasListener listener2; 
	static ICanvasListener listener3; 
	static ICanvasListener listener4;
	@BeforeClass
	public static void init() {
		model = CanvasModel.getInstance();
		listeners = new ArrayList<ICanvasListener>();
		shapes = new ArrayList<Shape>();
		colors = new ArrayList<Color>();
	}
	
	@Before
	public void setUp() {
		listener1 = new CanvasView(model);
	  listener2 = new CanvasView(model);
		listener3 = new CanvasView(model);
		listener4 = new CanvasView(model);
		listeners.add(listener1);
		listeners.add(listener2);
		listeners.add(listener3);
		listeners.add(listener4);
	}
	
	@Test
	public void loadShapeOnlyUpdatesFromModelTest() {
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		model.addNewShape(circle, Color.RED);
		this.shapes.add(circle);
		this.colors.add(Color.RED);
		listener1.loadShapes(shapes, colors);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		model.addNewShape(circle, Color.ORANGE);
		this.shapes.add(oval);
		this.colors.add(Color.ORANGE);
		
		listener2.loadShapes(shapes, colors);
		listener3.loadShapes(shapes, colors);
		listener4.loadShapes(shapes, colors);
		
		assertEquals(2, listener1.getColorArray().size());
		assertEquals(2, listener2.getColorArray().size());
		assertEquals(2, listener3.getColorArray().size());
		assertEquals(2, listener4.getColorArray().size());
		
		assertEquals(Color.RED, listener1.getColorArray().get(0));
		assertEquals(Color.RED, listener2.getColorArray().get(0));
		assertEquals(Color.RED, listener3.getColorArray().get(0));
		assertEquals(Color.RED, listener4.getColorArray().get(0));
		assertEquals(Color.ORANGE, listener1.getColorArray().get(1));
	}

	@Test
	public void addShape_AddsShapesToSeparateViewsTest() {
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		listener1.addShape(circle, Color.RED);
		listener2.addShape(circle, Color.RED);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		listener1.addShape(oval, Color.PINK);
		listener3.addShape(oval, Color.PINK);
		listener4.addShape(oval, Color.PINK);
		Shape rectangle = new Rectangle2D.Float(50, 50, 100, 100);
		listener4.addShape(rectangle, Color.YELLOW);
		
		
		assertEquals(2, listener1.getColorArray().size());
		assertEquals(1, listener2.getColorArray().size());
		assertEquals(1, listener3.getColorArray().size());
		assertEquals(2, listener4.getColorArray().size());
		
		assertEquals(Color.RED, listener1.getColorArray().get(0));
		assertEquals(Color.RED, listener2.getColorArray().get(0));
		assertEquals(Color.PINK, listener3.getColorArray().get(0));
		assertEquals(Color.PINK, listener4.getColorArray().get(0));
		assertEquals(Color.PINK, listener1.getColorArray().get(1));
		assertEquals(Color.YELLOW, listener4.getColorArray().get(1));
	}
	
	@Test
	public void addShapeToModelTest() {
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		shapes.add(circle);
		colors.add(Color.RED);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		shapes.add(oval);
		colors.add(Color.ORANGE);
		Shape rectangle = new Rectangle2D.Float(50, 50, 100, 100);
		shapes.add(rectangle);
		colors.add(Color.YELLOW);
		Shape line = new Line2D.Float(0, 0, 80, 80);
		shapes.add(line);
		colors.add(Color.GREEN);
		
		Iterator<Color> thisColorItr = colors.iterator();
		Iterator<Shape> thisShapeItr = shapes.iterator();
		
		while (thisShapeItr.hasNext()) {
			listener1.addShapeToModel(thisShapeItr.next(), thisColorItr.next());
		}

		assertEquals(listener1.getColorArray().size(), listener2.getColorArray().size());
		assertEquals(listener1.getColorArray().size(), listener3.getColorArray().size());
		assertEquals(listener1.getColorArray().size(), listener4.getShapeArray().size());
	}
	
	@Test
	public void registerNewCanvasListener() {
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		model.addNewShape(circle, Color.RED);
		this.shapes.add(circle);
		this.colors.add(Color.RED);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		model.addNewShape(circle, Color.ORANGE);
		this.shapes.add(oval);
		this.colors.add(Color.ORANGE);
		
		ICanvasListener newListener = new CanvasView(model);
		System.out.println(newListener.getColorArray().size());
		assertEquals(newListener.getColorArray().size(),model.getShapeArray().size());
	}

	@After
	public void tearDown() {
		colors.clear();
		shapes.clear();
		model.clearDrawing();
		for(ICanvasListener listener: listeners) {
			listener.clearCanvas();
			model.unregister(listener);
		}
	}
}
