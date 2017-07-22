package main.actions;

import main.dungeon.Generator;
import main.entities.Entity;
import main.rendering.MainRenderer;
import main.util.EnumDirection;
import main.util.Globals;

public class Action {
	
	public static void command(int action, Entity e){
		switch(action){
		case Globals.UP_KEY: e.move(EnumDirection.UP);
		  break;
				  
		case Globals.RIGHT_KEY: e.move(EnumDirection.RIGHT);
		  break;
		  
		case Globals.DOWN_KEY: e.move(EnumDirection.DOWN);
		  break;
		  
		case Globals.LEFT_KEY: e.move(EnumDirection.LEFT);
		  break;
		  
		case Globals.BACKSLASH: if (Globals.SKIP_FLOORS)
			Generator.newFloor();
		  break;
		
		case Globals.ESC_KEY: 
			MainRenderer.closeWindow();
			System.exit(0);
		  break;
		}
	}
	
}
