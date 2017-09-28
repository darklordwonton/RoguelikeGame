package main.tiles;

import main.attacks.Attack;
import main.rendering.MainRenderer;
import main.util.Globals;

public class TileWall extends Tile{
	
	public TileWall(EnumTheme t, int x, int y) {
		super(x, y);
		wall = true;
		sprite = Globals.EMPTY_SPRITES.get(t);
	}
	
	@Override
	public void onAttack(Attack a) {
		MainRenderer.addMessage(a.getOrigin().getName() + " smashed " + a.getOrigin().getPronoun() + " face into the wall!");
	}
}
