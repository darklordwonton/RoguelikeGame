package main.tiles;

import main.attacks.Attack;
import main.entities.Entity;

public abstract class Tile {
	protected String sprite = null;
	protected boolean wall = false;
	protected int x = 0;
	protected int y = 0;
	
	protected Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getSprite(){
		return sprite;
	}

	public boolean isWall() {
		return wall;
	}
	
	public void onStep(Entity e) {}
	
	public void onAttack(Attack a) {}
}
