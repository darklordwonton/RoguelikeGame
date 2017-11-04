package main.items;

public class Inventory {

	protected Item[] items = null;
	protected int slots = -1;
	protected int maxWeight = -1;
	
	public Inventory(int s, int w) {
		items = new Item[s];
		slots = s;
		maxWeight = w;
	}
	
	//Adds item to first available slot if possible
	public boolean addItem(Item item) {
		int i = 0;
		while (i < slots && items[i] != null) {
			i++;
		}
		if (i == slots) {
			return false;
		} else {
			items[i] = item;
			return true;
		}
	}
	
	//Adds an item to a specific slot and returns the item replaced
	public Item addItemToSlot(Item item, int slot) {
		Item ret = items[slot];
		items[slot] = item;
		return ret;
	}
	
	//Removes an item for the inventory and returns it
	public Item removeItem(int slot) {
		Item ret = items[slot];
		items[slot] = null;
		return ret;
	}
	
	public Item getItem(int slot) {
		return items[slot];
	}
	
	//Returns combined weight of all items
	public int getWeight() {
		int weight = 0;
		for (Item item : items) {
			if (item != null)
				weight += item.getWeight();
		}
		return weight;
	}
	
	//Values over 0 are overweight
	//Values under 0 are underweight
	//Values equal to 0 are at capacity
	public int evaluateWeight() {
		return getWeight() - maxWeight;
	}

}
