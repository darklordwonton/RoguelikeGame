package main.util;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.dungeon.Floor;
import main.entities.Entity;
import main.tiles.EnumFloor;

public class Globals {
	//Config Variables
	public static final int MAX_CREATURES = 10;
	public static final int FLOOR_SIZE = 10;
	
	//Image Names
	public static final String PLAYER_SPRITE = "player.jpg";
	public static final Map<EnumFloor, String> FLOOR_SPRITES = new HashMap<EnumFloor, String>();
	static {
		FLOOR_SPRITES.put(EnumFloor.GRAY_BRICK, "gray_bricks_floor.jpg");
		FLOOR_SPRITES.put(EnumFloor.STONE, "stone_floor.jpg");
		FLOOR_SPRITES.put(EnumFloor.VOLCANO, "volcano_floor.jpg");
	};
	
	//Keys
	public static final int UP_KEY = KeyEvent.VK_UP;
	public static final int DOWN_KEY = KeyEvent.VK_DOWN;
	public static final int LEFT_KEY = KeyEvent.VK_LEFT;
	public static final int RIGHT_KEY = KeyEvent.VK_RIGHT;
	
	//Global Variables
	public static String message = "";
	public static int currentFloor = 0;
	public static int scrollX = 0;
	public static int scrollY = 0;
	
	//Global Arrays
	public static Entity player = null;
	public static List<Entity> entities = new ArrayList<Entity>();
	public static List<Floor> floors = new ArrayList<Floor>();
}
