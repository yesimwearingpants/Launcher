package com.sww.launcher.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import org.jdesktop.swingx.JXComboBox;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import com.sww.launcher.elements.Console;
import com.sww.launcher.elements.ListTableModel;
import com.sww.launcher.login.Login;
import com.sww.launcher.login.Password;
import com.sww.launcher.login.User;
import com.sww.launcher.variables.Reference;

class Gui extends JFrame {
	
	private static final long serialVersionUID = -8477483526358458395L;

	private static final Login Login = new Login();
	private static final Password Password = new Password();
	private static final User User = new User();
	

	private JPanel spacer0 = new JPanel(null);
	private JPanel spacer1 = new JPanel(null);
	private JPanel spacer2 = new JPanel(null);
	private JPanel spacer3 = new JPanel(null);
	private JPanel spacer4 = new JPanel(null);
	private JPanel spacer5 = new JPanel(null);
	private JSeparator separator1 = new JSeparator();
	private JTabbedPane tabbedPane1 = new JTabbedPane();
	private JTabbedPane tabbedPane2 = new JTabbedPane();
	private JXPanel panel0 = new JXPanel();
	private JXPanel mainTab = new JXPanel();
	private JXPanel versionsTab = new JXPanel();
	private JXPanel newsTab = new JXPanel();
	private JXPanel profileTab = new JXPanel();
	private JXPanel consoleTab = new JXPanel();
	//Fixx this Next
	//private JLoginPanel loginTab = new JLoginPanel(Login, Password, User);
	private JLabel profile = new JLabel();
	private JLabel version = new JLabel();
	private JLabel username = new JLabel();
	private JLabel profileNameInput = new JLabel();
	private JLabel locationInput = new JLabel();
	private JLabel versionSelect = new JLabel();
	protected JTextPane news = new JTextPane();
	protected JTextArea console = new JTextArea();
	protected JXTable table0 = new JXTable();
	protected static JButton newProfileButton = new JButton();
	protected static JButton playButton = new JButton();
	protected static JButton closeButton = new JButton();
	protected static JButton settingsButton = new JButton();
	protected static JTextField profileNameField = new JTextField();
	protected static JTextField locationField = new JTextField();
	protected static JXComboBox selectionBox = new JXComboBox(new ListComboBoxModel<String>(Reference.Versions));
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static ListTableModel model = new ListTableModel(Reference.TableListofLists, Reference.TableList);
	
	protected Container contentPane = getContentPane();

	Gui() {
		super(Reference.TITLE + " " + Reference.VERSION);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/com/sww/launcher/icon.png")).getImage());
		contentPane.setLayout(null);
	}
	
	/* private void init() {
		
		panel0 = new JPanel();
		tabbedPane1 = new JTabbedPane();
		mainTab = new JPanel();
		hSpacer1 = new JPanel(null);
		profile = new JLabel();
		hSpacer2 = new JPanel(null);
		version = new JLabel();
		username = new JLabel();
		loginTab = new JPanel();
		usernameInput = new JLabel();
		userField = new JTextField();
		passwordInput = new JLabel();
		loginButton = new JButton();
		passwordField = new JPasswordField();
		versionsTab = new JPanel();
		hSpacer0 = new JPanel(null);
		profileNameInput = new JLabel();
		profileNameField = new JTextField();
		hSpacer3 = new JPanel(null);
		locationInput = new JLabel();
		locationField = new JTextField();
		vSpacer0 = new JPanel(null);
		versionSelect = new JLabel();
		selectionBox = new JXComboBox(new ListComboBoxModel<String>(Reference.Versions));
		hSpacer4 = new JPanel(null);
		newProfileButton = new JButton();
		separator1 = new JSeparator();
		tabbedPane2 = new JTabbedPane();
		newsTab = new JScrollPane();
		news = new JTextPane();
		profilesTab = new JPanel();
		profileTab = new JScrollPane();
		table1 = new JTable();
		consoleTab = new JScrollPane();
		console = new JTextPane();
		playButton = new JButton();
		closeButton = new JButton();
		settingsButton = new JButton();
	}*/
	
	protected void setLayouts() {
		
		mainTab.setLayout(new FlowLayout());
		versionsTab.setLayout(new FlowLayout());
		profileTab.setLayout(null);
		panel0.setLayout(null);
		
		table0.setModel(model);
	}
	
	protected void setText() {
		
		playButton.setText("Play");
		closeButton.setText("Close");
		profile.setText("#########");
		version.setText("#########");
		username.setText("#########");
		settingsButton.setText("Settings");
		profileNameInput.setText("Name:  ");
		locationInput.setText("Location:  ");
		versionSelect.setText("Version:  ");
		newProfileButton.setText("Add New Profile");

	}
	
	protected void setSize() {
		
		spacer1.setMinimumSize(new Dimension(30, 10));
		spacer2.setMinimumSize(new Dimension(80, 10));
		profile.setMinimumSize(new Dimension(120, 15));
		version.setMinimumSize(new Dimension(120, 15));
		username.setMinimumSize(new Dimension(120, 15));
		spacer3.setMinimumSize(new Dimension(40, 10));
		spacer4.setMinimumSize(new Dimension(110, 10));
		spacer5.setMinimumSize(new Dimension(705, 15));
		profileNameField.setMinimumSize(new Dimension(240, 25));
		locationField.setMinimumSize(new Dimension(240, 25));
		selectionBox.setMinimumSize(new Dimension(340, 24));
		playButton.setMinimumSize(new Dimension(200, 100));
		closeButton.setMinimumSize(new Dimension(80, 25));
		separator1.setMinimumSize(new Dimension(700, 2));
		panel0.setMinimumSize(new Dimension(710, 460));
		
		spacer1.setPreferredSize(new Dimension(30, 10));
		spacer2.setPreferredSize(new Dimension(80, 10));
		profile.setPreferredSize(new Dimension(120, 15));
		version.setPreferredSize(new Dimension(120, 15));
		username.setPreferredSize(new Dimension(120, 15));
		spacer3.setPreferredSize(new Dimension(40, 10));
		spacer4.setPreferredSize(new Dimension(110, 10));
		spacer5.setPreferredSize(new Dimension(705, 15));
		profileNameField.setPreferredSize(new Dimension(240, 25));
		locationField.setPreferredSize(new Dimension(240, 25));
		selectionBox.setPreferredSize(new Dimension(340, 24));
		playButton.setPreferredSize(new Dimension(200, 100));
		closeButton.setPreferredSize(new Dimension(80, 25));
		separator1.setPreferredSize(new Dimension(700, 2));
		panel0.setPreferredSize(new Dimension(710, 460));

	}

	
	protected void setFont() {

		profile.setFont(new Font("Dialog", Font.BOLD, 14));
		version.setFont(new Font("Dialog", Font.BOLD, 14));
		username.setFont(new Font("Dialog", Font.BOLD, 14));
		playButton.setFont(new Font("Dialog", Font.BOLD, 18));

	}
	
	protected void setViewportViewer() {

		Console con = new Console(console, 1000);
		PrintStream ps = new PrintStream(con);
		selectionBox.setSelectedItem(Reference.Versions.get(0));
		
		news.setEditable(false);
		//newsTab.setViewportView(news);
	
		//profileTab.setViewportView(table0);
		
		console.setEditable(false);
		//consoleTab.setViewportView(console);
		
		System.setOut(ps);
		System.setOut(ps);
	}
		
	protected void addComponents() {

		mainTab.add(spacer1);
		mainTab.add(profile);
		mainTab.add(spacer2);
		mainTab.add(version);
		mainTab.add(spacer2);
		mainTab.add(username);
		mainTab.add(spacer1);
		mainTab.add(spacer5);
		mainTab.add(spacer1);
		mainTab.add(settingsButton);
		versionsTab.add(spacer0);
		versionsTab.add(profileNameInput);
		versionsTab.add(profileNameField);
		versionsTab.add(spacer3);
		versionsTab.add(locationInput);
		versionsTab.add(locationField);
		versionsTab.add(spacer0);
		versionsTab.add(spacer5);
		versionsTab.add(versionSelect);
		versionsTab.add(selectionBox);
		versionsTab.add(spacer4);
		versionsTab.add(newProfileButton);
		versionsTab.add(spacer0);
		newsTab.add(news);
		profileTab.add(table0);
		consoleTab.add(console);
		
		tabbedPane1.addTab("Main", mainTab);
		//tabbedPane1.addTab("Login", loginTab);
		tabbedPane1.addTab("Versions", versionsTab);
		tabbedPane2.addTab("News", newsTab);
		tabbedPane2.addTab("Profiles", profileTab);
		tabbedPane2.addTab("Console", consoleTab);
		
		panel0.add(playButton);
		panel0.add(closeButton);
		panel0.add(separator1);
		panel0.add(tabbedPane1);
		panel0.add(tabbedPane2);
	
		contentPane.add(panel0);
	}

	protected void setBounds() {
			
		profileTab.setBounds(0, 0, 705, 225);
		tabbedPane2.setBounds(0, 130, 710, 245);
		tabbedPane1.setBounds(0, 0, 710, 115);
		playButton.setBounds(255, 385, playButton.getPreferredSize().width, 60);
		closeButton.setBounds(new Rectangle(new Point(620, 420), closeButton.getPreferredSize()));
		separator1.setBounds(new Rectangle(new Point(5, 120), separator1.getPreferredSize()));
		panel0.setBounds(0, 0, 710, 460);

	}

	protected void panel0() {

		{
		
		Dimension preferredSize = new Dimension();
			for(int i = 0; i < panel0.getComponentCount(); i++) {
				Rectangle bounds = panel0.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = panel0.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			panel0.setMinimumSize(preferredSize);
			panel0.setPreferredSize(preferredSize);
		}{

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
		
		setSize(720, 480);
		setLocationRelativeTo(getOwner());
	}

}