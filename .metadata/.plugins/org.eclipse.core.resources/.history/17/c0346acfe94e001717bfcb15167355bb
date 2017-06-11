package main.dungeon;

import main.entities.Entity;
import main.util.Globals;

public class Generator {
	public static void newFloor(){
		for(int i = 0; i < Globals.FLOOR_SIZE; i++){
			for(int e = 0; e < Globals.FLOOR_SIZE; e++){
				Globals.map[i][e].setType((int)(Math.random() * 2 + 1));
			}
		}
	}
	
	public static void blankFloor(){
		for(int i = 0; i < Globals.FLOOR_SIZE; i++){
			for(int e = 0; e < Globals.FLOOR_SIZE; e++){
				Globals.map[i][e].setType(1);
			}
		}
	}
	
	public static void newEntity(){
		Globals.currentCreatures++;
		Globals.entities[Globals.currentCreatures - 1] = new Entity ("Monster", 1, 0, 0, 'M');
	}
}
