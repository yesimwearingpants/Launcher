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
