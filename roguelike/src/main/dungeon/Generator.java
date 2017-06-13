package main.dungeon;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.util.Globals;

public class Generator {
	public static void newFloor (int spawnX, int spawnY, int stairsX, int stairsY, int creatureCount){
		
		int theme = (int)(Math.random() * 3);
		switch(theme){
		case 0: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.CAVE, 15, 15);
		break;
		
		case 1: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.GRAY_BRICK, 15, 15);
		break;
		
		case 2: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.BROWN_BRICK, 15, 15);
		break;
		}
		
		Globals.currentFloor.addEntity(Globals.player, spawnX, spawnY);
	}
}
