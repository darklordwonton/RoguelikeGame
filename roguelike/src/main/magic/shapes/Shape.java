package main.magic.shapes;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.Tile;
import main.util.EnumDirection;

public class Shape {

	protected EnumDirection dir = null;
	protected int x = -1;
	protected int y = -1;
	protected int size = -1;
	
	public Shape(EnumDirection d, Entity e, int s) {
		dir = d;
		x = e.getX();
		y = e.getY();
		size = s;
	}
	
	public Shape(EnumDirection d, int x, int y, int s) {
		dir = d;
		this.x = x;
		this.y = y;
		size = s;
	}

	public List<Tile> getTilesAffected() {
		return new ArrayList<Tile>();
	}
	
}
