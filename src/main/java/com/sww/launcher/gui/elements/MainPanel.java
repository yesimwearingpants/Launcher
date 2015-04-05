package com.sww.launcher.gui.elements;

import static com.sww.launcher.gui.Window.spacer1;
import static com.sww.launcher.gui.Window.spacer2;
import static com.sww.launcher.gui.Window.spacer5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
		setLayout(new FlowLayout());

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
				
		}});

		add(spacer1);
		add(profileM);
		add(spacer2);
		add(versionM);
		add(spacer2);
		add(usernameM);
		add(spacer1);
		add(spacer5);
		add(spacer1);
		add(settingsButton);
	}
	/**
	 * @param s text name of the component
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
