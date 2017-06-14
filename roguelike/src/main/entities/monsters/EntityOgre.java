package main.entities.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public class EntityOgre extends EntityMonster {
	Stats ideal = new Stats (Globals.HIGH_STAT, //hp
							Globals.LOW_STAT, //mp
							Globals.HIGH_STAT, //buf
							Globals.HIGH_STAT, //tuf
							Globals.LOW_STAT, //wit
							Globals.LOW_STAT, //snk
							Globals.floorNumber); //level
	
	EntityOgre(String n, int px, int py){
		super(n, px, py);
		
		Stats stats = new Stats(20 + 7 * Globals.floorNumber, Globals.floorNumber);
		stats.averageInnate(ideal);
		
	}
	
	public void attack(){
		
	}
	
	
	
}