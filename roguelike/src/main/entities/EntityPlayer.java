package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class EntityPlayer extends Entity {
	public EntityPlayer(String n, int px, int py){
		super(n,px,py);
		this.setSprite(Globals.PLAYER_SPRITE_SHEET, Globals.PLAYER_SPRITE_COLUMN, Globals.PLAYER_SPRITE_ROW); 
		stats = new Stats(100,Globals.floorNumber + 1);
		hp = stats.getHp();
		mp = stats.getMp();
	}
	
	public void move(EnumDirection dir) {
		if(wallCollision)
			super.move(dir);
		else
			super.noClip(dir);
		Globals.scrollX = x - 4;
		Globals.scrollY = y - 5;
	}
}
