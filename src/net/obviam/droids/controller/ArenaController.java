package net.obviam.droids.controller;

import net.obviam.droids.model.Arena;
import net.obviam.droids.model.Droid;

public class ArenaController {

	private static final int unit = 32;
	private Arena arena;
	
	/** the target cell **/
	private float targetX, targetY;
	/** true if the droid moves **/
	private boolean moving = false;
	
	public ArenaController(Arena arena) {
		this.arena = arena;
	}
	
	public void update(float delta) {
		Droid droid = arena.getDroid();
		if (moving) {
			// move on X
			int bearing = 1;
			if (droid.getX() > targetX) {
				bearing = -1;
			} 
			if (droid.getX() != targetX) {
				droid.setX(droid.getX() + bearing * droid.getSpeed() * delta);
				// check if arrived
				if ((droid.getX() < targetX && bearing == -1)
						|| (droid.getX() > targetX && bearing == 1)) droid.setX(targetX);
			}
			// move on Y
			bearing = 1;
			if (droid.getY() > targetY) {
				bearing = -1;
			} 
			if (droid.getY() != targetY) {
				droid.setY(droid.getY() + bearing * droid.getSpeed() * delta);
				// check if arrived
				if ((droid.getY() < targetY && bearing == -1)
						|| (droid.getY() > targetY && bearing == 1)) droid.setY(targetY);
			}
			// check if arrived
			if (droid.getX() == targetX && droid.getY() == targetY) 
				moving = false;
		}
	}
	
	// * Input events ----------
	
	/** triggered with the coordinates every click **/
	public boolean onClick(int x, int y) {
		targetX = x / unit;
		targetY = y / unit;
		if (arena.getGrid()[(int) targetY][(int) targetX] == null) {
			// start moving the droid towards the target
			moving = true;
			return true;
		}
		return false;
	}
}
