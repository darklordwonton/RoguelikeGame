package main.entities.monsters;

import main.entities.Stats;
import main.rendering.animation.Animation;
import main.util.Globals;
import main.util.Names;

public class EntityGoblin extends EntityMonster {
	
	public EntityGoblin(int px, int py) {
		super(px, py);
		
		species = "Goblin";
		
		ideal = new Stats (Globals.MID_STAT, //hp
				Globals.MID_STAT, //mp
				Globals.LOW_STAT, //buf
				Globals.LOW_STAT, //tuf
				Globals.MID_STAT, //wit
				Globals.MID_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(4 * Globals.MID_STAT + 2 * Globals.LOW_STAT);
		
		name = Names.gobName();
		int rand = (int)(Math.random() * 10);
		if (rand <= 3){
			pronoun = "his";
		}else if(rand <= 7){
			pronoun = "her";
		}else{
			pronoun = "their";
		}
		
		setSprite("enemy_goblin2.png", 0, 0, 1);
		Animation.animate(this);
	}
	
}
