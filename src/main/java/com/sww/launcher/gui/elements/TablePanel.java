package com.sww.launcher.gui.elements;

import javax.swing.JTable;

import com.sww.launcher.gui.elements.components.ListTableModel;
import com.sww.launcher.gui.elements.components.ScrollPane;
import com.sww.launcher.variables.Reference;

@SuppressWarnings("serial")
public class TablePanel extends ScrollPane {

	private static JTable table = new JTable();

	private static ListTableModel model = new ListTableModel(Reference.TableListofLists,
		Reference.TableList);


	public TablePanel() {
		
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

}