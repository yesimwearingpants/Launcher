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