package main.tiles;

import main.effects.attacks.*;
import main.util.Globals;

public class TileBreakable extends Tile {
	
	ModifierChart modifier = null;
	int hp = 0;
	
	public TileBreakable(EnumTheme t, int h, int x, int y) {
		super(x, y);
		wall = true;
		sprite = Globals.BREAKABLE_SPRITES.get(t);
		modifier = new ModifierChart(Globals.DEFAULT_WALL_MODIFIERS);
		hp = h;
	}
	
	@Override
	public void onAttack(Attack a) {
		super.onAttack(a);
		hp -= modifier.getModifiedDamage(a);
		if (hp <= 0)
			Globals.currentFloor.destroyTile(x, y);
	}

}
