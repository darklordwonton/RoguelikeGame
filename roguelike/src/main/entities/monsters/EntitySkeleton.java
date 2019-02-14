package main.entities.monsters;

import java.util.HashMap;
import java.util.Map;

import main.effects.attacks.EnumAttackType;
import main.effects.attacks.ModifierChart;
import main.entities.Stats;
import main.items.InventoryArmour;
import main.util.Globals;
import main.util.Names;

public class EntitySkeleton extends EntityMonster{
	public EntitySkeleton(int px, int py) {
		super(px, py);
		
		this.species = "Undead";
		this.xpValue = 10;
		name = Names.undeadName();
		pronoun = "it's";
		setSprite("enemy_skeleton.png", 0, 0, 1);
		armour = new InventoryArmour(10, 1, 1, 2, 2, 2);
		HashMap<EnumAttackType, Float> m = new HashMap<EnumAttackType, Float>();
		m.put(EnumAttackType.SHARP, (float) 0.5);
		m.put(EnumAttackType.FIRE, (float) 1.5);
		m.put(EnumAttackType.HEAL, (float) -1);
		m.put(EnumAttackType.MENTAL, (float) 0);
		m.put(EnumAttackType.DEATH, (float) 0);
		modifiers = new ModifierChart(m); 
		
		ideal = new Stats (Globals.HIGH_STAT, //hp
				Globals.PATHETIC_STAT, //mp
				Globals.MID_STAT, //buf
				Globals.MID_STAT, //tuf
				Globals.LOW_STAT, //wit
				Globals.VERY_LOW_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(4 * Globals.MID_STAT + 2 * Globals.LOW_STAT);
	}

}
