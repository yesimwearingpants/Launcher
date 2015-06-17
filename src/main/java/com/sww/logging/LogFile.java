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
