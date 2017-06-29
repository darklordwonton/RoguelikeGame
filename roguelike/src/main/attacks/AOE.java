package main.attacks;

import java.util.Set;

import main.util.Globals;

public class AOE extends Attack{
	private int centerX = 0;
	private int centerY = 0;
	private String shape = null;
	private int sizeX = 0;
	private int sizeY = 0;
	private boolean throughWalls = false;
	
	public AOE (int d1, int d2, int bc, Set<EnumAttackType> t, int cx, int cy, int sx, int sy){
		super(d1, d2, bc, t);
		this.setSprite(Globals.FIREBALL, Globals.PLAYER_SPRITE_COLUMN, Globals.PLAYER_SPRITE_ROW);
		
		centerX = cx;
		centerY = cy;
		sizeX = sx;
		sizeY = sy;
	}
}