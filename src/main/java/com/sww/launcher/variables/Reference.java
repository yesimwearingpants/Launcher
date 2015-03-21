package com.sww.launcher.variables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reference {
	
	private Reference() {}
	
	public static final String TITLE = "Terracraft Launcher";
		
	public static final String VERSION = "0.1";

	public static List<String> Versions = new ArrayList<String>();
	
	public static List<Object> TableList = new ArrayList<Object>();

	public static Collection<List<Object>> TableListofLists = new ArrayList<List<Object>>();
	
	public static String Profile;

	public static String SaveLocation = "/";
	
	public static void addVersion() {
		Versions.add("0.0.1");
		Versions.add("0.0.2");
		Versions.add("0.0.3");
		Versions.add("0.1");
		Versions.add("0.3.1");
		Versions.add("0.1.2");
		Versions.add("0.1.3");
		Versions.add("0.2");
		Versions.add("0.2.1");
		Versions.add("0.2.2");
		Versions.add("0.2.3");
		Versions.add("0.3");
		Versions.add("0.3.1");
		Versions.add("0.3.2");
		Versions.add("0.3.3");
	}

}
