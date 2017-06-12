package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class EntityPlayer extends Entity {
	public EntityPlayer(String n, int h, int px, int py){
		super(n,h,px,py);
		sprite = Globals.PLAYER_SPRITE;
	}
	
	public void move(EnumDirection dir) {
		super.move(dir);
		Globals.scrollX = x - 4;
		Globals.scrollY = y - 5;
	}
}
