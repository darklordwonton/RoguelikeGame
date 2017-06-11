package main.util;

import java.util.ArrayList;
import java.util.List;

import main.dungeon.Map;
import main.entities.Entity;

public class Globals {
	//Config Variables
	public static final int MAX_CREATURES = 10;
	public static final int FLOOR_SIZE = 10;
	
	//Image Names
	public static final String PLAYER_SPRITE = "player.jpg";
	
	//Global Variables
	public static String message = "";
	public static int currentFloor = 0;
	
	//Global Arrays
	public static Entity player = null;
	public static List<Entity> entities = new ArrayList<Entity>();
	public static List<Map> maps = new ArrayList<Map>();
}
