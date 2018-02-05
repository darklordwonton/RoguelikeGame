package main.actions;

import java.util.HashSet;

import main.dungeon.Generator;
import main.effects.attacks.Attack;
import main.effects.attacks.EnumAttackType;
import main.entities.Entity;
import main.entities.EntityPlayer;
import main.entities.monsters.EntityMonster;
import main.magic.DamageSpell;
import main.magic.Spell;
import main.magic.shapes.ShapeCenteredCircle;
import main.rendering.MainRenderer;
import main.util.EnumDirection;
import main.util.Globals;

public class ActionHandler {
	
	public static void command(int action, EntityPlayer e){
		if (e.hasTurns()) {
			switch(action){
				case Globals.UP_KEY: e.move(EnumDirection.UP);
		  			break;
				  
				case Globals.RIGHT_KEY: e.move(EnumDirection.RIGHT);
		  			break;
		  
				case Globals.DOWN_KEY: e.move(EnumDirection.DOWN);
		  			break;
		  
				case Globals.LEFT_KEY: e.move(EnumDirection.LEFT);
		  			break;
		  
				case Globals.BACKSLASH: if (Globals.SKIP_FLOORS)
					Generator.newFloor();
		  			break;
		  			
				case Globals.S: if (Globals.SKIP_LEVEL)
					Globals.player.gainXp(Globals.LEVEL_XP_BASE + Globals.player.getStats().getLevel() * Globals.LEVEL_XP_MODIFIER);
					break;
					
		  		//TEMPORARY
				case Globals.M: 
					Spell s = DamageSpell.createSpell(0, Globals.player);
					s.cast(EnumDirection.LEFT);
					break;
		  			
				case Globals.ESC_KEY: 
					MainRenderer.closeWindow();
					System.exit(0);
					break;
			}
			e.incrementTurns();
			if (!e.hasTurns()) {
				doMonsterTurns();
				e.resetTurns();
			}
		}
	}
	
	//Put monster turn stuff here, if I find it anywhere else I will find you and befriend you
	public static void doMonsterTurns() {
		for (Entity e : Globals.currentFloor.getEntities()) {
			if (e instanceof EntityMonster && !e.getDead()) {
				e.resetTurns();
				while(e.hasTurns()) {
					e.turn();
					e.incrementTurns();
				}
			}
		}
	}
	
}
