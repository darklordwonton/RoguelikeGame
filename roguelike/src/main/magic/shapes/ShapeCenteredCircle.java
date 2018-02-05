package main.magic.shapes;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.tiles.Tile;
import main.util.EnumDirection;
import main.util.Globals;

public class ShapeCenteredCircle extends Shape {

	public ShapeCenteredCircle(Entity e, int s) {
		super(e, s);
	}
	
	public ShapeCenteredCircle(int x, int y, int s) {
		super(x, y, s);
	}
	
	@Override
	public List<Tile> getTilesAffected() {
		List<Tile> ret = new ArrayList<Tile>();
		for (int xDisplacement = -size; xDisplacement <= size; xDisplacement++) {
			for (int yDisplacement = -size; yDisplacement <= size; yDisplacement++) {
				if (xDisplacement * xDisplacement + yDisplacement * yDisplacement <= size * size) {
					if (Globals.currentFloor.inBounds(xDisplacement + x, yDisplacement + y)) {
							ret.add(Globals.currentFloor.getTile(x + xDisplacement, y + yDisplacement));
					}
				}
			}
		}
		return ret;
	}

}
