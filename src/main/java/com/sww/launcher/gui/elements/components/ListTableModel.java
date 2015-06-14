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
 * Created Mar 30, 2015
 */
package com.sww.launcher.gui.elements.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import com.sww.launcher.util.Profile;


@SuppressWarnings({"rawtypes", "unchecked"})
public class ListTableModel extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = -484663740833861175L;

    protected List dataVector;
    protected Object[] columnIdentifiers;


    public ListTableModel(List data, Object[] columnNames) {
        setDataVector(data, columnNames);
    }

    public List getDataVector() {
        return dataVector;
    }

    private static List nonNullVector(List list) {
        return (list != null) ? list : new ArrayList<>();
    }
    
    private static Object[] nonNullArray(Object[] o) {
    	return (o != null) ? o : new Object[] {};
    }

    public void setDataVector(List<Profile> list, Object[] columnNames) {
        this.dataVector = nonNullVector(list);
        this.columnIdentifiers = nonNullArray(columnNames);
        fireTableStructureChanged();
    }

    public void newDataAvailable(TableModelEvent event) {
        fireTableChanged(event);
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    public String getColumnName(int column) {
        Object id = null;
        if (column < columnIdentifiers.length && (column >= 0)) {
            id = columnIdentifiers[column];
        }
        return (id == null) ? super.getColumnName(column)
                            : id.toString();
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }

    public Object getValueAt(int row, int column) {
        Profile rowVector = (Profile) dataVector.get(row);
        return rowVector.get(column);
    }

}