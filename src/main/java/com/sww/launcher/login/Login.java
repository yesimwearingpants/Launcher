package com.sww.launcher.login;

import org.jdesktop.swingx.auth.LoginService;

public class Login extends LoginService {

	public Login() {
		super("https://terracraft.thisyear.me");
	}

	@Override
	public boolean authenticate(String name, char[] password, String server)
			throws Exception {
		return false;
	}

}
