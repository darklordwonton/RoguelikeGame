package main.util;

import main.dungeon.Map;
import main.entities.Entity;

public class Initializer {
	public static void start(){
		for(int i = 0; i < Globals.FLOOR_SIZE; i++){
			for(int e = 0; e < Globals.FLOOR_SIZE; e++){
				Globals.map[i][e] = new Map(1);
			}
		}
		
		//0 is always reserved for the player. Other creatures go in later slots
		Globals.entities[0] = new Entity("Player", 10, 5, 5, '@');
		Globals.currentCreatures++;
	}
}
