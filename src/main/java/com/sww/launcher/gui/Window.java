package com.sww.launcher.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.events.IListener;
import com.sww.launcher.events.MouseEventExt;
import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.events.MouseEventExt.Var;
import com.sww.launcher.gui.elements.ConsolePanel;
import com.sww.launcher.gui.elements.MainPanel;
import com.sww.launcher.gui.elements.NewsPanel;
import com.sww.launcher.gui.elements.TablePanel;
import com.sww.launcher.gui.elements.VersionPanel;
import com.sww.launcher.gui.elements.components.Panel;
import com.sww.launcher.gui.elements.login.LoginPanel;
import com.sww.launcher.login.Login;
import com.sww.launcher.login.Password;
import com.sww.launcher.login.User;
import com.sww.launcher.variables.Reference;

public class Window extends JFrame {

	private static final long serialVersionUID = -8477483526358458395L;
	@SuppressWarnings("unused")
	private static int defaultCloseOperation = EXIT_ON_CLOSE;
	private static int x = 720;
	private static int y = 480;

	@SuppressWarnings("unused")
	private static final Login login = new Login();
	@SuppressWarnings("unused")
	private static final User user = new User();
	@SuppressWarnings("unused")
	private static final Password password = new Password();
	private FileEvent c = new FileEvent(Reference.configFile);

	private static JSeparator separator1 = new JSeparator();
	private static JTabbedPane tab1 = new JTabbedPane();
	private static JTabbedPane tab2 = new JTabbedPane();
	private static MainPanel mainPanel = new MainPanel();
	private static Panel loginPanel = new LoginPanel(/*login, password, user*/).createPanel();
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
		super(Reference.TITLE + " " + Reference.VERSION);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(x, y);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/com/sww/launcher/icon.png")).getImage());
		contentPane.setLayout(null);
		addActions();
		init();
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
					if(VersionPanel.getProfileButton().getText().equals("Edit Profile")) {
						MouseEventExt ev = new MouseEventExt(Var.getComponent(), Var.getId(), Var.getWhen(),
							Var.getModifiers(), Var.getX(), Var.getY(), Var.getClickcount(), Var.getButton());
						ProfileEvent p = new ProfileEvent(e);
						ArrayList<String> set = MouseEventExt.getRowList();
						set.add(p.getName());
						set.add(p.getVersion());
						set.add(p.getLocation());
						set.add((String.valueOf(p.getBool())));
						System.out.println(ev.getRowInt());
						Reference.TableListofLists.set(ev.getRowInt(), set);
						c.editFile();
						TablePanel.tableChanged();
						VersionPanel.getProfileButton().setText("Add New Profile");
						mainPanel.setLabel("profileM", p.getName());
						mainPanel.setLabel("versionM", p.getVersion());
					} else {
						ProfileEvent p = new ProfileEvent(e);
						mainPanel.setLabel("profileM", p.getName());
						mainPanel.setLabel("versionM", p.getVersion());
						ArrayList<String> set = new ArrayList<>();
						set.add(p.getName());
						set.add(p.getVersion());
						set.add(p.getLocation());
						set.add((String.valueOf(p.getBool())));
						c.addLine(p.getName(), p.getVersion(), p.getLocation(), p.getBool());
						Reference.TableListofLists.add(set);
						TablePanel.tableChanged();
					}	
		}	}	});
		tablePanel.addIListener(new IListener() {
			@Override
			public void addAction(EventObject e) {
				if(tablePanel.getIListener() != null) {
					if(((MouseEventExt) e).getButton() == MouseEvent.BUTTON3) {
						Reference.TableListofLists.remove(((MouseEventExt) e).getRowInt());
						c.editFile();
						TablePanel.tableChanged();
					} else if(((MouseEventExt) e).getButton() == MouseEvent.BUTTON2) {
						
					} else {
						VersionPanel.getProfileButton().setText("Edit Profile");
						VersionPanel.getProfileInput().setText((String) MouseEventExt.getRowList().get(0));
						VersionPanel.getLocationInput().setText((String) MouseEventExt.getRowList().get(2));
						VersionPanel.getSelectionInputBox().setSelectedIndex(MouseEventExt.d0());
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

        tab1.addTab("Main", mainPanel);
        tab1.addTab("Login", loginPanel);
        tab1.addTab("Version", versionPanel);
        tab2.addTab("News", newsPanel);
        tab2.addTab("Profiles", tablePanel);
        tab2.addTab("Console", consolePanel);

        playButton.setText("Play");
        closeButton.setText("Close");

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

}