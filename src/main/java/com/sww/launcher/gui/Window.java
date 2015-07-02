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
 * Created Mar 22, 2015
 */
package com.sww.launcher.gui;

import static com.sww.launcher.Main.i18n;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.EventObject;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.events.IListener;
import com.sww.launcher.events.MouseEventExt;
import com.sww.launcher.events.MouseEventExt.Var;
import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.gui.elements.ConsolePanel;
import com.sww.launcher.gui.elements.MainPanel;
import com.sww.launcher.gui.elements.NewsPanel;
import com.sww.launcher.gui.elements.TablePanel;
import com.sww.launcher.gui.elements.VersionPanel;
import com.sww.launcher.gui.elements.components.Panel;
import com.sww.launcher.gui.elements.login.LoginPanel;
import com.sww.launcher.reference.Reference;
import com.sww.launcher.util.Profile;
import com.sww.launcher.util.login.LoginService;
import com.sww.launcher.util.login.PasswordStore;
import com.sww.launcher.util.login.UserNameStore;

public class Window extends JFrame {

	private static final long serialVersionUID = -8477483526358458395L;
	@SuppressWarnings("unused")
	private static int defaultCloseOperation = EXIT_ON_CLOSE;
	private static int x = 720;
	private static int y = 480;

	private FileEvent c = new FileEvent(Reference.configFile);

	private static JSeparator separator1 = new JSeparator();
	private static JTabbedPane tab1 = new JTabbedPane();
	private static JTabbedPane tab2 = new JTabbedPane();
	private static MainPanel mainPanel = new MainPanel();
	private static Panel loginPanel = new LoginPanel(/*login, password, user*/);
	private static VersionPanel versionPanel = new VersionPanel();
	private static NewsPanel newsPanel = new NewsPanel();
	private static TablePanel tablePanel = new TablePanel();
	private static ConsolePanel consolePanel = new ConsolePanel();
	private static JButton playButton = new JButton();
	private static JButton closeButton = new JButton();
	private static Panel buttonPanel = new Panel();
	private static int yy = 174;

	protected Container contentPane = getContentPane();

	public Window() {
		super(String.format("%s %s", Reference.TITLE, Reference.VERSION));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(x, y);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/com/sww/launcher/icon.png")).getImage());
		contentPane.setLayout(null);
		addActions();
		init();
	}

	@Override
    public void setDefaultCloseOperation(int operation) {
		Reference.logFile.delete();
		super.setDefaultCloseOperation(operation);
    }

	private void addActions() {
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getPoint());
		}	});
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tab1.getSelectedIndex() == 0) {
					yy = 60;
					contentPane();
				} else if(tab1.getSelectedIndex() == 2) {
					yy = 120;
					contentPane();
				} else {
					yy = 174;
					contentPane();
				}	
		}	});
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tab2.getSelectedIndex() == 0) {
					tab1.setSelectedIndex(0);
					yy = 60;
					contentPane();
				} else if(tab2.getSelectedIndex() == 2) {
					tab1.setSelectedIndex(0);
					yy = 60;
					contentPane();
				} else {
					tab1.setSelectedIndex(2);
					yy = 120;
					contentPane();
				}
		}	});
		versionPanel.addIListener(new IListener() {
			@Override
			public void addAction(EventObject e) {
				if(versionPanel.getIListener() != null) {
					ProfileEvent p = new ProfileEvent(e);
					Profile profile = new Profile(p.getName(), p.getVersion(), p.getLocation());
					if(VersionPanel.getProfileButton().getText().equals(i18n.lang.getString("editProfile"))) {
						MouseEventExt ev = new MouseEventExt(Var.getComponent(), Var.getId(), Var.getWhen(),
							Var.getModifiers(), Var.getX(), Var.getY(), Var.getClickcount(), Var.getButton());
						if(!Reference.Profiles.addAsBoolean(ev.getRowInt(), profile)) {
							versionPanel.setValid(true);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						c.editFile();
						//TablePanel.tableChanged();
						VersionPanel.getProfileButton().setText(i18n.lang.getString("newProfile"));
						mainPanel.setLabel(mainPanel.getProfileM(), p.getName());
						mainPanel.setLabel(mainPanel.getVersionM(), p.getVersion());
						VersionPanel.getProfileInput().setText("");
						VersionPanel.getLocationInput().setText("");
						VersionPanel.getSelectionInputBox().setSelectedIndex(Reference.Profiles.size()-1);
					} else {
						mainPanel.setLabel(mainPanel.getProfileM(), p.getName());
						mainPanel.setLabel(mainPanel.getVersionM(), p.getVersion());
						if(!Reference.Profiles.add(profile)) {
							versionPanel.setValid(true);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						//TablePanel.tableChanged();
				}	}
		}	});
		tablePanel.addIListener(new IListener() {
			@Override
			public void addAction(EventObject e) {
				if(tablePanel.getIListener() != null) {
					if(((MouseEventExt) e).getButton() == MouseEvent.BUTTON3) {
						Reference.Profiles.remove(((MouseEventExt) e).getRowInt());
						c.editFile();
						//TablePanel.tableChanged();
					} else {
						VersionPanel.getProfileButton().setText(i18n.lang.getString("editProfile"));
						VersionPanel.getProfileInput().setText((String) MouseEventExt.getRowList().getName());
						VersionPanel.getLocationInput().setText((String) MouseEventExt.getRowList().getLocation().toString());
						VersionPanel.getSelectionInputBox().setSelectedItem(MouseEventExt.getRowList().getVersion());
				}	}
		}	});
        separator1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
            	yy = e.getY();
                contentPane();
        }	});
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}	});
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		}	});
	}

	private void init() {

        tab1.addTab(i18n.lang.getString("tMain"), mainPanel);
        tab1.addTab(i18n.lang.getString("tLogin"), loginPanel);
        tab1.addTab(i18n.lang.getString("tVersion"), versionPanel);
        tab2.addTab(i18n.lang.getString("tNews"), newsPanel);
        tab2.addTab(i18n.lang.getString("tProfiles"), tablePanel);
        tab2.addTab(i18n.lang.getString("tConsole"), consolePanel);

        playButton.setText(i18n.lang.getString("play"));
        closeButton.setText(i18n.lang.getString("close"));

        GroupLayout bpLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(bpLayout);
        bpLayout.setHorizontalGroup(
            bpLayout.createParallelGroup()
            .addGroup(GroupLayout.Alignment.TRAILING, bpLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(closeButton)
                .addContainerGap())
        );
        bpLayout.setVerticalGroup(
            bpLayout.createParallelGroup()
            .addGroup(GroupLayout.Alignment.TRAILING, bpLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(closeButton)
                    .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        
        contentPane();
        pack();
        tab1.setSelectedIndex(1);
    }

	public void contentPane() {
		int yyy = y - (yy + 89);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
            .addComponent(tab2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, x, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tab1, GroupLayout.PREFERRED_SIZE, x, GroupLayout.PREFERRED_SIZE)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, x, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab1, 0, yy, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(separator1, 0, 3, GroupLayout.PREFERRED_SIZE)
                .addGap(3)
                .addComponent(tab2, 0, yyy, GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        );
	}

	@SuppressWarnings("unused")
	private static final LoginService login = new LoginService() {
		@Override
		public boolean authenticate(String name, char[] password, String server)
				throws Exception {
			return false;
	}	};
	@SuppressWarnings("unused")
	private static final UserNameStore user = new UserNameStore() {
		@Override
		public String[] getUserNames() {
			return null;
		}
		@Override
		public void setUserNames(String[] names) {
			
		}

		@Override
		public void loadUserNames() {
			
		}

		@Override
		public void saveUserNames() {
			
		}

		@Override
		public boolean containsUserName(String name) {
			return false;
		}

		@Override
		public void addUserName(String userName) {
			
		}

		@Override
		public void removeUserName(String userName) {
			
	}};
	@SuppressWarnings("unused")
	private static final PasswordStore password = new PasswordStore() {
		@Override
		public boolean set(String username, String server, char[] password) {
			return false;
		}

		@Override
		public char[] get(String username, String server) {
			return null;
		}

		@Override
		public void removeUserPassword(String username) {
			
	}	};

	public static JTabbedPane getTab2() {
		return tab2;
	}

}
