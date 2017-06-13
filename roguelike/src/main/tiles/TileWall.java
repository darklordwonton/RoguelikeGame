package main.tiles;

import main.util.Globals;

public class TileWall extends Tile{
	
	public TileWall(EnumTheme t, int x, int y) {
		super(x, y);
		sprite = Globals.WALL_SPRITES.get(t);
		wall = true;
	}
	
}
