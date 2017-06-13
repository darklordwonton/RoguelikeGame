package main.dungeon;

import java.util.ArrayList;
import java.util.List;
import main.entities.Entity;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.tiles.TileFloor;
import main.tiles.TileStairs;
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
		rooms = new Room[Globals.ROOMS_PER_FLOOR];
		
		tiles = new Tile[h][w];
		
		rooms[0] = new Room(0,0);
		
<<<<<<< HEAD
		tiles[stairsX][stairsY] = new TileStairs(t, stairsX, stairsY);
		
		for (int i = 0; i <= stairsX; i++){
			tiles [i][Globals.MIN_ROOM_SIZE - 1] = new TileFloor(t, i, Globals.MIN_ROOM_SIZE);
		}

		for (int i = 1; i < stairsY; i++){
			tiles[stairsX][i] = new TileFloor(t, stairsX, i);
=======
		tiles[Globals.stairsX][Globals.stairsY] = new TileStairs(t);
		
		for (int i = 0; i <= Globals.stairsX; i++){
			tiles [i][Globals.MIN_ROOM_SIZE - 1] = new TileFloor(t);
		}

		for (int i = 1; i < Globals.stairsY; i++){
			tiles[Globals.stairsX][i] = new TileFloor(t);
>>>>>>> origin/master
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
<<<<<<< HEAD
					if (!rooms[i].isWall(e, r) && (x + e != stairsX || y + r != stairsY)){
						tiles[x + e][y + r] = new TileFloor(t, x + e, y + r);
=======
					if (!rooms[i].isWall(e, r) && (x + e != Globals.stairsX || y + r != Globals.stairsY)){
						tiles[x + e][y + r] = new TileFloor(t);
>>>>>>> origin/master
					}
				}
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int e = 0; e < w; e++) {
				if (tiles[i][e] == null){
					tiles [i][e]= new TileWall(t, i, e);
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
	
	public EnumTheme getTheme() {
		return theme;
	}
	
	public void destroyTile (int x, int y) {
		tiles[x][y] = new TileFloor(theme, x, y);
	}
	
}
