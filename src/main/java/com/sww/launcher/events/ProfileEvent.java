package com.sww.launcher.events;

import java.util.EventObject;

@SuppressWarnings("serial")
public class ProfileEvent extends EventObject {
	
	private static String name = "Default";
	private static String location = "/";
	private static String version = "0.0.1";
	private static Boolean bool = Boolean.FALSE;

	public ProfileEvent(Object source) {
		super(source);
	}

	public String getName() {

		return name;
	}

	public String getLocation() {

		return location;
	}

	public String getVersion() {

		return version;
	}

	public Boolean getBool() {

		return bool;
	}

	public void setName(String name) {

		ProfileEvent.name = name;
	}

	public void setLocation(String location) {

		ProfileEvent.location = location;
	}

	public void setVersion(String version) {

		ProfileEvent.version = version;
	}

	public void isActiveProfile(Boolean bool) {

		ProfileEvent.bool = bool;
	}

}
