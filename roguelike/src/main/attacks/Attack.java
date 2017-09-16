package main.attacks;

import java.util.Set;

public class Attack {
	protected int lowDamage = 0; //Low bound of damage
	protected int highDamage = 0; //Upper bound of damage
	protected int bellCurve = 0;  //Randomization of damage. 1 is equal chance of anything, the higher the more likely it is to center
	
	protected int buf = 0; //Bonus to damage. Comes from buf and weapon enhancements (when we program them)
	
	protected Set<EnumAttackType> types = null; //Types of damage
	
	public Attack(int dl, int du, int bc, Set<EnumAttackType> t) {
		lowDamage = dl;
		highDamage = du;
		bellCurve = bc;
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
	
	public void setBuf (int b){
		buf = b;
	}
	
	public int getDamage () {
		double d = lowDamage + 0.5;
		double m = (double)((highDamage - lowDamage) / bellCurve);
		for (int i = 0; i < bellCurve; i++){
			d += m * Math.random();
		}
		
		d += buf / 2;
		System.out.println(d);
		return (int) d;
	}
}
