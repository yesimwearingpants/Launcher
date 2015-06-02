package com.sww.launcher.variables;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sww.launcher.gui.elements.components.ListSet;

public abstract class Reference {
	/**	Application (Launcher) Title	*/
	public static final String TITLE = "Terracraft Launcher";
	/**	Application (Launcher) Version	*/	
	public static final String VERSION = "0.1";
	
	public static List<String> Versions = new ArrayList<String>();
	/** Table Columns	*/
	public static List<String> TableList = new ArrayList<String>();
	/**	Contains Table Rows as <code>ListSet</code>s	*/
	public static List<ListSet<String>> TableListofLists = new ArrayList<>();
	/** Profile Name HashSet	*/
	public static List<String> HashSet0 = new ArrayList<>();
	/**	Save Location HashSet	*/
	public static List<String> HashSet1 = new ArrayList<>();
	/** Default Save Location	*/
	public static String SaveLocation = "/";
	/**	Server List	*/
	public static List<String> Servers = new ArrayList<String>();
	/** Game Directory	*/
	public static final File gameDir = new File(".Terracraft");
	/** Logger File	*/
	public static final File logFile = new File(String.format("%s/Log.%s", gameDir.toString(), new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss").format(new Date(System.currentTimeMillis()))));
	/** Configuration File	*/
	public static final File configFile = new File(String.format("%s/Terracraft", gameDir.toString()));

	public static void buildTable() {
		TableList.add("Profile");
		TableList.add("Version");
		TableList.add("Location");
		TableList.add("Active");
	}

	public static void addVersion() {
		Versions.add("0.0.1");
		Versions.add("0.0.2");
		Versions.add("0.0.3");
		Versions.add("0.1.0");
		Versions.add("0.1.1");
		Versions.add("0.1.2");
		Versions.add("0.1.3");
		Versions.add("0.2.0");
		Versions.add("0.2.1");
		Versions.add("0.2.2");
		Versions.add("0.2.3");
	}

}
