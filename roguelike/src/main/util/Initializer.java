package main.util;

import main.dungeon.Generator;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;

public class Initializer {
	public static void start(){
		Globals.player = new EntityPlayer("You", 0, 0);
		Globals.scrollX = -4;
		Globals.scrollY = -5;
		Generator.newFloor(0, 0, 0);
		ImageManager.init();
		MainRenderer.init();
		MainRenderer.drawFloor(Globals.currentFloor);
	}
}
