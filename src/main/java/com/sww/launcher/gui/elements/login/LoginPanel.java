/**
 * This is a Modified Version of JXLoginPane from SwingX
 * 
 * Originally licensed under GNU Lesser General Public
 * License as published by the Free Software Foundation
 * version 2.1
 */
package com.sww.launcher.gui.elements.login;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.sww.launcher.gui.elements.components.Combox;
import com.sww.launcher.gui.elements.components.Panel;

/**
 * @author namae
 */
@SuppressWarnings("serial")
public class LoginPanel extends Panel {
    private Panel loginPanel;
    private boolean isMediaPanel = true;
    private final List<String> servers;
    
    public LoginPanel() {
        this.servers = new ArrayList<>();
        servers.add("https://thisyear.me");
        servers.add("https://github.com");
    }

	public Panel createPanel() {
        GridBagConstraints gridBagConstraints;
        JTextField usernameField = new JTextField();
        Panel outerPanel = new Panel();
        Panel firstPanel = new Panel();
        Panel secondPanel = new Panel();
        JLabel colonSpaceLabel0 = new JLabel();
        JLabel colonSpaceLabel1 = new JLabel();
        JLabel colonSpaceLabel2 = new JLabel();
        JLabel serverLabel = new JLabel();
        JLabel errorMessageLabel = new JLabel();
        JLabel forgotPassword = new JLabel();
        Panel innerPanel = new Panel();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton();
        JLabel passwordLabel = new JLabel();
        Combox<String> serverCombo = new Combox<>(servers);
        JLabel usernameLabel = new JLabel();
        JCheckBox saveCB = new JCheckBox();
        outerPanel.setLayout(new GridBagLayout());

        firstPanel.setLayout(new GridBagLayout());

        errorMessageLabel.setFont(new Font("Dialog", 1, 8)); // NOI18N
        errorMessageLabel.setText("jLabel1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(5, 62, 0, 0);
        firstPanel.add(errorMessageLabel, gridBagConstraints);

        usernameLabel.setText("Username");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 15, 0, 0);
        firstPanel.add(usernameLabel, gridBagConstraints);

        passwordLabel.setText("Password");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 12, 0, 0);
        firstPanel.add(passwordLabel, gridBagConstraints);

        colonSpaceLabel0.setText(":");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 5, 0, 8);
        firstPanel.add(colonSpaceLabel0, gridBagConstraints);

        colonSpaceLabel1.setText(":");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 4, 0, 6);
        firstPanel.add(colonSpaceLabel1, gridBagConstraints);

        usernameField.setText("jTextField1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(7, 0, 0, 0);
        firstPanel.add(usernameField, gridBagConstraints);

        passwordField.setText("jTextField1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(7, 0, 0, 0);
        firstPanel.add(passwordField, gridBagConstraints);

        forgotPassword.setFont(new Font("Dialog", 1, 10)); // NOI18N
        forgotPassword.setText("Forgot Password?");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        firstPanel.add(forgotPassword, gridBagConstraints);

        saveCB.setFont(new Font("Dialog", 1, 10)); // NOI18N
        saveCB.setText("Save Login");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(8, 0, 0, 39);
        firstPanel.add(saveCB, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = GridBagConstraints.RELATIVE;
        gridBagConstraints.ipadx = -73;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        outerPanel.add(firstPanel, gridBagConstraints);

        secondPanel.setLayout(new GridBagLayout());

        if(servers != null && servers.size() > 1) {
            serverLabel.setText("Login Server");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
            gridBagConstraints.insets = new Insets(5, 46, 0, 4);
            secondPanel.add(serverLabel, gridBagConstraints);

            colonSpaceLabel2.setText(":");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(5, 3, 0, 3);
            secondPanel.add(colonSpaceLabel2, gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 4;
            gridBagConstraints.ipadx = 109;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            secondPanel.add(serverCombo, gridBagConstraints);


            loginButton.setText("Login");
            loginButton.setPreferredSize(new Dimension(95, 30));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.ipadx = 64;
            gridBagConstraints.ipady = 15;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(19, 0, 0, 0);
            secondPanel.add(loginButton, gridBagConstraints);

            innerPanel.setMinimumSize(new Dimension(150, 50));
            innerPanel.setPreferredSize(new Dimension(180, 50));

            if(isMediaPanel) {
                innerPanel.setLayout(new GridLayout(2, 3));
                innerPanel.add(createMediaPanel());
            }

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 60;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(12, 51, 0, 39);
            secondPanel.add(innerPanel, gridBagConstraints);
            
        } else {
            loginButton.setText("Login");
            loginButton.setPreferredSize(new Dimension(95, 30));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.ipadx = 64;
            gridBagConstraints.ipady = 15;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(39, 0, 0, 0);
            secondPanel.add(loginButton, gridBagConstraints);

            innerPanel.setMinimumSize(new Dimension(150, 50));
            innerPanel.setPreferredSize(new Dimension(180, 50));

            if(isMediaPanel) {
                innerPanel.setLayout(new GridLayout(2, 3));
                innerPanel.add(createMediaPanel());
            }

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 60;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(32, 51, 0, 39);
            secondPanel.add(innerPanel, gridBagConstraints);
        
        }

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = GridBagConstraints.RELATIVE;
        gridBagConstraints.ipadx = -79;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(0, 6, 0, 0);
        outerPanel.add(secondPanel, gridBagConstraints);
        return outerPanel;
    }

	private Panel createProgressPanel() {
		
            JProgressBar progressBar = new JProgressBar();
            JLabel progressMessageLabel = new JLabel();
            JButton cancelButton = new JButton();
            Panel panel = new Panel(new FlowLayout());

            panel.add(progressMessageLabel);
            panel.add(progressBar);
            panel.add(cancelButton);
            return panel;
	}
	
	private Panel createMediaPanel() {
		
            JButton twitter = new JButton();
            JButton gPlus = new JButton();
            JButton facebook = new JButton();
            JButton othermedia = new JButton();
            JButton othermedia2 = new JButton();
            JButton othermedia3 = new JButton();

            Panel panel = new Panel(new GridLayout(2, 3));

            twitter.setIcon(null);
            gPlus.setIcon(null);
            facebook.setIcon(null);
            othermedia.setIcon(null);
            othermedia2.setIcon(null);
            othermedia3.setIcon(null);

            panel.add(twitter);
            panel.add(gPlus);
            panel.add(facebook);
            panel.add(othermedia);
            panel.add(othermedia2);
            panel.add(othermedia3);
            return loginPanel = panel;
	}
	
    /**
     * Recreates the login panel, and replaces the current one with the new one
     */
    protected void recreateLoginPanel() {
        Panel old = loginPanel;
        loginPanel = createPanel();
        getParent().remove(old);
        getParent().add(loginPanel);
    }
    
}