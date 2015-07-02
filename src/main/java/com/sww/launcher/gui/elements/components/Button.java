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
 * Created June 17, 2015
 */
package com.sww.launcher.gui.elements.components;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class Button extends JButton {

	private static final long serialVersionUID = -6178312516206053897L;

	public Button() {
		super();
		setBorder(null);
		setBorderPainted(false);
	}

	public Button(Action a) {
		super(a);
		setBorder(null);
		setBorderPainted(false);
	}

	public Button(Icon icon) {
		super(icon);
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false); 
	}

	public Button(String text, Icon icon) {
		super(text, icon);
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false); 
	}

	public Button(String text) {
		super(text);
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false); 
	}

}
