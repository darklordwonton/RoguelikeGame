package main.tiles;

import main.dungeon.Generator;
import main.entities.Entity;
import main.entities.EntityPlayer;
import main.util.Globals;

public class TileStairs extends Tile {
	
	public TileStairs(EnumTheme t, int x, int y) {
		super(x, y);
		sprite = Globals.STAIRS_SPRITES.get(t);
		wall = false;
	}
	
	public void onStep(Entity e) {
		if (e instanceof EntityPlayer) {
			Generator.newFloor();
		}
	}
	
}
