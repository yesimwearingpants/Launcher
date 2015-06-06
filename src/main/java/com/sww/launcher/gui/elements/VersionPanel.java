package com.sww.launcher.gui.elements;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.gui.elements.components.Combox;
import com.sww.launcher.gui.elements.components.Panel;
import com.sww.launcher.reference.Reference;
import com.sww.launcher.util.Path;

@SuppressWarnings("serial")
public class VersionPanel extends Panel {

	private static JTextField profileInput = new JTextField();
	private static JTextField locationInput = new JTextField();
	private static Combox<String> selectionInputBox = new Combox<>(Reference.Versions);
	private static JButton profileButton = new JButton();
	private static JLabel profileLabel = new JLabel();
	private static JLabel locationLabel = new JLabel();
	private static JLabel versionLabel = new JLabel();
	private static JLabel errorMessage = new JLabel();
	private static boolean valid = false;

	public VersionPanel() {

		setLayout(new GridBagLayout());
		profileLabel.setText("Name:  ");
		locationLabel.setText("Location:  ");
		versionLabel.setText("Version:  ");
		profileButton.setText("Add New Profile");
		errorMessage.setText("Profile already in use");

		errorMessage.setVisible(valid);

		profileInput.setMinimumSize(new Dimension(240, 25));
		locationInput.setMinimumSize(new Dimension(240, 25));
		selectionInputBox.setMinimumSize(new Dimension(340, 24));

		profileInput.setPreferredSize(new Dimension(240, 25));
		locationInput.setPreferredSize(new Dimension(240, 25));
		selectionInputBox.setPreferredSize(new Dimension(340, 24));

		selectionInputBox.setSelectedItem(Reference.Versions.get(Reference.Versions.size()-1));

		profileButton.addActionListener((ActionEvent e) -> {
			action();
		});

		GridBagConstraints gridBagConstraints;
		
		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(profileLabel, gridBagConstraints);		

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        add(profileInput, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(locationLabel, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        add(locationInput, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 80, 6, 0);
        add(errorMessage, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);
        add(versionLabel, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        add(selectionInputBox, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new Insets(0, 0, 0, 30);
        add(profileButton, gridBagConstraints);
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
				ev.setLocation(new Path(locationInput.getText()));
			} else {
				// Default Save Location
				ev.setLocation(new Path(Reference.SaveLocation));
			}
			ev.setVersion(selectionInputBox.getSelectedItem().toString());
		} else {
			return;
		}
		if(super.getIListener() != null) {
			super.getIListener().addAction(ev);
		}
	}

	public void setValid(boolean valid) {
		VersionPanel.valid = valid;
	}

}
