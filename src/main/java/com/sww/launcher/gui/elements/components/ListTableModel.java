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
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    public void newDataAvailable(TableModelEvent event) {
        fireTableChanged(event);
    }

    private void justifyRows(int from, int to) {

        for (int i = from; i < to; i++) {
            if (dataVector.get(i) == null) {
                dataVector.set(i, new ArrayList<>());
            }
            dataVector.get(i);
        }
    }

    public void setNumRows(int rowCount) {
        int old = getRowCount();
        if (old == rowCount) {
            return;
        }
        if (rowCount <= old) {
            fireTableRowsDeleted(rowCount, old-1);
        }
        else {
            justifyRows(old, rowCount);
            fireTableRowsInserted(old, rowCount-1);
        }
    }

    public void setRowCount(int rowCount) {
        setNumRows(rowCount);
    }

    private static int gcd(int i, int j) {
        return (j == 0) ? i : gcd(j, i%j);
    }

    private static List rotate(List v, int a, int b, int shift) {
        int size = b - a;
        int r = size - shift;
        int g = gcd(size, r);
        for(int i = 0; i < g; i++) {
            int to = i;
            Object tmp = v.get(a + to);
            for(int from = (to + r) % size; from != i; from = (to + r) % size) {
                v.set((a + to), v.get(a + from));
                to = from;
            }
            v.set(a + to, tmp);
        }
        return v;
    }

    public void moveRow(int start, int end, int to) {
        int shift = to - start;
        int first, last;
        if (shift < 0) {
            first = to;
            last = end;
        }
        else {
            first = start;
            last = to + end - start;
        }
        rotate(dataVector, first, last + 1, shift);

        fireTableRowsUpdated(first, last);
    }

    public void removeRow(int row) {
        dataVector.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void setColumnIdentifiers(Object[] columnIdentifiers) {
        setDataVector(dataVector, columnIdentifiers);
    }

    public void setColumnCount(int columnCount) {
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    public void addColumn(Object columnName) {
        addColumn(columnName, (List)null);
    }

    public void addColumn(Object columnName, List columnData) {
        if (columnData != null) {
            int columnSize = columnData.size();
            justifyRows(0, getRowCount());
            int newColumn = getColumnCount() - 1;
            for(int i = 0; i < columnSize; i++) {
                  List row = (List)dataVector.get(i);
                  row.set(newColumn, columnData.get(i));
            }
        }
        else {
            justifyRows(0, getRowCount());
        }

        fireTableStructureChanged();
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    public String getColumnName(int column) {
        Object id = null;
        // This test is to cover the case when
        // getColumnCount has been subclassed by mistake ...
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

    public void setValueAt(Object aValue, int row, int column) {
        List rowVector = (List)dataVector.get(row);
        rowVector.set(column, aValue);
        fireTableCellUpdated(row, column);
    }

}