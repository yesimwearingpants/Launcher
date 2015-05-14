package com.sww.launcher.events;

import java.util.EventListener;
import java.util.EventObject;


public interface IListener extends EventListener {
	
	void addAction(EventObject e);

}
