/*
 * $Id: AbstractBean.java 4088 2011-11-17 19:53:49Z kschaefe $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.sww.launcher.util.login;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;


@SuppressWarnings("nls")
public abstract class AbstractBean {

    private transient PropertyChangeSupport pcs;
    private transient VetoableChangeSupport vcs;

    protected AbstractBean() {
        pcs = new PropertyChangeSupport(this);
        vcs = new VetoableChangeSupport(this);
    }

    protected AbstractBean(PropertyChangeSupport pcs, VetoableChangeSupport vcs) {
        if (pcs == null) {
            throw new NullPointerException("PropertyChangeSupport must not be null");
        }
        if (vcs == null) {
            throw new NullPointerException("VetoableChangeSupport must not be null");
        }
        
        this.pcs = pcs;
        this.vcs = vcs;
    }

    public final void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public final void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public final PropertyChangeListener[] getPropertyChangeListeners() {
        return pcs.getPropertyChangeListeners();
    }

    public final void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public final void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public final PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
            return pcs.getPropertyChangeListeners(propertyName);
    }

    protected final void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected final void firePropertyChange(PropertyChangeEvent evt) {
        pcs.firePropertyChange(evt);
    }

    protected final void fireIndexedPropertyChange(String propertyName, int index,
                      Object oldValue, Object newValue) {
    pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }

    protected final boolean hasPropertyChangeListeners(String propertyName) {
        return pcs.hasListeners(propertyName);
    }

    protected final boolean hasVetoableChangeListeners(String propertyName) {
        return vcs.hasListeners(propertyName);
    }

    public final void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }

    public final void removeVetoableChangeListener(VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(listener);
    }

    public final VetoableChangeListener[] getVetoableChangeListeners(){
        return vcs.getVetoableChangeListeners();
    }

    public final void addVetoableChangeListener(String propertyName,
                VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(propertyName, listener);
    }

    public final void removeVetoableChangeListener(String propertyName,
                VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(propertyName, listener);
    }

    public final VetoableChangeListener[] getVetoableChangeListeners(String propertyName) {
        return vcs.getVetoableChangeListeners(propertyName);
    }

    protected final void fireVetoableChange(String propertyName, 
                    Object oldValue, Object newValue)
                    throws PropertyVetoException {
        vcs.fireVetoableChange(propertyName, oldValue, newValue);
    }

    protected final void fireVetoableChange(PropertyChangeEvent evt)
                    throws PropertyVetoException {
        vcs.fireVetoableChange(evt);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        AbstractBean result = (AbstractBean) super.clone();
        result.pcs = new PropertyChangeSupport(result);
        result.vcs = new VetoableChangeSupport(result);
        return result;
    }
}