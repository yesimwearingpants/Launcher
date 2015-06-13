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
package com.sww.launcher;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.events.ProfileEvent;
import com.sww.launcher.gui.Window;
import com.sww.launcher.reference.Reference;


public class Main {
		
	boolean isLauncherOpen = false;
	boolean isGameRunning = false;	

	public static void main(String[] args) {

		Reference.addVersion();
		Reference.buildTable();
		FileEvent c = new FileEvent(Reference.configFile);
		ProfileEvent p = new ProfileEvent(new Object());
		c.createFile();
		if(Reference.configFile.length() == 0) {
			c.setActiveProfile(0);
			c.addLine(p.getName(), p.getVersion(), p.getLocation());
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
