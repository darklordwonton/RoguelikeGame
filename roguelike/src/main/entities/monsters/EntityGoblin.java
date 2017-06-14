package main.entities.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public class EntityGoblin extends EntityMonster {
	Stats ideal = new Stats (Globals.MID_STAT, //hp
							Globals.MID_STAT, //mp
							Globals.LOW_STAT, //buf
							Globals.MID_STAT, //tuf
							Globals.MID_STAT, //wit
							Globals.MID_STAT, //snk
							Globals.floorNumber); //level
	
	EntityGoblin(String n, int px, int py){
		super(n, px, py);
		
		Stats stats = new Stats(15 + 5 * Globals.floorNumber, Globals.floorNumber);
		stats.averageInnate(ideal);
		
	}
	
	public void attack(){
		
	}
	
	
	
}