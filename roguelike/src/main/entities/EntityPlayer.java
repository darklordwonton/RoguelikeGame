package main.entities;

import main.job.Job;
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
		currentJob = new Job("Fighter");
		
		species = "Player";
		
		this.setSprite(Globals.PLAYER_SPRITE_SHEET, Globals.PLAYER_SPRITE_COLUMN, Globals.PLAYER_SPRITE_ROW, Globals.PLAYER_SPRITE_FRAME_COUNT);
		tangible = !Globals.NO_CLIP;
		stats = new Stats(100,Globals.floorNumber);
		hp = stats.getHp();
		mp = stats.getMp();
		xp = 0;
		
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
			System.out.println(currentJob.getName());
			if (this.stats.getLevel() % 5 == 0){
				//currentJob.max()
			}
			xp = 0;
		}
	}
}
