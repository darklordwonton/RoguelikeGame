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
	protected Entity entity = null;
	
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
	
	public Entity getResidentEntity() {
		return entity;
	}
	
	//When an entity enters the tile
	public void onStep(Entity e) {
		entity = e;
	}
	
	//When an entity leaves the tile
	public void onLeave(Entity e) {
		entity = null;
	}
	
	//When an entity attacks a wall tile
	public void onAttack(Attack a) {}
}
