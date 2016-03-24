package edu.nyu.pqs.canvas.play;

/**
 * Controller of the MVC, initializes 4 Views and one Singleton model.
 * starts the CanvasApp from main
 * @author nicolelee
 *
 */
public class CanvasApp {
	
	private void startApp() {
		CanvasModel model = CanvasModel.getInstance();
		new CanvasView(model);
		new CanvasView(model);
		new CanvasView(model);
		new CanvasView(model);
	}
	
	public static void main(String[] args) {
		new CanvasApp().startApp();
	}
}