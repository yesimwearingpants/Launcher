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
 * Created Jun 8, 2015
 */
package com.sww.launcher.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;

import com.sww.launcher.reference.Reference;

public final class Path implements java.nio.file.Path { 

	private String path;

	/** Default Save Location	*/
	public Path() {
		this.path = String.format("%s/%s", System.getProperty("user.home"), Reference.gameDir);
	}

	/**
	 * @param path sets the Path
	 */
	public Path(String path) {
		this.path = path;
	}
	
	/** 
	 * @return the path as a String
	 */
	@Override
	public String toString() {
		return path;
	}

	/** {@inheritDoc}	 */
	@Override
	public int compareTo(java.nio.file.Path other) {
		
		return 0;
	}

	/** {@inheritDoc}	 */
	@Override
	public boolean endsWith(java.nio.file.Path other) {
		
		return false;
	}

	/** {@inheritDoc}	 */
	@Override
	public boolean endsWith(String other) {
		
		return false;
	}

	/** {@inheritDoc}	 */
	@Override
	public java.nio.file.Path getFileName() {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public FileSystem getFileSystem() {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public java.nio.file.Path getName(int index) {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public int getNameCount() {
		
		return 0;
	}

	/**
	 * @see java.nio.file.Path#getParent()
	 */
	@Override
	public java.nio.file.Path getParent() {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#getRoot()
	 */
	@Override
	public java.nio.file.Path getRoot() {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public boolean isAbsolute() {
		
		return false;
	}

	/** {@inheritDoc}	 */
	@Override
	public Iterator<java.nio.file.Path> iterator() {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public java.nio.file.Path normalize() {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#register(WatchService, WatchEvent.Kind[])
	 */
	@Override
	public WatchKey register(WatchService watcher, Kind<?>... events)
			throws IOException {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#register(WatchService, WatchEvent.Kind[], WatchEvent.Modifier[])
	 */
	@Override
	public WatchKey register(WatchService watcher, Kind<?>[] events,
			Modifier... modifiers) throws IOException {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#relativize(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path relativize(java.nio.file.Path other) {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#resolve(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path resolve(java.nio.file.Path other) {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#resolve(String)
	 */
	@Override
	public java.nio.file.Path resolve(String other) {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#resolveSibling(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path resolveSibling(java.nio.file.Path other) {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#resolveSibling(String)
	 */
	@Override
	public java.nio.file.Path resolveSibling(String other) {
		
		return null;
	}

	/**
	 * @see java.nio.file.Path#startsWith(java.nio.file.Path)
	 */
	@Override
	public boolean startsWith(java.nio.file.Path other) {
		
		return false;
	}

	/**
	 * @see java.nio.file.Path#startsWith(String)
	 */
	@Override
	public boolean startsWith(String other) {
		
		return false;
	}

	/**
	 * @see java.nio.file.Path#subpath(int, int)
	 */
	@Override
	public java.nio.file.Path subpath(int beginIndex, int endIndex) {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public java.nio.file.Path toAbsolutePath() {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public File toFile() {
		java.nio.file.Path f = (java.nio.file.Path)this;
		return f.toFile();
	}

	/** {@inheritDoc}	 */
	@Override
	public java.nio.file.Path toRealPath(LinkOption... options)
			throws IOException {
		
		return null;
	}

	/** {@inheritDoc}	 */
	@Override
	public URI toUri() {
		java.nio.file.Path f = (java.nio.file.Path)this;
		return f.toUri();
	}

}
