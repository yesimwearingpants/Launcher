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
