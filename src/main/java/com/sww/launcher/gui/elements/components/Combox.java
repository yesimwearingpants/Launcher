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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Combox<E> extends JComboBox<E> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Combox(List<E> items) {
		setModel(new ListComboBoxModel(items));
	}
	
	@SuppressWarnings("hiding")
	public class ListComboBoxModel<E> extends AbstractListModel<E> implements ComboBoxModel<E>, ActionListener {

		private static final long serialVersionUID = 3592645827117993309L;

		/**
	     * A key used to notify the model that the backing {@code List} has changed.
	     */
	    public static final String UPDATE = "update";
	    
	    /**
	     * A reference to the list backing this model.
	     * <p>
	     * This model does <b>not</b> make a copy of the list, so any changes in
	     * the list without synchronizing the model may have drastic effects.
	     */
	    protected final List<E> data;
	    
	    /**
	     * The currently selected item.
	     */
	    protected E selected;
	    
	    /**
	     * Creates a {@code ListComboBoxModel} backed by the supplied {@code list}.
	     * 
	     * @param list
	     *                the list backing this model
	     * @throws NullPointerException
	     *                 if {@code list} is {@code null}
	     */
	    public ListComboBoxModel(List<E> list) {
	        this.data = list;
	        
	        if(list.size() > 0) {
	            selected = list.get(0);
	        }
	    }
	    
	    /**
	     * Set the selected item. The implementation of this method should notify
	     * all registered {@code ListDataListener}s that the contents have changed.
	     * 
	     * @param item
	     *                the list object to select or {@code null} to clear the
	     *                selection
	     * @throws ClassCastException
	     *                 if {@code item} is not of type {@code E}
	     */
	    @Override
	    @SuppressWarnings("unchecked")
	    public void setSelectedItem(Object item) {
	        if ((selected != null && !selected.equals(item))
	                || selected == null && item != null) {
	            selected = (E) item;
	            fireContentsChanged(this, -1, -1);
	        }
	    }
	    
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public E getSelectedItem() {
	        return this.selected;
	    }
	    
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public E getElementAt(int index) {
	        return data.get(index);
	    }
	    
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public int getSize() {
	        return data.size();
	    }
	    
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	        if(evt.getActionCommand().equals(UPDATE)) {
	            this.fireContentsChanged(this, 0, getSize() - 1);
	        }
	    }
	}

}
