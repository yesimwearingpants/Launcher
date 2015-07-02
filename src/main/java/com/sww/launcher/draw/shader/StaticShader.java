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

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

	private static final String vs = "src/main/resources/com/sww/launcher/shaders/button.vs";
	private static final String fs = "src/main/resources/com/sww/launcher/shaders/button.fs";
	private int locationTranslationMatrix;

	/**
	 * Instantiates a new static shader.
	 */
	public StaticShader() {
		super(vs, fs);
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void getAllUniformLocations() {
		locationTranslationMatrix = super.getUniformLocation("translationMatrix");
	}

	/**
	 * Load translation matrix.
	 *
	 * @param matrix the matrix
	 */
	public void loadTranslationMatrix(Matrix4f matrix) {
		super.loadMatrix(locationTranslationMatrix, matrix);
	}

}
