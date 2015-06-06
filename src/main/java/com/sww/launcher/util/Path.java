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

public class Path implements java.nio.file.Path {
	private String path;
	
	/** 
	 * @return the path as a String
	 */
	@Override
	public String toString() {
		return path;
	}

	/**
	 * @param path sets the Path
	 */
	public Path(String path) {
		this.path = path;
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

	/* (non-Javadoc)
	 * @see java.nio.file.Path#getParent()
	 */
	@Override
	public java.nio.file.Path getParent() {
		
		return null;
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see java.nio.file.Path#register(java.nio.file.WatchService, java.nio.file.WatchEvent.Kind[])
	 */
	@Override
	public WatchKey register(WatchService watcher, Kind<?>... events)
			throws IOException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#register(java.nio.file.WatchService, java.nio.file.WatchEvent.Kind[], java.nio.file.WatchEvent.Modifier[])
	 */
	@Override
	public WatchKey register(WatchService watcher, Kind<?>[] events,
			Modifier... modifiers) throws IOException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#relativize(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path relativize(java.nio.file.Path other) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#resolve(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path resolve(java.nio.file.Path other) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#resolve(java.lang.String)
	 */
	@Override
	public java.nio.file.Path resolve(String other) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#resolveSibling(java.nio.file.Path)
	 */
	@Override
	public java.nio.file.Path resolveSibling(java.nio.file.Path other) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#resolveSibling(java.lang.String)
	 */
	@Override
	public java.nio.file.Path resolveSibling(String other) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#startsWith(java.nio.file.Path)
	 */
	@Override
	public boolean startsWith(java.nio.file.Path other) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.nio.file.Path#startsWith(java.lang.String)
	 */
	@Override
	public boolean startsWith(String other) {
		
		return false;
	}

	/* (non-Javadoc)
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
		
		return null;
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
		
		return null;
	}

}
