package main.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public class Goblin extends Entity{
	Stats ideal = new Stats (Globals.MID_STAT, //hp
							Globals.MID_STAT, //mp
							Globals.LOW_STAT, //buf
							Globals.MID_STAT, //tuf
							Globals.MID_STAT, //wit
							Globals.MID_STAT, //snk
							Globals.floorNum); //level
	
	Goblin(String n, int px, int py){
		super(n, px, py);
		
		Stats stats = new Stats(15 + 5 * Globals.floorNum, Globals.floorNum);
		stats.average(ideal);
		
		
		
	}
	
	public void move(){
		
	}
	
	public void attack(){
		
	}
	
	
	
}
