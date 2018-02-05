package main.magic.shapes;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.Tile;
import main.util.Globals;

public class ShapeLine extends Shape{
	boolean throughEntities = false; //We should consider adding these two to all spells. Thoughts? It would require a 
	boolean throughWalls = false;	 //redesign of the current circle shape
	
	public ShapeLine(Entity e, int s, boolean te, boolean tw) {
		super(e, s);
		throughEntities = te;
		throughWalls = tw;
	}
	
	public ShapeLine(int x, int y, int s, boolean te, boolean tw) {
		super(x, y, s);
		throughEntities = te;
		throughWalls = tw;
	}
	
	@Override
	public List<Tile> getTilesAffected() { //Size is inclusive. Ex: if size = 1, then it goes 1 square away.
		List<Tile> ret = new ArrayList<Tile>();
		int i = 0;
		do{
			ret.add(Globals.currentFloor.getTile(x, y));
			x += dir.getX();
			y += dir.getY();
			i++;
		} while ((!(Globals.currentFloor.getTile(x,y).isWall() && !throughWalls) || !(Globals.currentFloor.getTile(x,y).getResidentEntity() != null && !throughEntities)) && i <= size);
		return ret;
	}

}
