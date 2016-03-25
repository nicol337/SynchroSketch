package edu.nyu.pqs.canvas.play;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * CanvasView is the View in the MVC, it is a wrapper class for core logic
 * that goes on in DrawingArea. It mediates updates between the model and the user.
 * @author nicolelee
 *
 */
@SuppressWarnings("serial")
public class CanvasView extends JFrame implements ICanvasListener {
	private CanvasModel model;
	private JPanel buttonPanel;
	private DrawingArea drawingArea;
	
	public CanvasView(CanvasModel model) {
		this.model = model;
		this.drawingArea = new DrawingArea(this);
		model.register(this);
		this.buttonPanel = new JPanel();
		
		this.setSize(400,400);
		this.setBackground(Color.BLACK);
		this.setTitle("Canvas View Test");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buttonPanel.add(this.drawingArea.getToolBox());
		this.add(drawingArea, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void loadShapes(List<Shape> shapes, List<Color> colors) {
		this.drawingArea.loadShapes(shapes, colors);
	}
	
	@Override
	public void addShape(Shape shape, Color color) {
		this.drawingArea.addShape(shape, color);
	}
	
	@Override
	public void clearCanvas() {
		this.drawingArea.clearCanvas();
	}
	
	@Override
	public void addShapeToModel(Shape shape, Color color) {
		this.model.addNewShape(shape, color);
	}

	@Override
	public List<Color> getColorArray() {
		return this.drawingArea.getColorArray();
	}

	@Override
	public List<Shape> getShapeArray() {
		return this.drawingArea.getShapeArray();
	}
}