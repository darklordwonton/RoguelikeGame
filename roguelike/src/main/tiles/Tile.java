package main.tiles;

public abstract class Tile {
	protected String sprite = null;
	protected boolean wall = false;
	
	protected Tile() {}
	
	public String getSprite(){
		return sprite;
	}

	public boolean isWall() {
		return wall;
	}
}
