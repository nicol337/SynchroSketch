package edu.nyu.pqs.canvas.play;

import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanvasModel {
	private List<ICanvasListener> listeners = new ArrayList<ICanvasListener>();
	private static CanvasModel INSTANCE = null;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Color> colors = new ArrayList<Color>();
	
	/**
	 * 
	 * @return Singleton CanvasModel
	 */
	public static CanvasModel getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CanvasModel();
		}
		return INSTANCE;
	}
	
	/**
	 * loadShapesToView is called once when the View is
	 * registered.
	 */
	private void loadShapesToView() {
		for (ICanvasListener listener: listeners) {
			listener.loadShapes(this.shapes, this.colors);
		}
	}
	
	/**
	 * adds a shape to this model's local storage and updates
	 * all registered listeners
	 * @param shape - java.awt.Shape 
	 * @param color - java.awt.Color
	 */
	public void addNewShape(Shape shape, Color color) {
		this.shapes.add(shape);
		this.colors.add(color);
		for (ICanvasListener listener: listeners) {
			listener.addShape(shape, color);
		}
	}
	
	/**
	 * 
	 * @return unmodifiableList of this model's color array
	 */
	public List<Color> getColorArray() {
		return Collections.unmodifiableList(this.colors);
	}
	
	/**
	 * @return unmodifiableList of this model's shape array
	 */
	public List<Shape> getShapeArray() {
		return Collections.unmodifiableList(this.shapes);
	}
	
	/**
	 * registers a ICanvasListener view with this model
	 * @param listener - ICanvasListener
	 */
	public void register(ICanvasListener listener) {
		listeners.add(listener);
		loadShapesToView();
	}

	/**
	 * unregisters a ICanvasListener view with this model
	 * @param listener
	 */
	public void unregister(ICanvasListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * 
	 * @return unmodifiableList of the registered listeners
	 */
	public List<ICanvasListener> getListeners() {
		return Collections.unmodifiableList(this.listeners);
	}
	
	/**
	 * clears all shapes and colors from model
	 * and registered views
	 */
	public void clearDrawing() {
		shapes.clear();
		colors.clear();
		for (ICanvasListener listener: listeners) {
			listener.clearCanvas();
		}
	}
}
