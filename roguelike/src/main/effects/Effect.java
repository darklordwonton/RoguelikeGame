package main.effects;

import main.entities.Entity;
import main.tiles.Tile;

public class Effect {
	
	protected Entity origin = null;
	
	public Effect (Entity e) {
		origin = e;
	}
	
	public Entity getOrigin () {
		return origin;
	}
	
	public void affectEntity (Entity e) {}
	
	public void affectTile (Tile t) {}
	
}
