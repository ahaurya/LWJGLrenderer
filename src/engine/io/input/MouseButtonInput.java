package engine.io.input;

import org.lwjgl.glfw.*;

public class MouseButtonInput {
	public boolean[] Buttons = new boolean[65536];
	public GLFWMouseButtonCallback buttonCallback;
	
	public MouseButtonInput(){
		buttonCallback = new GLFWMouseButtonCallback() {

			@Override
			public void invoke(long window, int button, int action, int mods) {
				Buttons[button] = (action != GLFW.GLFW_RELEASE);
			}
		};
	}
	public boolean isbuttonDown(int button) {
		return Buttons[button];
	}
	public GLFWMouseButtonCallback getbuttonCallback() {
		return buttonCallback;
	}
}
