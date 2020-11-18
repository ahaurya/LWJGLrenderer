package engine.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryUtil;

public class Mesh {
	private Vertex[] vertices;
	private int[] indices;
	private int vao , pbo , ibo;
	public Mesh(Vertex[] vertices , int[] indices) {
		this.vertices = vertices;
		this.indices = indices;
	}
	public void create() {
		vao = glGenVertexArrays();//create vao
		glBindVertexArray(vao);//bind vao

		FloatBuffer positionBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);//holds positionData
		
		float[] positionData = new float[vertices.length * 3];//holds vertices coordinate
		for (int i = 0; i < vertices.length; i++) {
			positionData[i * 3] = vertices[i].getPosition().getX();
			positionData[i * 3 + 1] = vertices[i].getPosition().getY();
			positionData[i * 3 + 2] = vertices[i].getPosition().getZ();
		}//runs thorugh all vertices coordinates and aranges them in arrays
		positionBuffer.put(positionData).flip(); // store the vertex data in position data in buffer

		pbo = glGenBuffers();//create pbo
		glBindBuffer(GL_ARRAY_BUFFER, pbo);//bind pbo
		glBufferData(GL_ARRAY_BUFFER, positionBuffer,GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
		indicesBuffer.put(indices).flip();

		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	public Vertex[] getVertices() {
		return vertices;
	}
	public int[] getIndices() {
		return indices;
	}
	public int getVAO() {
		return vao;
	}
	public int getPBO() {
		return pbo;
	}
	public int getIBO() {
		return ibo;
	}
}
