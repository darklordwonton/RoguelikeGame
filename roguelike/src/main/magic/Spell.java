package main.magic;

import main.attacks.Attack;
import main.attacks.EnumAttackType;

public class Spell {
	protected int value = 0;
	
	protected Attack attack = null;
	
	protected String shape = null;
	protected int centerX = 0;
	protected int centerY = 0;
	protected int sizeX = 0;
	protected int sizeY = 0;
	
	public Spell(){
		Attack attack = new Attack(10,20,2,null);
		attack.addType(EnumAttackType.FIRE);
		
		value = 0;
	}
}
