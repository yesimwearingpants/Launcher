/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */

package com.sww.logging;

import java.io.PrintStream;

import org.apache.logging.log4j.Logger;

import com.sww.launcher.gui.elements.components.ConsoleStream;

/**
 * PrintStream which redirects it's output to a given logger.
 * 
 * @author Arkan
 */
public class TracingPrintStream extends PrintStream {
    
    private Logger logger;
    
    public TracingPrintStream(Logger logger, PrintStream original) {
        super(original);
        this.logger = logger;
    }
    
    public TracingPrintStream(Logger logger, ConsoleStream consoleStream) {
    	super(consoleStream);
    	this.logger = logger;
	}

	@Override
    public void println(Object o) {
        logger.info(getPrefix() + o);
    }
    
    @Override
    public void println(String s) {
        logger.info(getPrefix() + s);
    }
    
    private String getPrefix() {
        StackTraceElement[] elems = Thread.currentThread().getStackTrace();
        StackTraceElement elem = elems[3]; // The caller is always at depth 2, plus this call.
        return "[" + elem.getClassName() + ":" + elem.getMethodName() + ":" + elem.getLineNumber() + "]: ";
    }

}