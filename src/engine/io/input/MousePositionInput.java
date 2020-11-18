package engine.io.input;

import org.lwjgl.glfw.*;

public class MousePositionInput {
	public float mousePosX , mousePosY;
	public GLFWCursorPosCallback keyCallback;
	
	public MousePositionInput(){
		keyCallback = new GLFWCursorPosCallback() {

			public void invoke(long window, double xpos, double ypos) {
				mousePosX = (float)xpos;
				mousePosY = (float)ypos;
			}
		};
	}
	
	public float getMousePosX() {
		return mousePosX;
	}

	public float getMousePosY() {
		return mousePosY;
	}

	public GLFWCursorPosCallback getMousePositionCallback() {
		return keyCallback;
	}
}
