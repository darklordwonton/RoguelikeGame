package main.util;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import main.actions.Action;
import main.rendering.MainRenderer;

public class ControlManager {

	private static Set<Integer> keysDown = new HashSet<Integer>();
	
	public static void init() {
		
	}
	
	public static void keyDown(int key) {
		Action.command(key, Globals.player);
		MainRenderer.drawFloor(Globals.currentFloor);
		keysDown.add(key);
	}
	
	public static void keyUp(int key) {
		keysDown.remove(key);
	}
	
	public static boolean checkKey(int key) {
		return keysDown.contains(key);
	}
	
}
