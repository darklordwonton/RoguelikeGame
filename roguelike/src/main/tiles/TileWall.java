package main.tiles;

import main.util.Globals;

public class TileWall extends TileInteractive{
	
	public TileWall(EnumTheme t, int x, int y) {
		super(x, y);
		sprite = Globals.EMPTY_SPRITES.get(t);
	}
}
