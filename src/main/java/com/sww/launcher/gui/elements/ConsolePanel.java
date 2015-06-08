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
package com.sww.launcher.gui.elements;

import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.JTextArea;

import com.sww.launcher.gui.elements.components.ConsoleStream;
import com.sww.launcher.gui.elements.components.ScrollPane;

@SuppressWarnings("serial")
public class ConsolePanel extends ScrollPane {

	private static JTextArea console = new JTextArea();

	public ConsolePanel() {
		PrintStream ps = new PrintStream(new ConsoleStream(console, 1000));

		setPreferredSize(new Dimension(705, 225));
		console.setEditable(false);
		setViewportView(console);
		System.setOut(ps);
		System.setErr(ps);
	}

}
