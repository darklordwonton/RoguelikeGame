package main.tiles;

import main.util.Globals;

public class TileFloor extends Tile {
	protected boolean stairs = false;
	
	public TileFloor(EnumTheme t, boolean s) {
		stairs = s;
		if (stairs){
			sprite = Globals.STAIRS_SPRITES.get(t);
		}else{
			sprite = Globals.FLOOR_SPRITES.get(t);
		}
		wall = false;
	}
	
	public boolean getStairs(){
		return stairs;
	}
}
