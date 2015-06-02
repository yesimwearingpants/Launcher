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