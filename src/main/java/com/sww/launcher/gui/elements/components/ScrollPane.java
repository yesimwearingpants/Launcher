package com.sww.launcher.gui.elements.components;

import java.awt.Component;

import javax.swing.JScrollPane;

import com.sww.launcher.events.IListener;

@SuppressWarnings("serial")
public class ScrollPane extends JScrollPane {

	private IListener iListener;

	public ScrollPane() {
		super();
	}

	public ScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
	}

	public ScrollPane(Component view) {
		super(view);
	}

	public ScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
	}

	public void addIListener(IListener listener) {
		iListener = listener;
	}

	public IListener getIListener() {
		return iListener;
	}

}
