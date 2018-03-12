package main.entities;

import java.util.HashSet;

import main.effects.attacks.EnumAttackType;
import main.items.InventoryArmour;
import main.items.ItemTool;
import main.job.Job;
import main.job.JobFighter;
import main.magic.Spell;
import main.rendering.MainRenderer;
import main.util.EnumDirection;
import main.util.Globals;

public class EntityPlayer extends Entity {
	protected int xp = 0;
	protected Job currentJob = null;
	
	public EntityPlayer(String n, int px, int py){
		super(px,py);
		name = "you";
		pronoun = "your";
		currentJob = new JobFighter();
		
		species = "Player";
		
		this.setSprite(Globals.PLAYER_SPRITE_SHEET, Globals.PLAYER_SPRITE_COLUMN, Globals.PLAYER_SPRITE_ROW, Globals.PLAYER_SPRITE_FRAME_COUNT);
		tangible = !Globals.NO_CLIP;
		stats = new Stats(100,Globals.floorNumber);
		stats.Statsp(100, Globals.floorNumber);
		stats.Statsp(100, Globals.floorNumber);
		stats.Statsp(100, Globals.floorNumber);
		hp = stats.getHp();
		mp = stats.getMp();
		xp = 0;
		
		armour = new InventoryArmour(10, 1, 1, 2, 2, 2);
		armour.addItem(new ItemTool(5, 15, 2, new HashSet<EnumAttackType>(), 1));
		
		//spell = new Spell();
		//spell.generateSpell(0);
	}
	
	public void move(EnumDirection dir) {
		super.move(dir);
		Globals.scrollX = x - 4;
		Globals.scrollY = y - 5;
	}
	
	public void gainXp(int x){
		xp += x;
		
		if (xp >= Globals.LEVEL_XP_BASE + this.stats.getLevel() * Globals.LEVEL_XP_MODIFIER){
			this.stats.setLevel(this.stats.getLevel() + 1);
			this.stats.changeInnateStats(currentJob.getStatsArray());
			System.out.println("-----------------");
			System.out.println(currentJob.getName());
			System.out.println(stats);
			if (this.stats.getLevel() % 5 == 0){
				currentJob = currentJob.maxJob();
			}
			xp = 0;
		}
	}
}
