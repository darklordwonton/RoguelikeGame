package main.dungeon;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.Tile;
import main.tiles.TileBlank;

public class Map {
	private Tile[][] tiles = null;
	private List<Entity> entities = new ArrayList<Entity> ();
	private int height = 0;
	private int width = 0;	
	
	public Map (int h, int w) {
		height = h;
		width = w;
		tiles = new Tile[h][w];
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				tiles[i][e] = new TileBlank();
			}
		}
	}
	
	public Tile getTile (int x, int y) {
		return tiles[x][y];
	}
	
	public Tile[][] getTileMap() {
		return tiles;
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public Entity[] getEntities(){
		return entities.toArray(new Entity[entities.size()]);
	}
}
