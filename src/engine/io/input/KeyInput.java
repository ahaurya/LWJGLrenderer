package engine.io.input;

import org.lwjgl.glfw.*;

public class KeyInput {
	public boolean[] Keys = new boolean[65536];
	public GLFWKeyCallback keyCallback;
	
	public KeyInput(){
		keyCallback = new GLFWKeyCallback() {

			public void invoke(long window, int key, int scancode, int action, int mods) {
				Keys[key] = (action != GLFW.GLFW_RELEASE);
			}
			
		};
	}
	public boolean isKeyDown(int key) {
		return Keys[key];
	}
	public GLFWKeyCallback getKeyCallback() {
		return keyCallback;
	}
}
