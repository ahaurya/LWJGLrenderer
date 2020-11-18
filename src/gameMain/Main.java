package gameMain;

import engine.graphics.*;
import engine.io.output.Window;
import engine.math.Vector3f;

public class Main implements Runnable{
	
	public Thread thread;
	boolean running = false;
	
	Window window;
	private Mesh mesh;
	private Renderer renderer;
	public static void main(String []args) {
		//the start method calling
		new Main().start();
	}

	private void start() {
		//starting the runnable run method
		running = true;
		thread = new Thread(this , "Game Thread");
		thread.start();
	}

	public void run() {
		//gameloop and initialization method call
		init();
		while (running) {
			update();
			render();
			if (window.shouldClose()) {
				running = false;
			}
		}
	}
	
	private void init() {
		
		window = new Window(900,510,"My Game");
		window.create();

		mesh = new Mesh(
				new Vertex[] {
						new Vertex(new Vector3f(0.0f,0.0f,0.0f)),
						new Vertex(new Vector3f(0.0f,0.0f,0.0f)),
						new Vertex(new Vector3f(0.0f,0.0f,0.0f)),
						new Vertex(new Vector3f(0.0f,0.0f,0.0f))
				},new int[] {
						0,1,2,0,3,2
				}
				);
		mesh.create();
	}
	
	private void render() {
		
		window.render();
	}

	private void update() {
		renderer.renderMesh(mesh);
		window.update();
	}

	
}
