package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class EntityPlayer extends Entity {
	public EntityPlayer(String n, int px, int py){
		super(n,px,py);
		sprite = Globals.PLAYER_SPRITE;
		stats = new Stats(100, 1000);
		hp = stats.getHp();
		mp = stats.getMp();
	}
	
	public void move(EnumDirection dir) {
		super.move(dir);
		Globals.scrollX = x - 4;
		Globals.scrollY = y - 5;
	}
}
