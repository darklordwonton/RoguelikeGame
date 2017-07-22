package main.tiles;

import main.util.Globals;

public class TileFloor extends Tile {
	
	public TileFloor(EnumTheme t, int x, int y) {
		super(x,y);

		this.setSheetPos(0, (int)(Math.random() * (Globals.TILE_SPRITE_SHEET_LENGTHS.get(t)-1)) + 1);
		
		sprite = Globals.FLOOR_SPRITE_SHEETS.get(t);
		wall = false;
		
	}
	
}
