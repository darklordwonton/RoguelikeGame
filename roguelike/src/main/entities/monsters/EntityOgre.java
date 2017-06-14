package main.entities.monsters;

import main.entities.Stats;
import main.util.Globals;

public class EntityOgre extends EntityMonster {
	
	
	EntityOgre(String n, int px, int py){
		super(n, px, py);
		
		ideal = new Stats (Globals.HIGH_STAT, //hp
				Globals.LOW_STAT, //mp
				Globals.HIGH_STAT, //buf
				Globals.HIGH_STAT, //tuf
				Globals.LOW_STAT, //wit
				Globals.LOW_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(3 * Globals.HIGH_STAT + 3 * Globals.LOW_STAT);
		
	}
	
}
