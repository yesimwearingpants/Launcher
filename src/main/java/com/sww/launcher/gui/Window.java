package com.sww.launcher.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.events.IListener;
import com.sww.launcher.events.ProfileEvent;
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

	@SuppressWarnings("unused")
	private static final Login login = new Login();
	@SuppressWarnings("unused")
	private static final User user = new User();
	@SuppressWarnings("unused")
	private static final Password password = new Password();

	public static Panel spacer0 = new Panel(null);
	public static Panel spacer1 = new Panel(null);
	public static Panel spacer2 = new Panel(null);
	public static Panel spacer3 = new Panel(null);
	public static Panel spacer4 = new Panel(null);
	public static Panel spacer5 = new Panel(null);
	private static JSeparator separator1 = new JSeparator();
	private static JTabbedPane tab1 = new JTabbedPane();
	private static JTabbedPane tab2 = new JTabbedPane();
	private static MainPanel mainPanel = new MainPanel();
	private static Panel loginPanel = new LoginPanel(/*login, password, user*/).createPanel();
	private static VersionPanel versionPanel = new VersionPanel();
	private static NewsPanel newsPanel = new NewsPanel();
	private static TablePanel tablePanel = new TablePanel();
	private static ConsolePanel consolePanel = new ConsolePanel();
	private static Panel panel0 = new Panel();
	private static JButton playButton = new JButton();
	private static JButton closeButton = new JButton();
	private static Panel buttonPanel = new Panel();

	protected Container contentPane = getContentPane();

	public Window() {
		super(Reference.TITLE + " " + Reference.VERSION);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/com/sww/launcher/icon.png")).getImage());
		contentPane.setLayout(null);
		addActions();
		init();
	}

	private void addActions() {
		versionPanel.addIListener(new IListener() {
			@Override
			public void addAction(EventObject e) {
<<<<<<< Upstream, based on d9393acf0210689dbe0947d67226ef3cd0bce9eb
=======
				ProfileEvent p = new ProfileEvent(e);
>>>>>>> 14ace0b New Events
				if(versionPanel.getIListener() != null) {
<<<<<<< Upstream, based on d9393acf0210689dbe0947d67226ef3cd0bce9eb
					ProfileEvent p = new ProfileEvent(e);
=======
					mainPanel.setLabel("profileM", p.getName());
					mainPanel.setLabel("versionM", p.getVersion());
>>>>>>> 14ace0b New Events
					FileEvent c = new FileEvent(Reference.configFile);
					if(VersionPanel.getProfileButton().getText().equals("Edit Profile")) {
						mainPanel.setLabel("profileM", p.getName());
						mainPanel.setLabel("versionM", p.getVersion());
						
						VersionPanel.getProfileButton().setText("Add New Profile");
					}else {
					mainPanel.setLabel("profileM", p.getName());
					mainPanel.setLabel("versionM", p.getVersion());
					List<Object> set = new ArrayList<Object>();
					set.add(p.getName());
					set.add(p.getVersion());
					set.add(p.getLocation());
					set.add(p.getBool());
					c.addLine(p.getName(), p.getVersion(), p.getLocation(), p.getBool());
					Reference.TableListofLists.add(set);
					TablePanel.tableChanged();
		}	}	}	});
		/*tablePanel.addIListener(new IListener() {
			@Override
			public void addAction(EventObject e) {
				List<Object> list = MouseEventExt.getRow();
				VersionPanel.getProfileButton().setText("Edit Profile");
				VersionPanel.getProfileInput().setText((String) list.get(0));
				VersionPanel.getLocationInput().setText((String) list.get(2));
				VersionPanel.getSelectionInputBox().setSelectedIndex(MouseEventExt.d0());
		}	});*/
        separator1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                tab1.getSize(new Dimension(tab1.getX(), (evt.getY()-3)));
                tab2.getSize(new Dimension(tab2.getX(), (evt.getY()+3)));
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

        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        
        spacer1.setMinimumSize(new Dimension(30, 10));
		spacer2.setMinimumSize(new Dimension(80, 10));
		spacer3.setMinimumSize(new Dimension(40, 10));
		spacer4.setMinimumSize(new Dimension(110, 10));
		spacer5.setMinimumSize(new Dimension(705, 15));
		
		spacer1.setPreferredSize(new Dimension(30, 10));
		spacer2.setPreferredSize(new Dimension(80, 10));
		spacer3.setPreferredSize(new Dimension(40, 10));
		spacer4.setPreferredSize(new Dimension(110, 10));
		spacer5.setPreferredSize(new Dimension(705, 15));

        tab1.addTab("tab2", mainPanel);
        tab1.addTab("tab1", loginPanel);
        tab1.addTab("tab3", versionPanel);

        panel0.add(tab1);

        panel0.add(separator1);

        tab2.addTab("tab2", newsPanel);
        tab2.addTab("tab3", tablePanel);
        tab2.addTab("tab3", consolePanel);

        panel0.add(tab2);

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

        panel0.add(buttonPanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
            .addComponent(panel0, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addComponent(panel0, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }

}
