package net.obviam.droids.controller;

import java.awt.Event;
import java.awt.Graphics;

public class GameEngine {

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
	
	/** the update method with the deltaTime in seconds **/
	public void update(float deltaTime) {
		
	}
	
	public void render(Graphics g) {
		
	}
}
