package main.dungeon;

import main.entities.monsters.EntityGoblin;
import main.util.Globals;

public class Generator {
	public static void newFloor (){
		Globals.floorNumber++;
		
		if ((Globals.floorNumber - 1) % 5 == 0){
		Globals.currentTheme = Globals.RELATED_THEMES.get(Globals.currentTheme)
								[(int) (Math.random() * 
							   Globals.RELATED_THEMES.get(Globals.currentTheme).length)];
		}
		
		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE_BASE + (int)Math.pow(Globals.floorNumber, 1/2.0) * Globals.FLOOR_SIZE_MODIFIER, 
				Globals.FLOOR_SIZE_BASE + (int)Math.pow(Globals.floorNumber, 1/2.0) * Globals.FLOOR_SIZE_MODIFIER, 
				Globals.currentTheme);
		
		Globals.scrollX = Globals.spawnX - 4;
		Globals.scrollY = Globals.spawnY - 5;
		Globals.currentFloor.addEntity(Globals.player, Globals.spawnX, Globals.spawnY);
	}
}
