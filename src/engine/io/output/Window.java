package engine.io.output;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.*;

import engine.io.input.*;

public class Window {
	public int width , height;
	public String title;
	long time;
	int frames = 0;
	private long window;
	public KeyInput keyInputCallBack = new KeyInput();
	MouseButtonInput mouseButtonInput = new MouseButtonInput();
	MousePositionInput mPositionInput = new MousePositionInput();
	public Window(int width , int height , String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	public void create() {
		time = System.currentTimeMillis();
		if (!glfwInit()) {
			System.err.println("Couldnt init");
			System.exit(-1);
		}
		window = glfwCreateWindow(width, height, title,0, 0);
		
		if (window == 0) {
			System.err.println("cannot create window");
			System.exit(-1);
		}
		GLFWVidMode vm = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		int windowXPos = vm.width()/2 - width/2;
		int windowYPos = vm.height()/2 - height/2;
		
		glfwSetWindowPos(window, windowXPos,windowYPos);
		
		addCallback(window);
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		GL11.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		
		glfwShowWindow(window);
		glfwSwapInterval(1);
		
	}
	private void addCallback(long window2) {
		glfwSetKeyCallback(window,keyInputCallBack.getKeyCallback());
		glfwSetMouseButtonCallback(window2, mouseButtonInput.getbuttonCallback());
		glfwSetCursorPosCallback(window2, mPositionInput.getMousePositionCallback());
	}
	public void update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT |GL_DEPTH_BUFFER_BIT);
		frames++;
		if (System.currentTimeMillis() >= time + 1000) {
			glfwSetWindowTitle(window,"fps is " + frames);
			frames = 0;
			time = System.currentTimeMillis();
		}
		glfwPollEvents();
	}
	public void render() {
		
		glfwSwapBuffers(window);
	}
	public boolean shouldClose() {
		return glfwWindowShouldClose(window);
		
	}
}
