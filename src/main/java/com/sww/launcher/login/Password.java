package com.sww.launcher.login;

import org.jdesktop.swingx.auth.PasswordStore;

public class Password extends PasswordStore {

	@Override
	public boolean set(String username, String server, char[] password) {
		return false;
	}

	@Override
	public char[] get(String username, String server) {
		return null;
	}

	@Override
	public void removeUserPassword(String username) {
		
	}

}
