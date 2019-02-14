package main.entities.monsters;

import main.entities.Stats;
import main.items.InventoryArmour;
import main.rendering.animation.Animation;
import main.util.Globals;
import main.util.Names;

public class EntityOgre extends EntityMonster {
	public EntityOgre(int px, int py){
		super(px, py);
		
		this.species = "Ogre";
		this.xpValue = 100;
		name = Names.ogreName();
		pronoun = Names.pronoun();
		setSprite("enemy_ogre.png", 0, 0, 1);
		armour = new InventoryArmour(10, 1, 1, 2, 2, 2);
		
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
