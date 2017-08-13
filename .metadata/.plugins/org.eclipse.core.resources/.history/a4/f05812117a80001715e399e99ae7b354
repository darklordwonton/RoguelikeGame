package main.tiles;

import main.attacks.Attack;
import main.entities.Entity;

public abstract class Tile {
	protected String sprite = null;
	protected boolean wall = false;
	protected int x = 0;
	protected int y = 0;
	protected int spriteSheetRow = 0;
	protected int spriteSheetColumn = 0;
	
	
	protected Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getSprite(){
		return sprite;
	}

	public int getSpriteSheetRow(){
		return spriteSheetRow;
	}
	
	public int getSpriteSheetColumn(){
		return spriteSheetColumn;
	}
	
	public boolean isWall() {
		return wall;
	}
	
	public void setSheetPos(int x, int y){
		spriteSheetRow = y;
		spriteSheetColumn = x;
	}
	
	
	public void onStep(Entity e) {}
	
	public void onAttack(Attack a) {}
}
