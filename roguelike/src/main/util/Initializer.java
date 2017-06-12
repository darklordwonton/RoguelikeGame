package main.util;

import main.dungeon.Floor;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;
import main.tiles.EnumTheme;

public class Initializer {
	public static void start(){
		Globals.floors.add(new Floor(Globals.FLOOR_SIZE, Globals.FLOOR_SIZE, EnumTheme.GRAY_BRICK));
		Globals.player = new EntityPlayer("You", 4, 4);
		Globals.scrollX = 0;
		Globals.scrollY = -1;
		Globals.floors.get(0).addEntity(Globals.player);
		MainRenderer.init();
		ImageManager.init();
	}
}
