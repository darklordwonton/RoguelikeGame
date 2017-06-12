package main.dungeon;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.tiles.TileFloor;
import main.util.Globals;

public class Floor {
	private Tile[][] tiles = null;
	private List<Entity> entities = new ArrayList<Entity> ();
	private int height = 0;
	private int width = 0;
	private EnumTheme theme = null;
	
	public Floor (int h, int w, EnumTheme t) {
		height = h;
		width = w;
		theme = t;
		tiles = new Tile[h][w];
		Globals.floorNum++;
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				tiles[i][e] = new TileFloor(t);
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
	
	public EnumTheme getTheme() {
		return theme;
	}
	
}
