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
 * @author chess123mate
 * Modified by @author yesimwearingpants
 * Created Jun 5, 2015
 */
package com.sww.launcher.util;

import java.nio.file.Path;

public class Profile {

	private final String name;
	private final String version;
	private final Path location;

	public Profile(String name, String version, Path location) {
		this.name = name;
		this.version = version;
		this.location = location;
	}
	
	public Object get(int i) {
		switch (i) {
			case 0: return name;
			case 1: return version;
			case 2: return location;
			default : return Boolean.FALSE;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the location
	 */
	public Path getLocation() {
		return location;
	}
}