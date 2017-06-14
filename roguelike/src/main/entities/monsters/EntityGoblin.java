package main.entities.monsters;

import main.entities.Stats;
import main.util.Globals;

public class EntityGoblin extends EntityMonster {
	
	EntityGoblin(String n, int px, int py){
		super(n, px, py);
		
		ideal = new Stats (Globals.MID_STAT, //hp
				Globals.MID_STAT, //mp
				Globals.LOW_STAT, //buf
				Globals.MID_STAT, //tuf
				Globals.MID_STAT, //wit
				Globals.MID_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(4 * Globals.MID_STAT + 2 * Globals.LOW_STAT);
		
	}
	
}
