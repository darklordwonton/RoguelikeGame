package main.util;

import main.dungeon.Floor;
import main.entities.EntityPlayer;
import main.tiles.EnumFloor;

public class Initializer {
	public static void start(){
		Globals.floors.add(new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumFloor.GRAY_BRICK));
		Globals.player = new EntityPlayer("Player", 10, 5, 5);
		Globals.floors.get(0).addEntity(Globals.player);
	}
}
