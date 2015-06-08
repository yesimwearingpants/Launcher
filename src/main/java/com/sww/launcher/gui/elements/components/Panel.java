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
 * Created April 30, 2015
 */
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
