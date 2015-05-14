package com.sww.launcher.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

	private File file;
	LinkedHashSet<List<Object>> h = new LinkedHashSet<List<Object>>();
	
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
	 * @param n <br>Profile Name</br>
	 * @param l <br>Game Files / Save Location</br>
	 * @param v <br>Game Version</br>
	 * @param b <br><code>isProfileActive()</code> Defaults to false <strong>for now</strong></br>
	 */
	public void addLine(String n, String v, String l, Boolean b) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", n, v, l, String.valueOf(b)));
        }
        catch(IOException e) {
            System.out.printf("Error writing to file '%s'\n\n", file);
            e.printStackTrace();
        }
	}
	
	/**
	 * Adds a new entry to File f
	 * @param n <br>Profile Name</br>
	 * @param l <br>Game Files / Save Location</br>
	 * @param v <br>Game Version</br>
	 * @param b <br><code>isProfileActive()</code> Defaults to false <strong>for now</strong></br>
	 */
	private void addLine(String n, String v, String l, Boolean b, File f) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true))) {
			bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", n, v, l, String.valueOf(b)));
        }
        catch(IOException e) {
            System.out.printf("Error writing to file '%s'\n\n", f);
            e.printStackTrace();
        }
	}
	
	public void editFile() {
		File tmp = new File(String.format("%s/tmp", Reference.gameDir.toString()));
		createFile(tmp);
		Iterator<List<Object>> it = Reference.TableListofLists.iterator();
		while(it.hasNext()) {
			ArrayList<Object> list = (ArrayList<Object>) it.next();
			addLine((String) list.get(0), (String) list.get(1), (String) list.get(2), Boolean.valueOf((String) list.get(3)), tmp);
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
	            	List<Object> set = new ArrayList<Object>();
	            	for(int i = 0; i < 4;) {
	            		set.add(array[i]);
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
