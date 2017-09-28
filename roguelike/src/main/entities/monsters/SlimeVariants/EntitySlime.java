package main.entities.monsters.SlimeVariants;

import main.entities.Names;
import main.entities.Stats;
import main.entities.monsters.EntityMonster;
import main.util.Globals;

public class EntitySlime extends EntityMonster {
	
	
	public EntitySlime(int px, int py) {
		super(px, py);
		this.xpValue = 5;
		ideal = new Stats (Globals.LOW_STAT, //hp
				Globals.HIGH_STAT, //mp
				Globals.MID_STAT, //buf
				Globals.VERY_HIGH_STAT, //tuf
				Globals.HIGH_STAT, //wit
				Globals.VERY_HIGH_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(3 * Globals.HIGH_STAT + 3 * Globals.LOW_STAT);
		
		
		name = Names.slimeName();
		pronoun = "their";
	}
	
}
