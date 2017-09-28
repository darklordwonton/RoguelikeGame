package main.rendering.animation;

import java.util.Timer;
import java.util.TimerTask;

import main.entities.Entity;
import main.rendering.MainRenderer;

public class Animation {
	
	public static void Animate(Entity e){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				e.setSprite(e.getSprite(), (e.getSpriteX() + 1) % e.getTotalFrames(), e.getSpriteY(), e.getTotalFrames());
				MainRenderer.refresh();
			}
		}, 0, (long) Math.round(20 / e.getTotalFrames()) * 50);
	}
}
