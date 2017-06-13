package main.tiles;

import main.attacks.Attack;
import main.attacks.ModifierChart;
import main.util.Globals;

public class TileBreakable extends TileWall {
	
	ModifierChart modifier = null;
	int hp = 0;
	
	public TileBreakable(EnumTheme t, int h, int x, int y) {
		super(t, x, y);
		modifier = new ModifierChart(Globals.DEFAULT_WALL_MODIFIERS);
		hp = h;
	}
	
	@Override
	public void onAttack(Attack a) {
		hp -= modifier.getModifiedDamage(a);
		if (hp <= 0)
			Globals.currentFloor.destroyTile(x, y);
	}

}
