package main.dungeon;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.util.Globals;

public class Generator {
	public static void newFloor (int spawnX, int spawnY, int creatureCount){
		Globals.floorNum++;
		Globals.stairsX = 15;
		Globals.stairsY = 15;
		
		
		int theme = (int)(Math.random() * 5);
		switch(theme){
		case 0: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.CAVE);
		break;
		
		case 1: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.GRAY_BRICK);
		break;
		
		case 2: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.BROWN_BRICK);
		break;
		
		case 3: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.DIRT);
		break;
		
		case 4: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.VOLCANO);
		break;
		}
		
		Globals.currentFloor.addEntity(Globals.player, spawnX, spawnY);
	}
}
