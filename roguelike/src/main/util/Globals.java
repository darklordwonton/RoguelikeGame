package main.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.dungeon.Floor;
import main.entities.Entity;
import main.entities.EntityPlayer;
import main.tiles.EnumTheme;

public class Globals {
	//Config Variables
	public static final int MAX_CREATURES = 10;
	public static final int FLOOR_SIZE = 20;
	public static final int MAX_ROOM_SIZE = 5;
	public static final int MIN_ROOM_SIZE = 2;
	public static final int ROOMS_PER_FLOOR = 5;
	
	//Image Names
	public static final String PLAYER_SPRITE = "player.jpg";
	public static final Map<EnumTheme, String> FLOOR_SPRITES = new HashMap<EnumTheme, String>();
	static {
		FLOOR_SPRITES.put(EnumTheme.CAVE, "cave_floor.jpg");
		FLOOR_SPRITES.put(EnumTheme.GRAY_BRICK, "gray_brick_floor.jpg");
		FLOOR_SPRITES.put(EnumTheme.BROWN_BRICK, "brown_brick_floor.jpg");
		FLOOR_SPRITES.put(EnumTheme.VOLCANO, "volcano_floor.jpg");
	};
	
	public static final Map<EnumTheme, String> WALL_SPRITES = new HashMap<EnumTheme, String>();
	static {
		WALL_SPRITES.put(EnumTheme.CAVE, "solid_black.jpg");
		WALL_SPRITES.put(EnumTheme.GRAY_BRICK, "solid_black.jpg");
		WALL_SPRITES.put(EnumTheme.BROWN_BRICK, "solid_black.jpg");
		WALL_SPRITES.put(EnumTheme.VOLCANO, "solid_black.jpg");
	};
	
	//Colors
	public static final Map<EnumTheme, Color> BG_COLORS = new HashMap<EnumTheme, Color>();
	static {
		BG_COLORS.put(EnumTheme.CAVE, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.GRAY_BRICK, Color.DARK_GRAY);
	};
	
	//Keys
	public static final int UP_KEY = KeyEvent.VK_UP;
	public static final int DOWN_KEY = KeyEvent.VK_DOWN;
	public static final int LEFT_KEY = KeyEvent.VK_LEFT;
	public static final int RIGHT_KEY = KeyEvent.VK_RIGHT;
	
	//Global Variables
	public static String message = "";
	public static int floorNumber = 0;
	public static int scrollX = 0;
	public static int scrollY = 0;
	
	//Global Arrays
	public static EntityPlayer player = null;
	public static List<Entity> entities = new ArrayList<Entity>();
	public static int floorNum = 0;
	public static Floor currentFloor = null;
	
	
	//mob stat constants
	public static final int PATHETIC_STAT = 0;
	public static final int VERY_LOW_STAT = 1;
	public static final int LOW_STAT = 2;
	public static final int MID_STAT = 3;
	public static final int HIGH_STAT = 4;
	public static final int VERY_HIGH_STAT = 5;	
	public static final int GOD_STAT = 10;
	
	
}
