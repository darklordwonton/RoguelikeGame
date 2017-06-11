package main.util;

import main.dungeon.Map;
import main.entities.Entity;

public class Globals {
	//Config Variables
	public static final int MAX_CREATURES = 10;
	public static final int FLOOR_SIZE = 10;
	
	//Global Variables
	public static String message = "";
	public static int currentCreatures = 0;
	
	//Global Arrays
	public static Entity[] entities = new Entity[MAX_CREATURES];
	public static Map[][] map = new Map[FLOOR_SIZE][FLOOR_SIZE];
}
