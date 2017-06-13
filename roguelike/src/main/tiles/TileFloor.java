package main.tiles;

import main.util.Globals;

public class TileFloor extends Tile {
	protected boolean stairs = false;
	
	public TileFloor(EnumTheme t, boolean s) {
		sprite = Globals.FLOOR_SPRITES.get(t);
		wall = false;
		stairs = s;
	}
	
	public boolean getStairs(){
		return stairs;
	}
}
