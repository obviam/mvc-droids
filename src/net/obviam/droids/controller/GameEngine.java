package net.obviam.droids.controller;

import java.awt.Event;
import java.awt.Graphics;

import net.obviam.droids.model.Arena;
import net.obviam.droids.model.Droid;
import net.obviam.droids.view.Renderer;
import net.obviam.droids.view.SimpleArenaRenderer;

public class GameEngine {

	private Arena arena;
	private Droid droid;
	private Renderer renderer;
	private ArenaController controller;
	
	public GameEngine() {
		droid = new Droid();
		// position droid in the middle
		droid.setX(Arena.WIDTH / 2);
		droid.setY(Arena.HEIGHT / 2);
		arena = new Arena(droid);
		
		// setup renderer (view)
		renderer = new SimpleArenaRenderer(arena);
		// setup controller
		controller = new ArenaController(arena);
	}
	
	/** handle the Event passed from the main applet **/
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
			controller.onClick(e.x, e.y);
			break;
		case Event.MOUSE_MOVE:
			// mouse is being moved
			break;
		case Event.MOUSE_DRAG:
			// mouse is being dragged (button pressed)
			break;
		}
		return false;
	}
	
	/** the update method with the deltaTime in seconds **/
	public void update(float deltaTime) {
		controller.update(deltaTime);
	}
	
	/** this will render the whole world **/
	public void render(Graphics g) {
		renderer.render(g);
	}
}
