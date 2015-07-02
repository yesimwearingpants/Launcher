/**
 * Copyright (c) 2015 Greg Wright
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * @author yesimwearingpants
 * Created Jul 2, 2015
 */
package com.sww.launcher.draw.shader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

public abstract class ShaderProgram {

	/** The fragment shader id. */
	private int programID, vertexShaderID, fragmentShaderID;
	private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);

	/**
	 * Instantiates a new shader program.
	 *
	 * @param vs the Vertex Shader
	 * @param fs the Fragment Shader
	 */
	public ShaderProgram(String vs, String fs) {
		vertexShaderID = loadShader(vs, GL20.GL_VERTEX_SHADER);
		fragmentShaderID = loadShader(fs, GL20.GL_FRAGMENT_SHADER);
		programID = GL20.glCreateProgram();
		GL20.glAttachShader(programID, vertexShaderID);
		GL20.glAttachShader(programID, fragmentShaderID);
		bindAttributes();
		GL20.glLinkProgram(programID);
		GL20.glValidateProgram(programID);
		getAllUniformLocations();
	}

	protected void loadFloat(int location, float value) {
		GL20.glUniform1f(location, value);
	}

	protected void loadVector(int location, Vector2f vector) {
		GL20.glUniform2f(location, vector.x, vector.y);
	}

	protected void loadBoolean(int location, boolean value) {
		float toLoad = 0;
		if(value) {
			toLoad = 1;
		}
		GL20.glUniform1f(location, toLoad);
	}

	protected void loadMatrix(int location, Matrix4f matrix) {
		matrix.store(matrixBuffer);
		matrixBuffer.flip();
		GL20.glUniformMatrix4(location, false, matrixBuffer);
	}

	protected abstract void getAllUniformLocations();

	protected int getUniformLocation(String uniformLocation) {
		return GL20.glGetUniformLocation(programID, uniformLocation);
	}

	/**
	 * Start the Shader
	 */
	public void start() {
		GL20.glUseProgram(programID);
	}

	/**
	 * Stop the Shader
	 */
	public void stop() {
		GL20.glUseProgram(0);
	}

	/**
	 * Clean up.
	 */
	public void cleanUp() {
		stop();
		GL20.glDetachShader(programID, vertexShaderID);
		GL20.glDetachShader(programID, fragmentShaderID);
		GL20.glDeleteShader(vertexShaderID);
		GL20.glDeleteShader(fragmentShaderID);
		GL20.glDeleteProgram(programID);
	}

	protected abstract void bindAttributes();

	/**
	 * Bind attribute.
	 *
	 * @param attrib the attribute position
	 * @param varName the variable name in file
	 */
	protected void bindAttribute(int attrib, String varName) {
		GL20.glBindAttribLocation(programID, attrib, varName);
	}

	/**
	 * Load shader.
	 *
	 * @param file the Shader file
	 * @param type the type of Shader
	 * @return the ShaderID
	 */
	private static int loadShader(String file, int type) {
		StringBuilder shaderSource = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		int shaderID = GL20.glCreateShader(type);
		GL20.glShaderSource(shaderID, shaderSource);
		GL20.glCompileShader(shaderID);
		if(GL20.glGetShaderi(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.out.println(GL20.glGetShaderInfoLog(shaderID, 500));
			throw new OpenGLException("Could Not Compile");
		}
		
		return shaderID;
	}

}
