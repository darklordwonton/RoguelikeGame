package main.dungeon;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.EnumFloor;
import main.tiles.Tile;
import main.tiles.TileFloor;

public class Floor {
	private Tile[][] tiles = null;
	private List<Entity> entities = new ArrayList<Entity> ();
	private int height = 0;
	private int width = 0;	
	
	public Floor (int h, int w, EnumFloor floor) {
		height = h;
		width = w;
		tiles = new Tile[h][w];
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				tiles[i][e] = new TileFloor();
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