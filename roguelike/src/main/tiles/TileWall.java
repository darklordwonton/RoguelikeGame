package main.tiles;

import main.util.Globals;

public class TileWall extends Tile{
	
	public TileWall(EnumTheme t, int x, int y) {
		super(x, y);
		wall = true;
		sprite = Globals.EMPTY_SPRITES.get(t);
	}
}
