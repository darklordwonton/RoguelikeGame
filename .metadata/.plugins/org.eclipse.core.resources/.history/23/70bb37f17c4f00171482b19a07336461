package main.util;

import main.dungeon.Floor;
import main.entities.EntityPlayer;
import main.tiles.EnumTheme;

public class Initializer {
	public static void start(){
		Globals.floors.add(new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.BROWN_BRICK));
		Globals.player = new EntityPlayer("Player", 10, 4, 4);
		Globals.scrollX = 0;
		Globals.scrollY = -1;
		Globals.floors.get(0).addEntity(Globals.player);
	}
}
