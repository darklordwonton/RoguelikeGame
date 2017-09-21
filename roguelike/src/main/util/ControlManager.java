package main.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.actions.ActionHandler;
import main.rendering.MainRenderer;

public class ControlManager {

	private static Set<Integer> keyQueue = new HashSet<Integer>();
	private static Set<Integer> keysDown = new HashSet<Integer>();
	
	public static void init() {
		
	}
	
	public static void keyDown(int key) {
		ActionHandler.command(key, Globals.player);
		//MainRenderer.drawFloor(Globals.currentFloor);
		keyQueue.add(key);
		keysDown.add(key);
	}
	
	public static void keyUp(int key) {
		keysDown.remove(key);
	}
	
	public static boolean checkKey(int key) {
		return keysDown.contains(key);
	}
	
	public static Integer[] getQueue() {
		Integer[] queue = keyQueue.toArray(new Integer[1]);
		keyQueue.clear();
		return queue;
	}
	
}
