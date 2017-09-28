package main.entities;

import java.util.Timer;
import java.util.TimerTask;

import main.rendering.MainRenderer;

public class Animation {
	
	int totalFrames;
	int currentFrame;
	String sprite;
//	Timer timer = null;
	
	public Animation(){
	}
	
	public Animation(String sprite, int spriteSheetColumn, int spriteSheetRow, int totalFrames){
		currentFrame = spriteSheetColumn;
		this.totalFrames = totalFrames;
		this.sprite = sprite;
		
	}
	
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
