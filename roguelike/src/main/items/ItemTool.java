package main.items;

import java.util.HashSet;
import java.util.Set;

import main.effects.attacks.Attack;
import main.effects.attacks.EnumAttackType;

public class ItemTool extends Item{ //Renamed to tool. Contains everything that goes into the hands
	private static Attack attack = null;
	private static int hands = 0;
	
	public ItemTool(){
		super();
	}
	
	public ItemTool(int dl, int dh, int bc, EnumAttackType t, int h){
		attack = new Attack (dl, dh, bc, t, null);
		hands = h;
	}
	
	public ItemTool(int dl, int dh, int bc, Set<EnumAttackType> t, int h){
		attack = new Attack (dl, dh, bc, t, null);
		hands = h;
	}
	
	public Attack getAttack(){
		return attack;
	}
	
	public int getHands(){
		return hands;
	}
}
