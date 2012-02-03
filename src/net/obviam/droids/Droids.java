package net.obviam.droids;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.obviam.droids.controller.GameEngine;

public class Droids extends Applet implements Runnable {

	private static final long serialVersionUID = -2472397668493332423L;
	
	private GameEngine engine = new GameEngine();

	public void start() {
		new Thread(this).start();
	}

	public void run() {
		
		setSize(480, 320); // For AppletViewer, remove later.

		// Set up the graphics stuff, double-buffering.
		BufferedImage screen = new BufferedImage(480, 320, BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		Graphics appletGraphics = getGraphics();

		long delta = 0l;
		
		// Game loop.
		while (true) {
			long lastTime = System.nanoTime();

			g.setColor(Color.black);
			g.fillRect(0, 0, 480, 320);

			// Update the state (convert to seconds)
			engine.update((float)(delta / 1000000000.0));
			// Render the world
			engine.render(g);
			
			// Draw the entire results on the screen.
			appletGraphics.drawImage(screen, 0, 0, null);

			// Lock the frame rate
			delta = System.nanoTime() - lastTime;
			if (delta < 20000000L) {
				try {
					Thread.sleep((20000000L - delta) / 1000000L);
				} catch (Exception e) {
					// It's an interrupted exception, and nobody cares
				}
			}

			if (!isActive()) {
				return;
			}
		}
	}

	public boolean handleEvent(Event e) {
		return engine.handleEvent(e);
	}
	
}