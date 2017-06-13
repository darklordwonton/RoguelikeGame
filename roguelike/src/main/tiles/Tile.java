package main.tiles;

import main.entities.Entity;

public abstract class Tile {
	protected String sprite = null;
	protected boolean wall = false;
	
	protected Tile() {}
	
	public String getSprite(){
		return sprite;
	}

	public boolean isWall() {
		return wall;
	}
	
	public void onStep(Entity e) {}
}
