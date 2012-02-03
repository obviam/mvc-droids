package net.obviam.droids.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
	
	public static final int WIDTH = 480 / 32;
	public static final int HEIGHT = 320 / 32;
	
	private static Random random = new Random(System.currentTimeMillis());

	private Object[][] grid;
	private List<Obstacle>	obstacles = new ArrayList<Obstacle>();
	private List<Enemy>		enemies = new ArrayList<Enemy>();
	private Droid droid;
	
	public Arena(Droid droid) {
		this.droid = droid;

		grid = new Object[HEIGHT][WIDTH];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				grid[j][i] = null;
			}
		}
		// add the droid
		grid[(int)droid.getY()][(int) droid.getX()] = droid;
		
		// add 5 obstacles and 5 enemies at random positions
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			while (grid[y][x] != null) {
				x = random.nextInt(WIDTH);
				y = random.nextInt(HEIGHT);
			}
			grid[y][x] = new Obstacle(x, y);
			obstacles.add((Obstacle) grid[y][x]);
			while (grid[y][x] != null) {
				x = random.nextInt(WIDTH);
				y = random.nextInt(HEIGHT);
			}
			grid[y][x] = new Enemy(x, y);
			enemies.add((Enemy) grid[y][x]);
		}
	}
	
	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	public List<Enemy> getEnemies() {
		return enemies;
	}
	public Droid getDroid() {
		return droid;
	}

	public Object[][] getGrid() {
		return grid;
	}
	
}
