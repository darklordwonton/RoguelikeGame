package main.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public class Goblin extends Entity{
	Stats ideal = new Stats (Globals.MID_STAT, 
							Globals.MID_STAT, 
							Globals.LOW_STAT, 
							Globals.MID_STAT, 
							Globals.MID_STAT, 
							Globals.MID_STAT, 
							0); //globals.currentFloor
	
	Goblin(String n, int px, int py){
		super(n, px, py);
		
	}

}
