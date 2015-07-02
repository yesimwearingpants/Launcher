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
package com.sww.launcher.draw.gui;

import org.lwjgl.util.vector.Vector3f;

import com.sww.launcher.draw.Model;

public class Gui {

	private Model model;
	/** The position. */
	private Vector3f position;
	/** The rotations. */
	private float rotX, rotY;
	/** The X scale factor. */
	private float scalex;
	/** The Y scale factor. */
	private float scaley;

	public Gui(Model model, Vector3f position, float rotX, float rotY, float scaleX, float scaleY) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.scalex = scaleX;
		this.scaley = scaleY;
	}

	public Model getModel() {
		return model;
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getRotX() {
		return rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public float getScalex() {
		return scalex;
	}

	public float getScaley() {
		return scaley;
	}

}
