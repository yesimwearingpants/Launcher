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
package com.sww.launcher.util;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class Maths {

	/**
	 * Creates a VAO transformation matrix.
	 *
	 * @param translation the translation
	 * @param rx the X rotation
	 * @param ry the Y rotation
	 * @param rz the Z rotation
	 * @param scale the scale
	 * @return the matrix4f
	 */
	public static Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry, float scaleX,  float scaleY) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0), matrix, matrix);
		Matrix4f.scale(new Vector3f(scaleX, scaleY, 0.0f), matrix, matrix);
		return matrix;
	}

	/**
	 * Translates a VAOs position
	 *
	 * @param translation the translation
	 * @return the matrix4f
	 */
	public static Matrix4f createTranslationMatrix(Vector3f translation) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		return matrix;
	}

	/**
	 * Scales a VAO
	 *
	 * @param scaleX the scale x
	 * @param scaleY the scale y
	 * @return the matrix4f
	 */
	public static Matrix4f createScaleMatrix(float scaleX, float scaleY) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.scale(new Vector3f(scaleX, scaleY, 1.0f), matrix, matrix);
		return matrix;
	}

}
