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
 * Created June 15, 2015
 */
package com.sww.launcher.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

	public final ResourceBundle lang;
	
	public I18n() {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", Locale.getDefault());
	}

	public I18n(String lang, String country) {
		Locale locale = new Locale(lang, country);
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}
	
	public I18n(Locale locale) {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}

	

}
