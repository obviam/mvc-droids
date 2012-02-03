package net.obviam.droids.model;

public class Enemy {

	private float x;
	private float y;
	private int hitpoints = 10;
	
	public Enemy(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getHitpoints() {
		return hitpoints;
	}
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}
}
