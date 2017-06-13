package main.dungeon;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.util.Globals;

public class Generator {
	public static void newFloor (int spawnX, int spawnY, int stairsX, int stairsY, int creatureCount){
		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.CAVE, 15, 15);
		Globals.currentFloor.addEntity(Globals.player, spawnX, spawnY);
	}
}
