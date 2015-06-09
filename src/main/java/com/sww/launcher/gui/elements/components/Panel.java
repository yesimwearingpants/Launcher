package com.sww.launcher.gui.elements.components;

import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import com.sww.launcher.events.IListener;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	private IListener iListener;

	public Panel() {
		super();
	}

	public Panel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public Panel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public Panel(LayoutManager layout) {
		super(layout);
	}

	public void addIListener(IListener listener) {
		this.iListener = listener;
	}

	public IListener getIListener() {
		return iListener;
	}

	public void reDraw() {
		Panel old = this;
		Container parent = old.getParent();
		parent.remove(old);
		parent.add(this);
		
	}

}
