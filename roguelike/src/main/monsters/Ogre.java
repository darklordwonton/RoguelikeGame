package main.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public class Ogre extends Entity{
	Stats ideal = new Stats (Globals.HIGH_STAT, //hp
							Globals.LOW_STAT, //mp
							Globals.HIGH_STAT, //buf
							Globals.HIGH_STAT, //tuf
							Globals.LOW_STAT, //wit
							Globals.LOW_STAT, //snk
							Globals.floorNum); //level
	
	Ogre(String n, int px, int py){
		super(n, px, py);
		
		Stats stats = new Stats(20 + 7 * Globals.floorNum, Globals.floorNum);
		stats.average(ideal);
		
		
		
	}
	
	public void move(){
		
	}
	
	public void attack(){
		
	}
	
	
	
}
