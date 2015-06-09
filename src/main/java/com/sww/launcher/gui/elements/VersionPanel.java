package com.sww.launcher.gui.elements;

import static com.sww.launcher.gui.Window.spacer0;
import static com.sww.launcher.gui.Window.spacer3;
import static com.sww.launcher.gui.Window.spacer4;
import static com.sww.launcher.gui.Window.spacer5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.gui.elements.components.Combox;
import com.sww.launcher.gui.elements.components.Panel;
import com.sww.launcher.variables.Reference;

@SuppressWarnings("serial")
public class VersionPanel extends Panel {

	private static JTextField profileInput = new JTextField();
	private static JTextField locationInput = new JTextField();
	private static Combox<String> selectionInputBox = new Combox<>(Reference.Versions);
	private static JButton profileButton = new JButton();
	private static JLabel profileLabel = new JLabel();
	private static JLabel locationLabel = new JLabel();
	private static JLabel versionLabel = new JLabel();

	public VersionPanel() {

		setLayout(new FlowLayout());
		profileLabel.setText("Name:  ");
		locationLabel.setText("Location:  ");
		versionLabel.setText("Version:  ");
		profileButton.setText("Add New Profile");

		profileInput.setMinimumSize(new Dimension(240, 25));
		locationInput.setMinimumSize(new Dimension(240, 25));
		selectionInputBox.setMinimumSize(new Dimension(340, 24));
		setMinimumSize(new Dimension(705, 125));

		profileInput.setPreferredSize(new Dimension(240, 25));
		locationInput.setPreferredSize(new Dimension(240, 25));
		selectionInputBox.setPreferredSize(new Dimension(340, 24));
		setPreferredSize(new Dimension(705, 125));

		selectionInputBox.setSelectedItem(Reference.Versions.get(Reference.Versions.size()-1));
		
		profileButton.addActionListener((ActionEvent e) -> {
				action();
		});
		add(spacer0);
		add(profileLabel);
		add(profileInput);
		add(spacer3);
		add(locationLabel);
		add(locationInput);
		add(spacer0);
		add(spacer5);
		add(versionLabel);
		add(selectionInputBox);
		add(spacer4);
		add(profileButton);
		add(spacer0);
	}

	public static JTextField getProfileInput() {
		return profileInput;
	}

	public static JTextField getLocationInput() {
		return locationInput;
	}

	public static JButton getProfileButton() {
		return profileButton;
	}

	public static Combox<String> getSelectionInputBox() {
		return selectionInputBox;
	}

	public void action() {
		ProfileEvent ev = new ProfileEvent(this);
		if(profileInput.getText() != null) {
			ev.setName(profileInput.getText());
			if(!locationInput.getText().equals("")) {
				ev.setLocation(locationInput.getText());
			} else {
				// Default Save Location
				ev.setLocation(Reference.SaveLocation);
			}
			ev.setVersion(selectionInputBox.getSelectedItem().toString());
		} else {
			return;
		}
		if(super.getIListener() != null) {
			super.getIListener().addAction(ev);
		}
	}

}
