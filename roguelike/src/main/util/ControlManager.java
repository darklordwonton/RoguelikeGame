package main.util;

import java.util.HashSet;
import java.util.Set;

import main.actions.ActionHandler;
import main.rendering.MainRenderer;
import main.rendering.animation.Animation;

public class ControlManager {

	private static Set<Integer> keysDown = new HashSet<Integer>();
	
	public static void init() {
		
	}
	
	public static void keyDown(int key) {
		if (!Globals.player.getDead() || key == 27){
			ActionHandler.command(key, Globals.player);
			MainRenderer.updateFloor(Globals.currentFloor);
			MainRenderer.refresh();
			Animation.resetEffects(Globals.currentFloor.getWidth(), Globals.currentFloor.getHeight());
			keysDown.add(key);
		}
	}
	
	public static void keyUp(int key) {
		keysDown.remove(key);
	}
	
	public static boolean checkKey(int key) {
		return keysDown.contains(key);
	}
	
}
