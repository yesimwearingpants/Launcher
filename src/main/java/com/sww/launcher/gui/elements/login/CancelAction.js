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
package com.sww.launcher.gui.elements.login;

//import static com.sww.launcher.gui.elements.login.LoginPanel.CANCEL_LOGIN_ACTION_COMMAND;
//import static com.sww.launcher.gui.elements.login.LoginPanel.CLASS_NAME;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import org.jdesktop.swingx.action.AbstractActionExt;
import org.jdesktop.swingx.plaf.UIManagerExt;

/**
 * Action that cancels the login procedure.
 */
final class CancelAction extends AbstractActionExt {
    private static final long serialVersionUID = 4040029973355439229L;
    private LoginPanel panel;
    public CancelAction(LoginPanel p) {
        super(UIManagerExt.getString(CLASS_NAME + ".cancelLogin", p.getLocale()), CANCEL_LOGIN_ACTION_COMMAND);
        this.panel = p;
        this.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.cancelLogin();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {}
}