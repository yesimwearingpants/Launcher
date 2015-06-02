package com.sww.launcher.gui.elements.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("serial")
public class ListSet<E> extends ArrayList<E> {

	private List<ListSet<E>> list;

	public ListSet() {
		super();
	}

	public ListSet(List<ListSet<E>> list) {
		super();
		this.list = list;
	}

	public ListSet(Collection<? extends E> c) {
		super(c);
	}

	public ListSet(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public boolean add(E e) {
		return super.add(e);
	}

	@Override
	public void add(int index, E element) {
		super.add(index, element);
	}

	public boolean check(List<E> set, int index, E element) {
		for(ListSet<E> ll : list) {
			for(E l : set ) {
				if(ll.contains(l.equals(element))) {
					return false;
				}
			}
		}
		add(index, element);
		return true;
	}

	public boolean check(List<E> set, E element) {
		for(ListSet<E> ll : list) {
			for(E l : set ) {
				if(ll.contains(l.equals(element))) {
					return false;
				}
			}
		}
		add(element);
		return true;
	}

}
