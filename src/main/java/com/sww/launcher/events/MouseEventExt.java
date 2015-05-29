package com.sww.launcher.events;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.sww.launcher.variables.Reference;

@SuppressWarnings("serial")
public class MouseEventExt extends MouseEvent {
	
	private static int row;
	private static ArrayList<String> list;

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
		list = Reference.TableListofLists.get(row);
	}
	
	public static ArrayList<String> getRowList() {
		return list;
	}

	public static int d0() {
		if(list != null) {
			String string = (String) list.get(1);
			int i = 0;
			while (!string.equals(Reference.Versions.get(i)) && i < (Reference.Versions.size()-1)) {
				 i++;
			}
			return i;
		}
		return 0;
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
