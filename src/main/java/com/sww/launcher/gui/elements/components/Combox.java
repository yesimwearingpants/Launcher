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
