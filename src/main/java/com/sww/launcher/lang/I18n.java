/**
 * Copyright (c) 2015 Greg Wright
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * @author yesimwearingpants
 * Created Jul 1, 2015
 */
package com.sww.launcher.lang;

import java.util.Locale;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class I18n.
 */
public class I18n {

	/** The lang. */
	public final ResourceBundle lang;
	
	/** The i18n. */
	private static I18n i18n;
	
	/**
	 * Quick Constructor Inits to System Locale
	 */
	public I18n() {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", Locale.getDefault());
	}

	/**
	 * Instantiates a new i18n
	 *
	 * @param lang the language
	 * @param country the country
	 */
	public I18n(String lang, String country) {
		Locale locale = new Locale(lang, country);
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}
	
	/**
	 * Instantiates a new i18n.
	 *
	 * @param locale the Locale
	 */
	public I18n(Locale locale) {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}

	/**
	 * Gets the ResourceBundle.
	 *
	 * @return the i18n
	 */
	public static ResourceBundle getI18n() {
		i18n = new I18n();
		return i18n.lang;
	}

	/**
	 * Gets the ResourceBundle.
	 *
	 * @param lang the lang
	 * @param country the country
	 * @return the i18n
	 */
	public static ResourceBundle getI18n(String lang, String country) {
		i18n = new I18n(lang, country);
		return i18n.lang;
	}

	/**
	 * Gets the ResourceBundle.
	 *
	 * @param locale the locale
	 * @return the i18n
	 */
	public static ResourceBundle getI18n(Locale locale) {
		i18n = new I18n(locale);
		return i18n.lang;
	}

	/**
	 * Quick access to getString method
	 *
	 * @param l10n the sting to be localized
	 * @return the ResourceBundle String
	 */
	public static String getI18ns(String l10n) {
		i18n = new I18n();
		return i18n.lang.getString(l10n);
	}

	/**
	 * Quick access to getString method
	 *
	 * @param l10n the sting to be localized
	 * @param lang the lang
	 * @param country the country
	 * @return the ResourceBundle String
	 */
	public static String getI18ns(String l10n, String lang, String country) {
		i18n = new I18n(lang, country);
		return i18n.lang.getString(l10n);
	}

	/**
	 * Quick access to getString method
	 *
	 * @param l10n the sting to be localized
	 * @param locale the locale
	 * @return the ResourceBundle String
	 */
	public static String getI18ns(String l10,Locale locale) {
		i18n = new I18n(locale);
		return i18n.lang.getString(l10);
	}


}
