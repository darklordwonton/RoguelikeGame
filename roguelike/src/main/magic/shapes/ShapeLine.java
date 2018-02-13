package main.magic.shapes;

import java.util.ArrayList;
import java.util.List;

import main.dungeon.Floor;
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
		int dx = 0;
		int dy = 0;
		Floor floor = Globals.currentFloor;
		do{
			ret.add(floor.getTile(x + dx, y + dy));
			dx += dir.getX();
			dy += dir.getY();
			i++;
		} while (x + dx >= 0 && x + dx < floor.getWidth() && y + dy > 0 && y + dy < floor.getHeight() &&
				((!(floor.getTile(x + dx,y + dy).isWall() && !throughWalls) || !(floor.getTile(x + dx,y + dy).getResidentEntity() != null && !throughEntities)) && i <= size));
		return ret;
	}

}
