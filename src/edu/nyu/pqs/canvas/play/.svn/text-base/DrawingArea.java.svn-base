package edu.nyu.pqs.canvas.play;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

/**
 * DrawingArea registers with a single CanvasView. It is the graphical
 * JComponent that is nested in the CanvasView. 
 * Has button box, listeners, and drawing space that updates by the model
 * @author nicolelee
 *
 */
public class DrawingArea extends JComponent {
	private CanvasView view;
	private Point startPt;
	private Point endPt;
	private Color currentColor;
	private Shape currentShape;
	private List<Shape> shapes;
	private List<Color> colors;
	private Box toolBox;
	
	/**
	 * 
	 * @param view -- CanvasView that the DrawingArea registers with
	 */
	public DrawingArea(final CanvasView view) {
		this.view = view;
		this.startPt = new Point();
		this.endPt = new Point();
		this.currentColor = Color.WHITE;
		this.currentShape = null;
		this.shapes = new ArrayList<Shape>();
		this.colors = new ArrayList<Color>();
		
		this.toolBox = Box.createHorizontalBox();
		JButton colorButton = new JButton("Color");
		{
			colorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					currentColor = JColorChooser.showDialog(null,"Pick a color", Color.WHITE);
					System.out.println(currentColor);
				}
			});
		} this.toolBox.add(colorButton);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startPt = new Point(e.getX(), e.getY());
				endPt = startPt;
				repaint();
			}
			
			//tampered
			public void mouseReleased(MouseEvent e) {
				endPt = new Point(e.getX(), e.getY());
				currentShape = makeLine(startPt.x, startPt.y, endPt.x, endPt.y);
				view.addShapeToModel(currentShape, currentColor);
				startPt = null;
				endPt = null;
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endPt = new Point(e.getX(), e.getY());
			}
		});
	}
	
	/**
	 * return to view for JFrame layout purposes
	 * @return Box -- javax.swing.Box
	 */
	public Box getToolBox() {
		return this.toolBox;
	}
	
	/**
	 * clears the local storage of colors and shapes
	 */
	public void clearCanvas() {		
		this.startPt = null;
		this.endPt = null;
		currentColor = Color.WHITE;
		currentShape = null;
		shapes.clear();
		colors.clear();
	}
	
	/**
	 * loadShapes is called once when the view and its corresponding DrawingArea
	 * is first created.
	 * @param shapes
	 * @param colors
	 */
	public void loadShapes(List<Shape> shapes, List<Color> colors) {
		Iterator<Color> thisColorItr = this.colors.iterator();
		Iterator<Color> modelColorItr = colors.iterator();
		Iterator<Shape> modelShapeItr = shapes.iterator();
		
		while (thisColorItr.hasNext()) {
			thisColorItr.next();
			modelColorItr.next();
			modelShapeItr.next();
		}
		
		while (modelShapeItr.hasNext()) {
			addShape(modelShapeItr.next(),modelColorItr.next());
		}
		
		if (!this.shapes.isEmpty()) {
			repaint();
		}
	}
	
	/**
	 * addShape is called by model through view when a shape is added
	 * @param shape
	 * @param color
	 */
	public void addShape(Shape shape, Color color) {
		this.shapes.add(shape);
		this.colors.add(color);
		repaint();
	}
	
	/**
	 * called by paint and repaint from JComponent, redraws
	 * all the shapes stored in the local shape array with corresponding
	 * colors
	 */
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D)g;
		graphics.setStroke(new BasicStroke(3));
		Iterator<Color> colorItr = colors.iterator();
		for (Shape shape: shapes) {
			graphics.setPaint(colorItr.next());
			graphics.draw(shape);
		}
	}
	
	private Line2D.Float makeLine(int startX, int startY, int endX, int endY) {
		return new Line2D.Float(startX, startY, endX, endY);
	}
	
	/**
	 * 
	 * @return unmodifiableList of colors array
	 */
	public List<Color> getColorArray() {
		return Collections.unmodifiableList(this.colors);
	}
	
	/**
	 * 
	 * @return unmodifiableList of shape array
	 */
	public List<Shape> getShapeArray() {
		return Collections.unmodifiableList(this.shapes);
	}
}