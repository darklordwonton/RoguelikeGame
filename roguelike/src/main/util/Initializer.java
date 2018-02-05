package main.util;

import main.dungeon.Generator;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;
import main.rendering.animation.Animation;
import main.tiles.EnumTheme;

public class Initializer {
	public static void start(){
		Globals.player = new EntityPlayer("You", Globals.spawnX, Globals.spawnY);
		Generator.newFloor();
		ImageManager.init();
		MainRenderer.init();
		RollingCounterManager.init();
		Animation.animateTiles();
		MainRenderer.updateFloor(Globals.currentFloor);
		MainRenderer.refresh();
	}
}
