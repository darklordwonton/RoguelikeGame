package main.items.armour;

public class ItemChainmail extends ItemArmour {

	protected float armourRating = 0.0f;
	
	public ItemChainmail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int reduceDamage(int damage) {
		int ret = (int) (damage / armourRating);
		durability -= damage - ret;
		return ret;
	}
	
}
