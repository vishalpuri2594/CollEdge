package com.mycollege.mait;

import android.app.Application;

public class LoginState extends Application {

	
	
	public static boolean login = false;

	public void setLoginState(boolean login) {
		this.login = login;
	}

	public boolean getLoginState() {
		return login;
	}
}
