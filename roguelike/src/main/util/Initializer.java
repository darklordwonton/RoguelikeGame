package main.util;

import main.dungeon.Generator;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;
import main.tiles.EnumTheme;

public class Initializer {
	public static void start(){
		Globals.player = new EntityPlayer("You", 0, 0);
		Generator.newFloor();
		ImageManager.init();
		MainRenderer.init();
		RollingCounterManager.init();
		MainRenderer.updateFloor(Globals.currentFloor);
		MainRenderer.refresh();
	}
}
