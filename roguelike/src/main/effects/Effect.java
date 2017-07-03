package main.effects;

import main.util.Globals;

public class Effect {
	protected int x = 0;
	protected int y = 0;
	protected String sprite = null;
	protected int duration = 0;
	
	public Effect (){
		x = 5;
		y = 5;
		sprite = Globals.FIREBALL;
		duration = 1;
	}
}
