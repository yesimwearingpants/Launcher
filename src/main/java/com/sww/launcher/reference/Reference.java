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
 * Modified by @author chess123mate
 * Created Mar 22, 2015
 */
package com.sww.launcher.reference;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.sww.launcher.util.ListSet;
import com.sww.launcher.util.Profile;

import static com.sww.launcher.Main.i18n;

public abstract class Reference {

	/**	Application (Launcher) Title	*/
	public static final String TITLE = String.format("%s%s", i18n.lang.getString("game"), i18n.lang.getString("launcher"));
	/**	Application (Launcher) Version	*/	
	public static final String VERSION = "0.1";
	/**	Game Versions	*/
	public static List<String> Versions = new ArrayList<>();
	/**	Line Number of Currently Active Profile	*/
	public static int ActiveProfile;
	/**	List Containing Table Rows	*/
	public static ListSet<Profile> Profiles = new ListSet<>();
	/**	HastSet of Profile Names	*/
	public static HashSet<String> HashSet0 = new HashSet<>();
	/**	HashSet of Locations as Path	*/
	public static HashSet<Path> HashSet1 = new HashSet<>();
	/**	Server List	*/
	public static List<String> Servers = new ArrayList<String>();
	/**	Default Save Location	*/
	public static final Path rootDir = Paths.get(System.getProperty("user.home"));
	/** Game Directory	*/
	public static final Path gameDir = Paths.get("/.Terracraft");
	/** Logger File	*/
	public static final File logFile = Paths.get(String.format("%s%s/Log.%s", rootDir, gameDir, new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss").format(new Date(System.currentTimeMillis())))).toFile();
	/** Configuration File	*/
	public static final File configFile = Paths.get(String.format("%s%s/Terracraft", rootDir, gameDir)).toFile();
	/**	Returns the Active Profile	*/
	public static Profile GetActiveProfile() {
		return Profiles.get(ActiveProfile);
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
