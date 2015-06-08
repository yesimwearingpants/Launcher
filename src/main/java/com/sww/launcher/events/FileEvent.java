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
 * Created May 14, 2015
 */
package com.sww.launcher.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import com.sww.launcher.reference.Reference;
import com.sww.launcher.util.Path;
import com.sww.launcher.util.Profile;

public class FileEvent {
	
	/**
	 * @param file <br>Takes in a File</br>
	 */
	public FileEvent(File file) {
		this.file = file;
	}

	private File file;
	
	public void createFile() {
		boolean r;
		if(!Reference.gameDir.exists()) {
			r = false;
			try {
				Reference.gameDir.mkdir();
				r = true;
			} catch (SecurityException e) {
				System.out.printf("Incorrect Permissionson on %s\n", Reference.gameDir.toString());
				System.out.println(e.getMessage());
			}
		} else {
			r = true;
		}
		if(r) {
			if(!file.exists()) {
				try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
		        }
		        catch(IOException e) {
		            System.out.printf("Error creating file '%s'\n\n", file);
		            e.printStackTrace();
		        }
			}
		}
	}

	private void createFile(File f) {
		if(!f.exists()) {
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))){
	        }
	        catch(IOException e) {
	            System.out.printf("Error creating file '%s'\n\n", f);
	            e.printStackTrace();
	        }
		}
	}
	
	/**
	 * Adds a new entry to File file
	 * @param n Profile Name
	 * @param l Game Files / Save Location
	 * @param v Game Version
	 * @param b <code>isProfileActive()</code> Defaults to false <strong>for now</strong>
	 */
	public void addLine(String n, String v, Path l) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", n, v, l.toString()));
        }
        catch(IOException e) {
            System.out.printf("Error writing to file '%s'\n\n", file);
            e.printStackTrace();
        }
	}
	

	
	public void editFile() {
		File tmp = new File(String.format("%s/tmp", Reference.gameDir.toString()));
		createFile(tmp);
		Iterator<Profile> it = Reference.Profiles.iterator();
		while(it.hasNext()) {
			Profile list = it.next();
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmp, true))) {
				bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", list.getName(), list.getVersion(), list.getLocation()));
	        }
	        catch(IOException e) {
	            System.out.printf("Error writing to file '%s'\n\n", file);
	            e.printStackTrace();
	        }
		}
		file.delete();
		tmp.renameTo(file);
	}

	public void readFile() {
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
	        try (Scanner s = new Scanner(Reference.configFile)) {
	            while(s.hasNextLine()) {
		            line = reader.readLine();
	            	String array[] = line.split("\t");
	            	Profile profile = new Profile(array[0], array[1], new Path(array[2]));
		            Reference.Profiles.add(profile);
		            Reference.HashSet0.add(array[0]);
		            Reference.HashSet1.add(new Path(array[2]));
		            s.nextLine();
	        	}
	            reader.close();
	        }
		} catch (FileNotFoundException e) {
            System.out.printf("File '%s' not found\n\n", file);
            e.printStackTrace();
		} catch(IOException ex) {
        	ex.printStackTrace();
        }
	}

}
