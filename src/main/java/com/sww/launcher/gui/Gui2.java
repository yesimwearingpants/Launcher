/*
 * Created by JFormDesigner on Tue Mar 24 21:32:39 EDT 2015
 */

package com.sww.launcher.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import org.jdesktop.swingx.*;

/**
 * @author Greg Wright
 */
public class Gui2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7834261477424016791L;
	public Gui2() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Greg Wright
		panel7 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		loginPanel = new JPanel();
		capsOn = new JLabel();
		textField1 = new JTextField();
		passwordField = new JPasswordField();
		userNameLabel = new JLabel();
		passwordLabel = new JLabel();
		loginButton = new JButton();
		saveCB = new JCheckBox();
		errorMessageLabel = new JLabel();
		forgotPassword = new JXHyperlink();
		serverCombo = new JComboBox();
		serverLabal = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel7 ========
		{

			// JFormDesigner evaluation mark
			panel7.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel7.getBorder())); panel7.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel7.setLayout(new FlowLayout());
		}
		contentPane.add(panel7);
		panel7.setBounds(0, 0, 710, 580);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());

		//======== loginPanel ========
		{

			// JFormDesigner evaluation mark
			loginPanel.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), loginPanel.getBorder())); loginPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			loginPanel.setLayout(null);

			//---- capsOn ----
			capsOn.setIcon(new ImageIcon(getClass().getResource("/com/sww/launcher/capsOn.png")));
			capsOn.setToolTipText("Caps Lock is On");
			loginPanel.add(capsOn);
			capsOn.setBounds(new Rectangle(new Point(311, 73), capsOn.getPreferredSize()));

			//---- textField1 ----
			textField1.setPreferredSize(new Dimension(240, 25));
			textField1.setCaretColor(Color.black);
			textField1.setForeground(Color.black);
			loginPanel.add(textField1);
			textField1.setBounds(96, 28, 241, textField1.getPreferredSize().height);

			//---- passwordField ----
			passwordField.setPreferredSize(new Dimension(240, 25));
			passwordField.setCaretColor(Color.black);
			passwordField.setForeground(Color.black);
			loginPanel.add(passwordField);
			passwordField.setBounds(96, 70, 241, passwordField.getPreferredSize().height);

			//---- userNameLabel ----
			userNameLabel.setText("Username:  ");
			userNameLabel.setForeground(Color.black);
			loginPanel.add(userNameLabel);
			userNameLabel.setBounds(new Rectangle(new Point(10, 33), userNameLabel.getPreferredSize()));

			//---- passwordLabel ----
			passwordLabel.setText("Password:  ");
			passwordLabel.setForeground(Color.black);
			loginPanel.add(passwordLabel);
			passwordLabel.setBounds(new Rectangle(new Point(12, 76), passwordLabel.getPreferredSize()));

			//---- loginButton ----
			loginButton.setText("Login");
			loginButton.setForeground(Color.black);
			loginPanel.add(loginButton);
			loginButton.setBounds(348, 40, 140, 40);

			//---- saveCB ----
			saveCB.setText("Remember");
			saveCB.setForeground(Color.black);
			saveCB.setToolTipText("Remember Username & Password");
			loginPanel.add(saveCB);
			saveCB.setBounds(new Rectangle(new Point(355, 88), saveCB.getPreferredSize()));

			//---- errorMessageLabel ----
			errorMessageLabel.setText("Login Failed");
			errorMessageLabel.setVisible(false);
			loginPanel.add(errorMessageLabel);
			errorMessageLabel.setBounds(new Rectangle(new Point(115, 5), errorMessageLabel.getPreferredSize()));

			//---- forgotPassword ----
			forgotPassword.setText("Forgot Password?");
			forgotPassword.setForeground(new Color(0, 30, 255));
			forgotPassword.setClickedColor(new Color(150, 0, 150));
			forgotPassword.setFont(new Font("Dialog", Font.BOLD, 10));
			forgotPassword.setActionCommand("https;//github.com");
			forgotPassword.setUnclickedColor(new Color(0, 30, 255));
			loginPanel.add(forgotPassword);
			forgotPassword.setBounds(new Rectangle(new Point(220, 100), forgotPassword.getPreferredSize()));

			//---- serverCombo ----
			serverCombo.setPreferredSize(new Dimension(70, 24));
			serverCombo.setForeground(Color.black);
			loginPanel.add(serverCombo);
			serverCombo.setBounds(435, 10, 265, serverCombo.getPreferredSize().height);

			//---- serverLabal ----
			serverLabal.setText("Login Server");
			serverLabal.setForeground(Color.black);
			loginPanel.add(serverLabal);
			serverLabal.setBounds(new Rectangle(new Point(340, 15), serverLabal.getPreferredSize()));

			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < loginPanel.getComponentCount(); i++) {
					Rectangle bounds = loginPanel.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = loginPanel.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				loginPanel.setMinimumSize(preferredSize);
				loginPanel.setPreferredSize(preferredSize);
			}
		}

		//======== panel5 ========
		{

			// JFormDesigner evaluation mark
			panel5.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel5.getBorder())); panel5.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel5.setLayout(new BorderLayout());
		}

		//======== panel6 ========
		{

			// JFormDesigner evaluation mark
			panel6.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel6.getBorder())); panel6.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel6.setLayout(new GridBagLayout());
			((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0, 0};
			((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
			((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Greg Wright
	private JPanel panel7;
	private JPanel loginPanel;
	private JLabel capsOn;
	private JTextField textField1;
	private JPasswordField passwordField;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JCheckBox saveCB;
	private JLabel errorMessageLabel;
	private JXHyperlink forgotPassword;
	private JComboBox serverCombo;
	private JLabel serverLabal;
	private JPanel panel5;
	private JPanel panel6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
