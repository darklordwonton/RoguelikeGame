package main.tiles;

import java.util.ArrayList;
import java.util.List;

import main.effects.Effect;
import main.effects.attacks.Attack;
import main.entities.Entity;
import main.items.Item;

public abstract class Tile {
	protected String sprite = null;
	protected boolean wall = false;
	protected int x = 0;
	protected int y = 0;
	protected int spriteSheetRow = 0;
	protected int spriteSheetColumn = 0;
	protected Entity entity = null;
	protected Item item = null;
	protected List<Effect> effects = null;
	
	protected Tile(int x, int y) {
		this.x = x;
		this.y = y;
		effects = new ArrayList<Effect>();
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
	
	public void onStep(Item t){
		item = t;
	}
	
	//When an entity leaves the tile
	public void onLeave(Entity e) {
		entity = null;
	}
	
	public void onLeave(Item t){
		item = null;
	}
	
	//When an entity attacks a wall tile
	public void onAttack(Attack a) {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void incrementAnimation() {
		if (entity != null)
			entity.incrementAnimation();
		for (Effect e : effects) {
			e.incrementAnimation();
		}
	}
	
	public void addEffect(Effect e) {
		effects.add(e);
	}
	
	public void clearEffects() {
		effects.clear();
	}
	
	public List<Effect> getEffects() {
		return effects;
	}
}
