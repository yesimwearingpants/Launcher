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
 * Created May 23, 2015
 */
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
