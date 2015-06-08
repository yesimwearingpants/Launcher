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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import com.sww.launcher.events.MouseEventExt;
import com.sww.launcher.events.MouseEventExt.Var;
import com.sww.launcher.gui.elements.components.ListTableModel;
import com.sww.launcher.gui.elements.components.ScrollPane;
import com.sww.launcher.reference.Reference;

@SuppressWarnings("serial")
public class TablePanel extends ScrollPane {

	private static JTable table = new JTable() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
	}	};
	private static ListTableModel model = new ListTableModel(Reference.Profiles,
		Reference.TableList);


	public TablePanel() {

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Var.setComponent(e.getComponent());
				Var.setId(e.getID());
				Var.setWhen(e.getWhen());
				Var.setModifiers(e.getModifiers());
				Var.setX(e.getX());
				Var.setY(e.getY());
				Var.setClickcount(e.getClickCount());
				Var.setButton(e.getButton());
				MouseEventExt ev = new MouseEventExt(Var.getComponent(), Var.getId(), Var.getWhen(),
					Var.getModifiers(), Var.getX(), Var.getY(), Var.getClickcount(), Var.getButton());
				clicked(ev);
			}	});
		table.setModel(model);
		setName("Table");
		setViewportView(table);
	}
	
	public static JTable getTable() {
		return table;
	}
	
	public static ListTableModel getModel() {
		return model;
	}

	public static void tableChanged() {
		model.fireTableDataChanged();
	}
	

	public void clicked(MouseEventExt e) {
		
		e.setRowInt(((JTable) e.getSource()).rowAtPoint(e.getPoint()));
		if(e.getRowInt() == table.getSelectedRow()) {
			e.setRowList(e.getRowInt());
			if(getIListener() != null) {
				getIListener().addAction(e);
			}
		}
	}

}
