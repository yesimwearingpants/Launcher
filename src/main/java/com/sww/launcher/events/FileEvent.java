package com.sww.launcher.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import com.sww.launcher.variables.Reference;

public class FileEvent {
	
	/**
	 * @param file <br>Takes in a File</br>
	 */
	public FileEvent(File file) {
		this.file = file;
	}

	/** GameDir */
	private static File dirName = Reference.gameDir;
	@SuppressWarnings("unused")
	private static FileWriter fileWriter;
	private File file;
	LinkedHashSet<List<Object>> h = new LinkedHashSet<List<Object>>();
	
	public void createFile() {
		boolean r;
		if(!dirName.exists()) {
			r = false;
			try {
				dirName.mkdir();
				r = true;
			} catch (SecurityException e) {
				System.out.printf("Incorrect Permissionson on %s\n", dirName.toString());
				System.out.println(e.getMessage());
			}
		} else {
			r = true;
		}
		if(r) {
			if(!file.exists()) {
				try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter = new FileWriter(file))){
		        }
		        catch(IOException e) {
		            System.out.printf("Error creating file '%s'\n\n", file);
		            e.printStackTrace();
		        }
			}
		}
	}
	
	/**
	 * Adds a new entry to File file
	 * @param n <br>Profile Name</br>
	 * @param l <br>Game Files / Save Location</br>
	 * @param v <br>Game Version</br>
	 * @param b <br><code>isProfileActive()</code> Defaults to false <strong>for now</strong></br>
	 */
	public void addLine(String n, String v, String l, Boolean b) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter = new FileWriter(file, true))) {
			bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n\n", n, v, l, String.valueOf(b)));
        }
        catch(IOException e) {
            System.out.printf("Error writing to file '%s'\n\n", file);
            e.printStackTrace();
        }
	}
	
	public void readFile() {
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
	        try (Scanner s = new Scanner(Reference.configFile)) {
	            s.nextLine();
	            while(s.hasNextLine()) {
		            line = reader.readLine();
	            	String array[] = line.split("\t");
	            	List<Object> set = new ArrayList<Object>();
	            	for(int i = 0; i < 4;) {
	            		set.add(array[i]);
	            		System.out.println(set);
	            		i++;
	            	}
		            Reference.TableListofLists.add(set);
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
