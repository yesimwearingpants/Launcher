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
package com.sww.launcher.gui.elements;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.sww.launcher.gui.elements.components.Panel;

import static com.sww.launcher.Main.i18n;

@SuppressWarnings("serial")
public class MainPanel extends Panel {

	private static JLabel profileM;
	private static JLabel versionM;
	private static JLabel usernameM;
	private static JButton settingsButton = new JButton();
	
	public MainPanel() {
		setLayout(new GridBagLayout());
		
		profileM = new JLabel();
		versionM = new JLabel();
		usernameM = new JLabel();

		profileM.setText("#########");
		versionM.setText("#########");
		usernameM.setText("#########");
		settingsButton.setText(i18n.lang.getString("settings"));

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
				@SuppressWarnings("unused")
				Option panel = new Option();
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
	public void setLabel(JLabel l, String t) {
		l.setText(t);
	}
	
	private static class Option extends JFrame {

		protected Container contentPane = getContentPane();
		private JCheckBox box = new JCheckBox();

		Option() {
			super("Settings");

			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setSize(160, 220);
			setResizable(false);
			setIconImage(null);
			contentPane.setLayout(null);
			addActions();
			init();
		}

		private void addActions() {
			
		}

		private void init() {
			box .setText("");
			
		}
	}

	public JLabel getProfileM() {
		return profileM;
	}

	public JLabel getVersionM() {
		return versionM;
	}

	public JLabel getUsernameM() {
		return usernameM;
	}

}
