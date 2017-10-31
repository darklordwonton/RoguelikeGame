package main.items;

public class Item {
	protected String name = "";
	protected String descriptor = "";
	
	protected int value = -1;
	protected int weight = -1;
	
	protected String sprite = null;
	protected int spriteSheetRow = 0;
	protected int spriteSheetColumn = 0;
	
	public Item (){
		name = "";
		descriptor = "";
		value = 0;
	}
	
	public Item(String n, String d, int v){
		name = n;
		descriptor = d;
		value = v;
	}
	
	public int getWeight() {
		return weight;
	}
}
