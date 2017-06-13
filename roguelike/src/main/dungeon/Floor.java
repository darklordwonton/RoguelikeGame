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
	private EnumTheme[] theme = null;
	
	public Floor (int h, int w, EnumTheme[] t, int stairsX, int stairsY) {
		height = h;
		width = w;
		theme = t;
		tiles = new Tile[h][w];		
		rooms = new Room[Globals.ROOMS_PER_FLOOR];
		boolean[][] filled = new boolean[h][w];
		//int stairsX = (int)(Math.random() * Globals.FLOOR_SIZE) + 1;
		//int stairsY = (int)(Math.random() * Globals.FLOOR_SIZE) + 1;
		
		tiles = new Tile[h][w];
		Globals.floorNum++;
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				filled[i][e] = false;
			}
		}
		
		rooms[0] = new Room(0,0);
		
		tiles[stairsX][stairsY] = new TileFloor(t[0], true);
		filled[stairsX][stairsY] = true;
		
		for (int i = 0; i <= stairsX; i++){
			int chance = (int)(Math.random() * 4);
			tiles [i][Globals.MIN_ROOM_SIZE - 1] = new TileFloor(t[chance], false);
			filled[i][Globals.MIN_ROOM_SIZE - 1] = true;
		}

		for (int i = 1; i < stairsY; i++){
			int chance = (int)(Math.random() * 4);
			tiles [stairsX][i] = new TileFloor(t[chance], false);
			filled[stairsX][i] = true;
		}
		
		for (int i = 1; i < rooms.length; i++){
			rooms[i] = new Room((int)(Math.random() * (Globals.FLOOR_SIZE - Globals.MAX_ROOM_SIZE)), (int)(Math.random() * (Globals.FLOOR_SIZE - Globals.MAX_ROOM_SIZE)));
		}
		
		for (int i = 0; i < rooms.length; i++){
			rooms[i].basicRoom();
			int x = rooms[i].getX();
			int y = rooms[i].getY();
			
			for (int e = 0; e < rooms[i].getSizeX(); e++){
				for (int r = 0; r < rooms[i].getSizeY(); r++){
					if (!rooms[i].isWall(e, r) && (x + e != stairsX || y + r != stairsY)){
						int chance = (int)(Math.random() * 4);
						tiles[x + e][y + r] = new TileFloor(t[chance], false);
						filled[x + e][y + r] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				if (!filled[i][e]){
					tiles [i][e]= new TileWall(t[0]);
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
	
	public void addEntity(Entity e, int x, int y) {
		e.setX(x);
		e.setY(y);
		entities.add(e);
	}
	
	public Entity[] getEntities(){
		return entities.toArray(new Entity[entities.size()]);
	}
	
	public EnumTheme[] getTheme() {
		return theme;
	}
	
}
