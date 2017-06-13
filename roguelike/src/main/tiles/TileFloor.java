package main.tiles;

import java.util.Random;

import main.util.Globals;

public class TileFloor extends Tile {
	
	public TileFloor(EnumTheme t) {
		Random rand = new Random();
		sprite = Globals.FLOOR_SPRITES.get(t)[rand.nextInt(Globals.FLOOR_SPRITES.get(t).length)];
		wall = false;
	}
	
}
