package main.entities.monsters;

import main.entities.Animation;
import main.entities.Stats;
import main.util.Globals;

public class EntitySlime extends EntityMonster {
	
	
	public EntitySlime(String n, int px, int py) {
		super(n, px, py);
		this.xpValue = 5;
		ideal = new Stats (Globals.LOW_STAT, //hp
				Globals.HIGH_STAT, //mp
				Globals.MID_STAT, //buf
				Globals.VERY_HIGH_STAT, //tuf
				Globals.HIGH_STAT, //wit
				Globals.VERY_HIGH_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(3 * Globals.HIGH_STAT + 3 * Globals.LOW_STAT);
		
		setSprite("enemy_slimes.png", 0, 0, 3);
		
		Animation.Animate(this);
	}
	
}
