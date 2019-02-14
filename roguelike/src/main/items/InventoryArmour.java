package main.items;

import main.items.armour.*;

public class InventoryArmour extends Inventory {

	protected int bodies = -1; //Armour
	protected int heads = -1;  //Helmets
	protected int arms = -1;   //Boots
	protected int feet = -1;   //Feet
	protected int hands = -1;  //Weapons and tools

	protected int bodyStart = -1;
	protected int headStart = -1;
	protected int armsStart = -1;
	protected int feetStart = -1;
	protected int handStart = -1; 
	
						//weight, body, head, arms, legs, hands
	public InventoryArmour(int w, int b, int h, int a, int f, int i) {
		super(b + h + a + f + i + 1, w);
		
		bodies = b;
		heads = h;
		arms = a;
		feet = f;
		hands = i;
		
		bodyStart = 1;
		headStart = bodyStart + b;
		armsStart = headStart + h;
		feetStart = armsStart + a;
		handStart = feetStart + f;
	}
	
	@Override
	public boolean addItem(Item item) {
		return false;
	}
	
	public boolean addItem(ItemChainmail item) {
		if (items[0] == null) {
			items[0] = item;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addItem(ItemBodyplate item) {
		int i = bodyStart;
		while (i < headStart && items[i] != null) {
			i++;
		}
		if (i == bodies + 1) {
			return false;
		} else {
			items[i] = item;
			return true;
		}
	}
	
	public boolean addItem(ItemHelmet item) {
		int i = headStart;
		while (i < armsStart && items[i] != null) {
			i++;
		}
		if (i == armsStart) {
			return false;
		} else {
			items[i] = item;
			return true;
		}
	}
	
	public boolean addItem(ItemGauntlets item) {
		int i = armsStart;
		while (i < feetStart && items[i] != null) {
			i++;
		}
		if (i == feetStart) {
			return false;
		} else {
			items[i] = item;
			return true;
		}
	}
	
	public boolean addItem(ItemBoots item) {
		int i = feetStart;
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
	
	public boolean addItem(ItemTool item){
		int i = handStart;
		while (i < slots && items[i] != null) {
			i++;
		}
		if (i >= slots - item.getHands()) {
			return false;
		} else {
			for (int j = 0; j < item.getHands(); j++){
				items[i] = item;
			}
			return true;
		}
	}
	
	public ItemTool getItemTool(){
<<<<<<< HEAD
		System.out.println(handStart);
		return (ItemTool) items[handStart];
=======
		if (slots > handStart)
			return (ItemTool) items[handStart];
		else 
			return null;
>>>>>>> 65de8285fa02af825f82cea7622e4976d275cb6b
	}
	
	
	@Override
	public Item addItemToSlot(Item item, int slot) {
		return item;
	}
	
	public Item addItemToSlot(ItemChainmail item, int slot) {
		if (slot == 0) {
			Item ret = items[0];
			items[0] = item;
			return ret;
		} else {
			return item;
		}
	}
	
	public Item addItemToSlot(ItemBodyplate item, int slot) {
		if (slot >= bodyStart && slot < headStart) {
			Item ret = items[slot];
			items[slot] = item;
			return ret;
		} else {
			return item;
		}
	}
	
	public Item addItemToSlot(ItemHelmet item, int slot) {
		if (slot >= headStart && slot < armsStart) {
			Item ret = items[slot];
			items[slot] = item;
			return ret;
		} else {
			return item;
		}
	}
	
	public Item addItemToSlot(ItemGauntlets item, int slot) {
		if (slot >= armsStart && slot < feetStart) {
			Item ret = items[slot];
			items[slot] = item;
			return ret;
		} else {
			return item;
		}
	}
	
	public Item addItemToSlot(ItemBoots item, int slot) {
		if (slot >= feetStart && slot < slots) {
			Item ret = items[slot];
			items[slot] = item;
			return ret;
		} else {
			return item;
		}
	}
	
	public int reduceDamage(int damage) {
		int ret = damage;
		for (int i = 1; i < slots; i++) {
			if (items[i] != null)
				ret = ((ItemArmour)items[i]).reduceDamage(ret); //ItemArmour reduce damage looks unfinished
		}
		if (items[0] != null)
			ret = ((ItemArmour)items[0]).reduceDamage(ret);
		return ret;
	}

}
