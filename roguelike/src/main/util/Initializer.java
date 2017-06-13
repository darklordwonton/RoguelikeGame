package main.util;

import main.dungeon.Floor;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;
import main.tiles.EnumTheme;

public class Initializer {
	public static void start(){
		Globals.currentFloor = new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.CAVE);
		Globals.player = new EntityPlayer("You", 0, 0);
		Globals.scrollX = 0;
		Globals.scrollY = -1;
		Globals.currentFloor.addEntity(Globals.player);
		ImageManager.init();
		MainRenderer.init();
		MainRenderer.drawFloor(Globals.currentFloor);
	}
}
