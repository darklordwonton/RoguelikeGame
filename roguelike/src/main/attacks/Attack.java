package main.attacks;

import java.util.Set;

public class Attack {

	private int damage = 0;
	private Set<EnumAttackType> types = null;
	
	public Attack(int d, Set<EnumAttackType> t) {
		damage = d;
		types = t;
	}
	
	public boolean isType (EnumAttackType t) {
		return types.contains(t);
	}
	
	public void addType (EnumAttackType t) {
		types.add(t);
	}
	
	public void removeType (EnumAttackType t) {
		types.remove(t);
	}
	
	public int getDamage () {
		return damage;
	}
	
}