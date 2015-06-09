package com.sww.launcher.gui.elements.components;

import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.swingx.combobox.ListComboBoxModel;

@SuppressWarnings("serial")
public class Combox<E> extends JComboBox<E> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Combox(List<E> items) {
		setModel(new ListComboBoxModel(items));
	}

}
