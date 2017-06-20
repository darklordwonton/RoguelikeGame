package main.dungeon;

import main.entities.Entity;
import main.tiles.EnumTheme;
import main.util.Globals;

public class Generator {
	public static void newFloor (){
		Globals.floorNumber++;
		
		Globals.currentTheme = Globals.RELATED_THEMES.get(Globals.currentTheme)
								[(int) (Math.random() * 
							   Globals.RELATED_THEMES.get(Globals.currentTheme).length-1)];
		
		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE_BASE + (int)Math.pow(Globals.floorNumber, 1/2.0) * Globals.FLOOR_SIZE_MODIFIER, 
				Globals.FLOOR_SIZE_BASE + (int)Math.pow(Globals.floorNumber, 1/2.0) * Globals.FLOOR_SIZE_MODIFIER, 
				Globals.currentTheme);
		
		Globals.scrollX = Globals.spawnX - 4;
		Globals.scrollY = Globals.spawnY - 5;
		Globals.currentFloor.addEntity(Globals.player, Globals.spawnX, Globals.spawnY);
	}
}
