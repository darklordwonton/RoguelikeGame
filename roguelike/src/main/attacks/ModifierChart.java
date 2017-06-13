package main.attacks;

import java.util.HashMap;
import java.util.Map;

public class ModifierChart {
	//Exists purely to make weaknesses & resistances super easy to program
	Map<EnumAttackType, Float> modifiers = new HashMap<EnumAttackType, Float>();
	
	public ModifierChart(Map<EnumAttackType, Float> m) {
		modifiers = m;
	}
	
	public int getModifiedDamage (Attack a) {
		int damage = a.getDamage();
		for (EnumAttackType t : modifiers.keySet()) {
			if (a.isType(t)) {
				damage *= modifiers.get(t);
			}
		}
		return damage;
	}
}
