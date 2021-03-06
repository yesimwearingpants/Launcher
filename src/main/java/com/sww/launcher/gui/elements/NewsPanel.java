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
 * Created May 1, 2015
 */
package com.sww.launcher.gui.elements;

import java.awt.Dimension;

import javax.swing.JTextPane;

import com.sww.launcher.gui.elements.components.ScrollPane;

@SuppressWarnings("serial")
public class NewsPanel extends ScrollPane {

	private static JTextPane news = new JTextPane();
	
	public NewsPanel() {

		setPreferredSize(new Dimension(705, 225));
		news.setEditable(false);
		setViewportView(news);
	}

}