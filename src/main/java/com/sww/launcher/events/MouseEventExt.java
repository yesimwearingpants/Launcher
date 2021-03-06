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
 * Created May 29, 2015
 */
package com.sww.launcher.events;

import java.awt.Component;
import java.awt.event.MouseEvent;

import com.sww.launcher.reference.Reference;
import com.sww.launcher.util.Profile;

@SuppressWarnings("serial")
public class MouseEventExt extends MouseEvent {
	
	private static int row;
	private static Profile list;

	public MouseEventExt(Component source, int id, long when, int modifiers, int x, int y,
			int clickCount, int button) {
		super(source, id, when, modifiers, x, y, clickCount, false, button);
	}

	public void setRowInt(int rowAtPoint) {
		MouseEventExt.row = rowAtPoint;
	}

	public int getRowInt() {
		return row;
	}

	public void setRowList(int row) {
		list = Reference.Profiles.get(row);
	}
	
	public static Profile getRowList() {
		return list;
	}

	public static class Var {
		private static Component component;
		private static long when;
		private static int id, modifiers, x, y, clickcount, button;
		
		public static Component getComponent() {
			return Var.component;
		}
		public static void setComponent(Component component) {
			Var.component = component;
		}
		public static long getWhen() {
			return Var.when;
		}
		public static void setWhen(long when) {
			Var.when = when;
		}
		public static int getId() {
			return Var.id;
		}
		public static void setId(int id) {
			Var.id = id;
		}
		public static int getModifiers() {
			return Var.modifiers;
		}
		public static void setModifiers(int modifiers) {
			Var.modifiers = modifiers;
		}
		public static int getX() {
			return Var.x;
		}
		public static void setX(int x) {
			Var.x = x;
		}
		public static int getY() {
			return Var.y;
		}
		public static void setY(int y) {
			Var.y = y;
		}
		public static int getClickcount() {
			return Var.clickcount;
		}
		public static void setClickcount(int clickcount) {
			Var.clickcount = clickcount;
		}
		public static int getButton() {
			return Var.button;
		}
		public static void setButton(int button) {
			Var.button = button;
		}
	}

}
