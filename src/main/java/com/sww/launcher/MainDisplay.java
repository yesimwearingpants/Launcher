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
 * Created Jul 1, 2015
 */
package com.sww.launcher;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import com.sww.launcher.lang.I18n;

public class MainDisplay {

	boolean isLauncherOpen = false;
	boolean isGameRunning = false;
	private static int width = 720;
	private static int height = 480;

	public static void createDisplay() {
		ContextAttribs attrib = new ContextAttribs(4, 0).withForwardCompatible(true).withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create(new PixelFormat(), attrib);
			Display.setTitle(String.format("%s%s", I18n.getI18ns("game"), I18n.getI18ns("launcher")));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glViewport(0, 0, width, height);
	}

	public static void updateDisplay() {
		Display.sync(40);
		Display.update();
	}

	public static void closeDisplay() {
		Display.destroy();
	}

}
