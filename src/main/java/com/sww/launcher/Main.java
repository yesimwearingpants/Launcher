/**
 * Copyright (c) 2015 Greg Wright
 *	
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sub-license, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the terms of the MIT License
 * 
 * @author yesimwearingpants
 * Created Mar 22, 2015
 */
package com.sww.launcher;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import com.sww.launcher.draw.Loader;
import com.sww.launcher.draw.Model;
import com.sww.launcher.draw.gui.Gui;
import com.sww.launcher.draw.render.Renderer;
import com.sww.launcher.draw.shader.StaticShader;

public class Main {

	static float[] vertices = {-0.5f, 0.5f, -0.3f, -0.5f, -0.5f, -0.3f, 0.5f, -0.5f, -0.3f, 0.5f, 0.5f, -0.3f};
	static int[] indices = {0, 1, 3, 3, 1, 2};

	public static void main(String[] args) {
		MainDisplay.createDisplay();
		Loader load = new Loader();
		Model model = load.loadToVAO(vertices, indices);
		Gui gui = new Gui(model, new Vector3f(0,0,0),0,0,0.3f,0.3f);
		Renderer render = new Renderer();
		StaticShader shader = new StaticShader();
		while(!Display.isCloseRequested()) {
			render.prepare();
			shader.start();
			render.render(gui, shader);
			shader.stop();
			MainDisplay.updateDisplay();
		}
		shader.cleanUp();
		load.cleanUp();
		MainDisplay.closeDisplay();
	}

}
