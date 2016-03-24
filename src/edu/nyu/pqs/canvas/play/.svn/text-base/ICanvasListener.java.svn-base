package edu.nyu.pqs.canvas.play;

import java.awt.Color;
import java.awt.Shape;
import java.util.List;

public interface ICanvasListener {
	/**
	 * loads shapes from the model to the DrawingArea of the view
	 * @param shapes -- model's java.awt.Shape array
	 * @param colors -- model's java.awt.Color array
	 */
	void loadShapes(List<Shape> shapes, List<Color> colors);
	
	/**
	 * method for the model to add shape to a view 
	 * @param shape 
	 * @param color
	 */
	void addShape(Shape shape, Color color);
	
	/**
	 * method for view to trigger model to add shape to master
	 * list and then popualte registered views
	 * @param shape
	 * @param color
	 */
	void addShapeToModel(Shape shape, Color color);
	
	/**
	 * 
	 * @return unmodifiableList of the view's local color array
	 */
	List<Color> getColorArray();
	
	/**
	 * 
	 * @return unmodifiableList of the view's local shape array
	 */
	List<Shape> getShapeArray();
	
	/**
	 * clear's the local shape and color array, repaints the drawingArea
	 * to be blank
	 */
	void clearCanvas();
}
