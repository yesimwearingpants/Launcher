/**
 * Copyright (c) 2015 Greg Wright
 *	
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the termsof the MIT License
 * 
 * @author yesimwearingpants
 * Created Jun 8, 2015
 */
package com.sww.launcher.util;

import static com.sww.launcher.reference.Reference.HashSet0;
import static com.sww.launcher.reference.Reference.HashSet1;

import java.util.ArrayList;

import com.sww.launcher.events.FileEvent;
import com.sww.launcher.reference.Reference;

@SuppressWarnings({ "serial"})
public class ListSet<E> extends ArrayList<E> {
	private boolean elementOkay(E profile) {
		return !(HashSet0.contains(((Profile) profile).getName()) || HashSet1.contains(((Profile) profile).getLocation()));
	}
	private void addToHash(E profile){
		HashSet0.add(((Profile) profile).getName());
		HashSet1.add((Path) ((Profile) profile).getLocation());
	}
	private void removeFromHash(Object profile){
		HashSet0.remove(((Profile) profile).getName());
		HashSet1.remove(((Profile) profile).getLocation());
	}
	@Override
	public boolean add(E profile) {
		if (!elementOkay(profile))
			return false;
		addToHash(profile);
		return super.add(profile);
	}
	@Override
	@Deprecated /**	please use addAsBoolean */
	public void add(int index, E profile) {
		super.add(index, profile);
	}
	public boolean addAsBoolean(int index, E profile) {
		if (!elementOkay(profile))
			return false;
		super.remove(index);
		add(index, profile);
		addToHash(profile);
		return true;
	}
	@Override
	public boolean remove(Object profile){
		if (!super.remove(profile))
			return false;
		removeFromHash(profile);
		return true;
	}
	@Override
	public void clear(){
		super.clear();
		HashSet0.clear();
		HashSet1.clear();
		Reference.configFile.delete();
		FileEvent f = new FileEvent(Reference.configFile);
		f.createFile();
	}
}