package main.items.armour;

public class ItemCarapice extends ItemArmour {

	protected int defense = -1;
	
	@Override
	public int reduceDamage(int damage) {
		if (damage > defense) {
			durability -= defense;
			return damage - defense;
		} else {
			durability -= damage;
			return 0;
		}
	}
	
}
