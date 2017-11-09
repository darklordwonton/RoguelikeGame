package main.rendering.animation;

import java.util.Timer;
import java.util.TimerTask;

import main.effects.Effect;
import main.entities.Entity;
import main.rendering.MainRenderer;
import main.tiles.Tile;
import main.util.Globals;

public class Animation {
	
	public static void animateTiles() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				for (Tile[] tiles: Globals.currentFloor.getTileMap()) {
					for (Tile t : tiles)
						t.incrementAnimation();
				}
				MainRenderer.refresh();
			}
		}, 0, (long) 50);
	}
	
}
