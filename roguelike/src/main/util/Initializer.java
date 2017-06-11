package main.util;

import main.dungeon.Map;
import main.entities.Entity;
import main.entities.EntityPlayer;

public class Initializer {
	public static void start(){
		Globals.maps.add(new Map(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE));
		
		Globals.player = new EntityPlayer("Player", 10, 5, 5);
		Globals.maps.get(0).addEntity(Globals.player);
	}
}
