package com.sww.launcher;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.gui.Window;
import com.sww.launcher.variables.Reference;


public class Main {
	
	static int x = 720;
	static int y = x / 16 * 9;
	
	boolean isLauncherOpen = false;
	boolean isGameRunning = false;	

	public static void main(String[] args) {

		Reference.addVersion();
		Reference.buildTable();
		FileEvent c = new FileEvent(Reference.configFile);
		ProfileEvent p = new ProfileEvent(new Object());
		c.createFile();
		if(Reference.configFile.length() == 0) {
			c.addLine(p.getName(), p.getVersion(), p.getLocation(), p.getBool());
			c.readFile();
		} else {
			c.readFile();
		}
		FileEvent l = new FileEvent(Reference.logFile);;
		l.createFile();
		
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        	Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

		SwingUtilities.invokeLater(() -> {
			Window win = new Window();
			win.setVisible(true);
		});
	}

}
