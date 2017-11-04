package main.rendering.animation;

import java.util.Timer;
import java.util.TimerTask;

import main.effects.Effect;
import main.entities.Entity;
import main.rendering.MainRenderer;

public class Animation {
	
	private static Effect[][] effects = null;
	
	public static void animate(Entity e) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				e.setSprite(e.getSprite(), (e.getSpriteX() + 1) % e.getTotalFrames(), e.getSpriteY(), e.getTotalFrames());
				MainRenderer.refresh();
			}
		}, 0, (long) Math.round(20 / e.getTotalFrames()) * 50);
	}
	
	/*public static void animate(Effect e) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				e.incrementAnimation();
				MainRenderer.refresh();
			}
		}, 0, (long) Math.round(20 / e.getTotalFrames()) * 50);
	}*/
	
	public static void resetEffects(int w, int h) {
		effects = new Effect[w][h];
	}
	
	public static void addEffect(Effect e, int x, int y) {
		effects[x][y] = e;
	}
	
	public static Effect[][] getEffects() {
		return effects;
	}
}
