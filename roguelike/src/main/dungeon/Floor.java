package main.dungeon;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.tiles.TileFloor;

import main.tiles.TileWall;

import main.util.Globals;

public class Floor {
	private Tile[][] tiles = null;
	private List<Entity> entities = new ArrayList<Entity> ();
	private Room[] rooms = null;
	private int height = 0;
	private int width = 0;
	private EnumTheme theme = null;
	
	public Floor (int h, int w, EnumTheme t) {
		height = h;
		width = w;
		theme = t;
		tiles = new Tile[h][w];		
		rooms = new Room[4];
		boolean[][] filled = new boolean[h][w];
		
		tiles = new Tile[h][w];
		Globals.floorNum++;
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				filled[i][e] = false;
			}
		}
		
		rooms[0] = new Room(3,3);
		
		for (int i = 1; i < rooms.length; i++){
			rooms[i] = new Room((int)(Math.random() * 5), (int)(Math.random() * 5));
		}
		
		for (int i = 0; i < rooms.length; i++){
			rooms[i].basicRoom();
			int x = rooms[i].getX();
			int y = rooms[i].getY();
			
			for (int e = 0; e < rooms[i].getSizeX(); e++){
				for (int r = 0; r < rooms[i].getSizeY(); r++){
					if (!rooms[i].isWall(e, r)){
						tiles[x + e][y + r] = new TileFloor(t);
						filled[x + e][y + r] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				if (!filled[i][e]){
					tiles [i][e]= new TileWall(t);
					filled[i][e] = true;
				}
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
