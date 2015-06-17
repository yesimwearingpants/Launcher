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
 * Created June 17, 2015
 */
package com.sww.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.sww.launcher.reference.Reference;

//Find a Better Way
public class LogFile {
	
	private final FileWriter writer;
	private Logger logger = Logging.log.getLogger();
	
	public LogFile() throws IOException {
		writer = new FileWriter(Reference.logFile, true);
		StringBuilder builder = new StringBuilder();
		builder.append(logger);
		writer.write(builder.toString());
	}

	public LogFile(String modid) throws IOException {
		writer = new FileWriter(modid, true);
		StringBuilder builder = new StringBuilder();
		builder.append(logger);
		writer.write(builder.toString());
	}

	public LogFile(File log) throws IOException {
		writer = new FileWriter(log, true);
		StringBuilder builder = new StringBuilder();
		builder.append(logger);
		writer.write(builder.toString());
	}

}
