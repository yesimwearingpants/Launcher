package com.sww.launcher.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial", "unchecked", "rawtypes"})
public class ListTableModel<E> extends AbstractTableModel implements Serializable {
	
	List<List<E>> listlists;
	List<E> list0;

	public <T extends List> ListTableModel(T listoflists, T list) {
		listoflists = (T) new ArrayList<List<E>>();
		this.listlists = (T) listoflists;
		list = (T) new ArrayList<E>();
		this.list0 = (T) list;
		this.isEmpty();
		
	}

	@Override
	public int getRowCount() {
		return listlists.size();
	}

	@Override
	public int getColumnCount() {
		return list0.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<E> list1 =  listlists.get(rowIndex);
		return list1.get(columnIndex);
	}
	
    public void setValueAt(Object aValue, int row, int column) {
        ArrayList rowlist = (ArrayList) listlists.get(row);
        rowlist.set(column, aValue);
        fireTableCellUpdated(row, column);
    }
    
    public boolean isCellEditable(int row, int column) {
    	if(column < 3) {
    		return true;
    	} else {
    		return false;
    	}
    }

    //Add this Later "ListIterator"
	//public boolean contains(Object o) {return false; }

	public void clear() {
		listlists.clear();
	}
	
	private boolean isEmpty() {
		if(listlists == null) {
			List list1 = new ArrayList<Object>();
			for(int i = 0; i < 3; i++) {
				list1.add("");
			}
			listlists = (List) new ArrayList<List<Object>>();
			for(int i = 0; i < 3; i++) {
				listlists.add(list1);
			}
			return true;
		} else if(listlists.isEmpty()) {
			List list1 = new ArrayList<Object>();
			for(int i = 0; i < 3; i++) {
				list1.add("");
			}
			listlists = (List) new ArrayList<List<Object>>();
			for(int i = 0; i < 3; i++) {
				listlists.add(list1);
			}
			return true;
		} else {
			return false;
		}
	}

}
