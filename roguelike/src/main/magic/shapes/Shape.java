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
	
	public Shape(Entity e, int s) {
		dir = null;
		x = e.getX();
		y = e.getY();
		size = s;
	}
	
	public Shape(int x, int y, int s) {
		dir = null;
		this.x = x;
		this.y = y;
		size = s;
	}
	
	public void setX(int a){
		x = a;
	}
	
	public void setY(int a){
		y = a;
	}

	public List<Tile> getTilesAffected() {
		return new ArrayList<Tile>();
	}

	public void setDirection(EnumDirection d) {
		dir = d;	
	}
	
}
