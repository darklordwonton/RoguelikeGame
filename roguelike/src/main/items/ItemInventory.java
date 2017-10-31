//This is the general superclass for items with inventories (bags etc.)
//This class is not meant to be instantiated on its own
package main.items;

public class ItemInventory extends Item {

	protected Inventory inventory = null;
	
	public ItemInventory(Inventory i) {
		super();
		inventory = i;
	}
	
	public ItemInventory(String n, String d, int v, Inventory i) {
		super(n, d, v);
		inventory = i;
	}
	
	@Override
	public int getWeight() {
		return weight + inventory.getWeight();
	}
	
	public Inventory getInventory() {
		return inventory;
	}

}
