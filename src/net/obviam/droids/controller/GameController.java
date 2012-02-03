package net.obviam.droids.controller;

import java.awt.Event;

public class GameController {

	public boolean handleEvent(Event e) {
		switch (e.id) {
		case Event.KEY_PRESS:
		case Event.KEY_ACTION:
			// key pressed
			break;
		case Event.KEY_RELEASE:
			// key released
			break;
		case Event.MOUSE_DOWN:
			// mouse button pressed
			break;
		case Event.MOUSE_UP:
			// mouse button released
			break;
		case Event.MOUSE_MOVE:
			break;
		case Event.MOUSE_DRAG:
			break;
		}
		return false;
	}
	
}
