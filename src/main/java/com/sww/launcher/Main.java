package com.sww.launcher;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jdesktop.swingx.util.OS;

import com.sww.launcher.file.Profile;
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
		Profile c = new Profile(Reference.configFile);
		c.createFile();
		Profile l = new Profile(Reference.logFile);;
		l.createFile();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Window win = new Window();
				win.setVisible(true);
				win.init();
			}
		});
		
		if(OS.isLinux())
	        try {
	            UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
	            for (int idx=0; idx<installedLookAndFeels.length; idx++)
	                if("GTK+".equals(installedLookAndFeels[idx].getName())) {
	                    UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
	                    break;
	                }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
	        }
        
        
	}

}
