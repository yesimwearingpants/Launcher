package com.sww.launcher.gui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.sww.launcher.gui.elements.components.Panel;

@SuppressWarnings("serial")
public class MainPanel extends Panel {

	private static JLabel profileM = new JLabel();
	private static JLabel versionM = new JLabel();
	private static JLabel usernameM = new JLabel();
	private static JButton settingsButton = new JButton();
	
	public MainPanel() {
		setLayout(new GridBagLayout());

		profileM.setText("#########");
		versionM.setText("#########");
		usernameM.setText("#########");
		settingsButton.setText("Settings");

		profileM.setMinimumSize(new Dimension(120, 15));
		versionM.setMinimumSize(new Dimension(120, 15));
		usernameM.setMinimumSize(new Dimension(120, 15));

		profileM.setPreferredSize(new Dimension(120, 15));
		versionM.setPreferredSize(new Dimension(120, 15));
		usernameM.setPreferredSize(new Dimension(120, 15));

		profileM.setFont(new Font("Dialog", Font.BOLD, 14));
		versionM.setFont(new Font("Dialog", Font.BOLD, 14));
		usernameM.setFont(new Font("Dialog", Font.BOLD, 14));
		
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		}	});

		GridBagConstraints gridBagConstraints;

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(profileM, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(versionM, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(usernameM, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        add(settingsButton, gridBagConstraints);
	}
	/**
	 * @param s Component Variable Name as a String
	 * @param t new <code>setText()</code> argument
	 */
	public void setLabel(String s, String t) {
		if(s.equalsIgnoreCase("profileM")) {
			profileM.setText(t);
		}
		if(s.equalsIgnoreCase("versionM")) {
			versionM.setText(t);
		}
		if(s.equalsIgnoreCase("usernameM")) {
			usernameM.setText(t);
		}
	}

}
