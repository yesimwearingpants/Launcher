package com.sww.launcher.variables;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reference {
		
	public static final String TITLE = "Terracraft Launcher";
		
	public static final String VERSION = "0.1";

	public static List<String> Versions = new ArrayList<String>();
	
	public static List<String> TableList = new ArrayList<String>();

	public static List<List<Object>> TableListofLists = new ArrayList<>();
	
	public static String Profile;

	public static String SaveLocation = "/";

	public static List<String> Servers = new ArrayList<String>();
	/** GameDir */
	public static final File gameDir = new File(".Terracraft");
	/** Config File */
	public static final File configFile = new File(String.format("%s/Terracraft", gameDir.toString()));
	/** Logger File */
	public static final File logFile = new File(String.format("%s/Log.%s", gameDir.toString(), new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss").format(new Date(System.currentTimeMillis()))));

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
		Versions.add("0.3.0");
		Versions.add("0.3.1");
		Versions.add("0.3.2");
		Versions.add("0.3.3");
	}

}
