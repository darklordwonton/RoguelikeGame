package main.effects;

import java.awt.image.BufferedImage;

import main.entities.Entity;
import main.tiles.Tile;

public class Effect {
	
	protected Entity origin = null;
	protected int animationFrames = -1;
	protected int currentFrame = 0;
	
	protected String sprite = null;
	
	public Effect (Entity e) {
		origin = e;
	}
	
	public Entity getOrigin () {
		return origin;
	}
	
	public void affectEntity (Entity e) {}
	
	public void affectTile (Tile t) {}
	
	public void incrementAnimation() {
		currentFrame++;
		if (currentFrame >= animationFrames) {
			currentFrame = 0;
		}
	}
	
	public int getTotalFrames() {
		return animationFrames;
	}
	
	public BufferedImage getSprite() {
		return null;
	}
	
}
