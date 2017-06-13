package main.dungeon;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.util.Globals;

public class Generator {
	public static void newFloor (int spawnX, int spawnY, int stairsX, int stairsY, int creatureCount){
		EnumTheme[] cave = {EnumTheme.CAVE};
		EnumTheme[] grayBricks = {EnumTheme.GRAY_BRICK_1, EnumTheme.GRAY_BRICK_2, EnumTheme.GRAY_BRICK_3, EnumTheme.GRAY_BRICK_4};
		EnumTheme[] volcano = {EnumTheme.VOLCANO};
		
		int theme = (int)(Math.random() * 3);
		switch(theme){
		case 0: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, cave, 15, 15);
		break;
		
		case 1: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, grayBricks, 15, 15);
		break;
		
		case 2: 		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, volcano, 15, 15);
		break;
		}
		
		Globals.currentFloor.addEntity(Globals.player, spawnX, spawnY);
	}
}
