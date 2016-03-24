package edu.nyu.pqs.canvas.play;

import static org.junit.Assert.assertEquals;

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

public class CanvasModelTest {
	
	static CanvasModel model;
	static List<ICanvasListener> listeners;
	static List<Shape> shapes;
	static List<Color> colors;
	
	@BeforeClass
	public static void init() {
		model = CanvasModel.getInstance();
		listeners = new ArrayList<ICanvasListener>();
		shapes = new ArrayList<Shape>();
		colors = new ArrayList<Color>();
	}
	
	@Before
	public void setUp() {
		listeners.add(new CanvasView(model));
		listeners.add(new CanvasView(model));
		listeners.add(new CanvasView(model));
		listeners.add(new CanvasView(model));
	}
	
	@Test
	public void registerTest() {
		listeners.add(new CanvasView(model));
		listeners.add(new CanvasView(model));
		listeners.add(new CanvasView(model));
		assertEquals(7,model.getListeners().size());
		
		Iterator<ICanvasListener> modelListenerItr = model.getListeners().iterator();
		
		for (ICanvasListener listener: listeners) {
			assertEquals(listener, modelListenerItr.next());
		}
	}
	
	@Test
	public void unregisterTest() {
		assertEquals(4,model.getListeners().size());
		for(ICanvasListener listener: listeners) {
			model.unregister(listener);
		}
		assertEquals(0,model.getListeners().size());
	}
	
	@Test
	public void addNewShapeToModelTest() {
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		model.addNewShape(circle, Color.RED);
		shapes.add(circle);
		colors.add(Color.RED);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		model.addNewShape(oval, Color.ORANGE);
		shapes.add(oval);
		colors.add(Color.ORANGE);
		Shape rectangle = new Rectangle2D.Float(50, 50, 100, 100);
		model.addNewShape(rectangle, Color.YELLOW);
		shapes.add(rectangle);
		colors.add(Color.YELLOW);
		Shape line = new Line2D.Float(0, 0, 80, 80);
		model.addNewShape(line, Color.GREEN);
		shapes.add(line);
		colors.add(Color.GREEN);
		
		Iterator<Color> modelColorItr = model.getColorArray().iterator();
		Iterator<Shape> modelShapeItr = model.getShapeArray().iterator();
		Iterator<Color> thisColorItr = colors.iterator();
		Iterator<Shape> thisShapeItr = shapes.iterator();
		
		assertEquals(model.getColorArray().size(), colors.size());
		assertEquals(model.getShapeArray().size(), shapes.size());
		assertEquals(colors.size(), shapes.size());
		
		while (thisShapeItr.hasNext()) {
			assertEquals(modelColorItr.next(),thisColorItr.next());
			assertEquals(modelShapeItr.next(),thisShapeItr.next());
		}	
		assertEquals(false, modelColorItr.hasNext());
		assertEquals(false, modelShapeItr.hasNext());
		assertEquals(false, thisColorItr.hasNext());
	}
	
	@Test
	public void addNewShapeFromModelToICanvasListenersTest() {
		assertEquals(1,1);
		Shape circle = new Ellipse2D.Float(0, 0, 100, 100);
		model.addNewShape(circle, Color.RED);
		shapes.add(circle);
		colors.add(Color.RED);
		Shape oval = new Ellipse2D.Float(0, 0, 10, 100);
		model.addNewShape(oval, Color.ORANGE);
		shapes.add(oval);
		colors.add(Color.ORANGE);
		Shape rectangle = new Rectangle2D.Float(50, 50, 100, 100);
		model.addNewShape(rectangle, Color.YELLOW);
		shapes.add(rectangle);
		colors.add(Color.YELLOW);
		Shape line = new Line2D.Float(0, 0, 80, 80);
		model.addNewShape(line, Color.GREEN);
		shapes.add(line);
		colors.add(Color.GREEN);
		
		for (ICanvasListener listener: model.getListeners()) {
			Iterator<Color> modelColorItr = model.getColorArray().iterator();
			Iterator<Shape> modelShapeItr = model.getShapeArray().iterator();
			Iterator<Color> listenerColorItr = listener.getColorArray().iterator();
			Iterator<Shape> listenerShapeItr = listener.getShapeArray().iterator();
			while(modelColorItr.hasNext()) {
				assertEquals(modelColorItr.next(), listenerColorItr.next());
				assertEquals(modelShapeItr.next(), listenerShapeItr.next());
			}
		}
	}
	
	@After
	public void tearDown() {
		colors.clear();
		shapes.clear();
		model.clearDrawing();
		for(ICanvasListener listener: listeners) {
			model.unregister(listener);
		}
	}
}
