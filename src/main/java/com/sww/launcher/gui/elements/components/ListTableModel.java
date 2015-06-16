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

import javax.swing.table.AbstractTableModel;

import com.sww.launcher.util.Profile;


@SuppressWarnings({"rawtypes", "unchecked"})
public class ListTableModel extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = -484663740833861175L;

    protected List dataVector;
    protected Object[] columnIdentifiers;


    public ListTableModel(List data, Object[] columnNames) {
        setData(data, columnNames);
    }

    public List getData() {
        return dataVector;
    }

    private static List nonNullList(List list) {
        return (list != null) ? list : new ArrayList<>();
    }
    
    private static Object[] nonNullArray(Object[] o) {
    	return (o != null) ? o : new Object[] {};
    }

    public void setData(List<Profile> list, Object[] columnNames) {
        this.dataVector = nonNullList(list);
        this.columnIdentifiers = nonNullArray(columnNames);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    private void justifyRows(int from, int to) {

        for (int i = from; i < to; i++) {
            if (dataVector.get(i) == null) {
                dataVector.set(i, new ArrayList<>());
            }
            dataVector.get(i);
        }
    }

    public void setColumnIdentifiers(Object[] columnIdentifiers) {
        setData(dataVector, columnIdentifiers);
    }

    public void setColumnCount(int columnCount) {
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }

    public Object getValueAt(int row, int column) {
        Profile rowVector = (Profile) dataVector.get(row);
        return rowVector.get(column);
    }

    public void setValueAt(Object aValue, int row, int column) {
        List rowVector = (List)dataVector.get(row);
        rowVector.set(column, aValue);
        fireTableCellUpdated(row, column);
    }

}