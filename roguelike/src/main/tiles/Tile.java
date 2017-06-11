package main.tiles;

public abstract class Tile {
	protected char symbol = '\0';
	protected boolean wall = false;
	
	public Tile() {}
	
	public char getSymbol(){
		return symbol;
	}

	public boolean isWall() {
		return wall;
	}
}
