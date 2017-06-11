package main.dungeon;

public class Map {
	private char symbol = ' ';
	private int type = 0;
	private boolean wall = false;
	
	public Map (){
		symbol = ' ';
		type = 0;
		setWall(false);
	}
	
	public Map (int t){
		setType (t);
	}
	
	public void setType(int t){
		type = t;
		switch (type){
			case 1: symbol = '.';
					setWall(false);
					break;

			case 2: symbol = '#';
					setWall(true);
					break;
		}
	}
	
	public char getSymbol(){
		return symbol;
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}
}
