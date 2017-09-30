package main.magic.shapes;

import java.util.ArrayList;
import java.util.List;

import main.tiles.Tile;
import main.util.EnumDirection;

public class Shape {

	protected EnumDirection dir = null;
	protected int x = -1;
	protected int y = -1;
	
	public Shape(EnumDirection d, int x, int y) {
		
	}

	public List<Tile> tileAffected() {
		return new ArrayList<Tile>();
	}
	
}
