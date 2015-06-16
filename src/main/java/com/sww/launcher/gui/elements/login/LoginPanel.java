/**
 * This is a Modified Version of JXLoginPane from SwingX
 * 
 * Originally licensed under GNU Lesser General Public
 * License as published by the Free Software Foundation
 * version 2.1
 * 
 *  Created Mar 14, 2015
 */
package com.sww.launcher.gui.elements.login;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXHyperlink;

import com.sww.launcher.gui.elements.components.Combox;
import com.sww.launcher.gui.elements.components.Panel;

import static com.sww.launcher.Main.i18n;

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
        JXHyperlink forgotPassword = new JXHyperlink();
        Panel innerPanel = new Panel();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton();
        JLabel passwordLabel = new JLabel();
        Combox<String> serverCombo = new Combox<>(servers);
        JLabel usernameLabel = new JLabel();
        JCheckBox saveCB = new JCheckBox();
        outerPanel.setLayout(new GridBagLayout());
        firstPanel.setLayout(new GridBagLayout());

        errorMessageLabel.setFont(new Font("Dialog", 1, 8));
        errorMessageLabel.setText("");
        errorMessageLabel.setVisible(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(5, 62, 0, 0);
        firstPanel.add(errorMessageLabel, gridBagConstraints);

        usernameLabel.setFont(new Font("Dialog", 1, 12));
        usernameLabel.setText(i18n.lang.getString("username"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(12, 15, 0, 0);
        firstPanel.add(usernameLabel, gridBagConstraints);

        passwordLabel.setText(i18n.lang.getString("password"));
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
        forgotPassword.setText(i18n.lang.getString("forgot"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        firstPanel.add(forgotPassword, gridBagConstraints);

        saveCB.setFont(new Font("Dialog", 1, 10)); // NOI18N
        saveCB.setText(i18n.lang.getString("saveLogin"));
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
        gridBagConstraints.ipady = 39;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        outerPanel.add(firstPanel, gridBagConstraints);

        secondPanel.setLayout(new GridBagLayout());

        if(servers != null && servers.size() > 1) {
            serverLabel.setText(i18n.lang.getString("server"));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 8;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
            gridBagConstraints.insets = new Insets(5, 46, 0, 4);
            secondPanel.add(serverLabel, gridBagConstraints);

            colonSpaceLabel2.setText(":");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 9;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(5, 3, 0, 3);
            secondPanel.add(colonSpaceLabel2, gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 10;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 4;
            gridBagConstraints.ipadx = 109;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            secondPanel.add(serverCombo, gridBagConstraints);

            loginButton.setText(i18n.lang.getString("login"));
            loginButton.setPreferredSize(new Dimension(95, 30));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 7;
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
                innerPanel.add(createMediaPanel());
            }

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 11;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 64;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(3, 51, 0, 39);
            secondPanel.add(innerPanel, gridBagConstraints);
            
        } else {
            loginButton.setText(i18n.lang.getString("login"));
            loginButton.setPreferredSize(new Dimension(95, 30));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 7;
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
                innerPanel.add(createMediaPanel());
            }

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 11;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipadx = 24;
            gridBagConstraints.ipady = 64;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(20, 51, 0, 39);
            secondPanel.add(innerPanel, gridBagConstraints);
        
        }

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = GridBagConstraints.RELATIVE;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        outerPanel.add(secondPanel, gridBagConstraints);
        return loginPanel = outerPanel;
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
		
		JXHyperlink twitter = new JXHyperlink();
		JXHyperlink reddit = new JXHyperlink();
		JXHyperlink facebook = new JXHyperlink();
		JXHyperlink tumblr = new JXHyperlink();
		JXHyperlink youtube = new JXHyperlink();
		JXHyperlink othermedia = new JXHyperlink();

    	Panel panel = new Panel(new GridBagLayout());

        twitter.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/login/twitter.png")));
        reddit.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/login/reddit.png")));
        facebook.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/login/facebook.png")));
        tumblr.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/login/tumblr.png")));
        youtube.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/login/youtube.png")));
        othermedia.setIcon(null);//(new ImageIcon(getClass().getResource("/com/sww/launcher/login/sharethis.png")));

        twitter.setMinimumSize(new Dimension(twitter.getIcon().getIconWidth(), twitter.getIcon().getIconHeight()));
        reddit.setMinimumSize(new Dimension(reddit.getIcon().getIconWidth(), reddit.getIcon().getIconHeight()));
        facebook.setMinimumSize(new Dimension(facebook.getIcon().getIconWidth(), facebook.getIcon().getIconHeight()));
        tumblr.setMinimumSize(new Dimension(tumblr.getIcon().getIconWidth(), tumblr.getIcon().getIconHeight()));
        youtube.setMinimumSize(new Dimension(youtube.getIcon().getIconWidth(), youtube.getIcon().getIconHeight()));
        //othermedia.setMinimumSize(new Dimension(othermedia.getIcon().getIconWidth(), othermedia.getIcon().getIconHeight()));

        GridBagConstraints gridBagConstraints;

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(twitter, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(reddit, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(facebook, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(tumblr, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;	
        gridBagConstraints.gridy = 1;	
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(youtube, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.ipadx = -8;	//Removes White Space
        gridBagConstraints.ipady = -8;	//Removes White Space
        panel.add(othermedia, gridBagConstraints);

        return panel;
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