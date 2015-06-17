/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     cpw - implementation
 */

package com.sww.logging;

import org.apache.logging.log4j.Level;

public class LogHelper {

	public static void log(Level logLevel, Object object)	{
		
		Logging.log("", logLevel, String.valueOf(object));		
	}
	
	public static void all(Object... object)	{
		log(Level.ALL, object);
	}

	public static void debug(Object... object)	{
		log(Level.DEBUG, object);
	}

	public static void error(Object... object)	{
		log(Level.ERROR,  object);
	}

	public static void fatal( Object... object)	{
		log(Level.FATAL, object);
	}

	public static void info(Object... object) {
		log(Level.INFO, object);
	}
	
	public static void off(Object... object) {
		log(Level.OFF, object);
	}
	
	public static void trace(Object... object) {
		log(Level.TRACE, object);
	}
	
	public static void warn(Object... object) {
		log(Level.WARN, object);
	}

}