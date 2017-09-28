package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class EntityPlayer extends Entity {
	protected int xp = 0;
	
	public EntityPlayer(String n, int px, int py){
		super(n,px,py);
		this.setSprite(Globals.PLAYER_SPRITE_SHEET, Globals.PLAYER_SPRITE_COLUMN, Globals.PLAYER_SPRITE_ROW, Globals.PLAYER_SPRITE_FRAME_COUNT);
		tangible = !Globals.NO_CLIP;
		stats = new Stats(100,Globals.floorNumber);
		hp = stats.getHp();
		mp = stats.getMp();
		xp = 0;
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
			xp = 0;
		}
	}
}
