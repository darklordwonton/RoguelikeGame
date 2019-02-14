package main.entities.monsters;

import main.entities.Stats;
import main.items.InventoryArmour;
import main.rendering.animation.Animation;
import main.util.Globals;
import main.util.Names;

public class EntityGoblin extends EntityMonster {
	public EntityGoblin(int px, int py) {
		super(px, py);
		
		this.species = "Gobloid";
		this.xpValue = 5;
		name = Names.gobName();
		pronoun = Names.pronoun();
		setSprite("enemy_goblin2.png", 0, 0, 1);
		armour = new InventoryArmour(10, 1, 1, 2, 2, 2);
		
		ideal = new Stats (Globals.LOW_STAT, //hp
				Globals.PATHETIC_STAT, //mp
				Globals.LOW_STAT, //buf
				Globals.VERY_LOW_STAT, //tuf
				Globals.MID_STAT, //wit
				Globals.MID_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(4 * Globals.MID_STAT + 2 * Globals.LOW_STAT);
	}
	
}
