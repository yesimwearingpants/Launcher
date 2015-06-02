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

import com.sww.launcher.gui.elements.components.ListSet;
import com.sww.launcher.variables.Reference;

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
	public void addLine(String n, String v, String l, Boolean b) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", n, v, l, String.valueOf(b)));
        }
        catch(IOException e) {
            System.out.printf("Error writing to file '%s'\n\n", file);
            e.printStackTrace();
        }
	}
	

	
	public void editFile() {
		File tmp = new File(String.format("%s/tmp", Reference.gameDir.toString()));
		createFile(tmp);
		Iterator<ListSet<String>> it = Reference.TableListofLists.iterator();
		while(it.hasNext()) {
			ListSet<String> list = it.next();
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmp, true))) {
				bufferedWriter.write(String.format("%s\t%s\t%s\t%s\n", list.get(0), list.get(1), list.get(2), list.get(3)));
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
	            	ListSet<String> set = new ListSet<>();
	            	for(int i = 0; i < 4; i++) {
	            		set.add(array[i]);
	            	}
		            Reference.TableListofLists.add(set);
		            Reference.HashSet0.add(array[0]);
		            Reference.HashSet1.add(array[2]);
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
