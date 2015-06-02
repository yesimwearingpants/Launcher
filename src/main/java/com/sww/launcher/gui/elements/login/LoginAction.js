package com.sww.launcher.gui.elements.login;

//import static com.sww.launcher.gui.elements.login.LoginPanel.CLASS_NAME;
//import static com.sww.launcher.gui.elements.login.LoginPanel.LOGIN_ACTION_COMMAND;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import org.jdesktop.swingx.action.AbstractActionExt;
import org.jdesktop.swingx.plaf.UIManagerExt;

 /**
 * Action that initiates a login procedure. Delegates to JXLoginPane.startLogin
 */
final class LoginAction extends AbstractActionExt {
    private static final long serialVersionUID = 7256761187925982485L;
    private LoginPanel panel;
    public LoginAction(LoginPanel p) {
        super(UIManagerExt.getString(CLASS_NAME  + ".loginString", p.getLocale()), LOGIN_ACTION_COMMAND);
        this.panel = p;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.startLogin();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {}
}