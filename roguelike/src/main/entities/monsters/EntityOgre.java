package main.entities.monsters;

import main.entities.Names;
import main.entities.Stats;
import main.rendering.animation.Animation;
import main.util.Globals;

public class EntityOgre extends EntityMonster {
	
	
	public EntityOgre(int px, int py){
		super(px, py);
		
		species = "Ogre";
		
		ideal = new Stats (Globals.HIGH_STAT, //hp
				Globals.LOW_STAT, //mp
				Globals.HIGH_STAT, //buf
				Globals.HIGH_STAT, //tuf
				Globals.LOW_STAT, //wit
				Globals.LOW_STAT, //snk
				Globals.floorNumber); //level
		
		makeStats(3 * Globals.HIGH_STAT + 3 * Globals.LOW_STAT);
		name = Names.ogreName();
		int rand = (int)(Math.random() * 10);
		if (rand <= 3){
			pronoun = "his";
		}else if(rand <= 7){
			pronoun = "her";
		}else{
			pronoun = "their";
		}
		this.xpValue = 20;
		this.species = "Ogre";
		setSprite("enemy_ogre.png", 0, 0, 1);
		Animation.animate(this);
	}
	
}
