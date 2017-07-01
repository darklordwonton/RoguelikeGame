package main.attacks;

public class AOE {
	protected int centerX = 0;
	protected int centerY = 0;
	protected String shape = null;
	protected int sizeX = 0;
	protected int sizeY = 0;
	
	protected Attack attack = null;
	
	protected boolean throughWalls = false;
	
	public AOE (int cx, int cy, int sx, int sy, Attack a){
		centerX = cx;
		centerY = cy;
		sizeX = sx;
		sizeY = sy;
		attack = a;
	}
}
