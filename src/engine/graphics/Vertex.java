package engine.graphics;

import engine.math.Vector3f;

public class Vertex {
	Vector3f position;
	
	public Vertex(Vector3f position) {
		this.position = position;
	}
	public Vector3f getPosition() {
		return position;
	}
}
