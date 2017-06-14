package main.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.attacks.EnumAttackType;
import main.dungeon.Floor;
import main.entities.Entity;
import main.entities.EntityPlayer;
import main.tiles.EnumTheme;

public class Globals {
	//Config Variables
	public static final int MAX_CREATURES = 10;
	public static final int FLOOR_SIZE_BASE = 20;
	public static final int FLOOR_SIZE_MODIFIER = 4;
	public static final int MAX_ROOM_SIZE = 5;
	public static final int MIN_ROOM_SIZE = 3;
	public static final int ROOMS_BASE = 15;
	public static final float ROOMS_MODIFIER = 0.5f;
	public static final float ROOMS_LEEWAY = 0.25f;
	public static final int baseCreatures = 1;
	public static final float creatureIncrease = .3f;
	public static final int floorsPerTheme = 5;
	
	//Walls
	public static final Map<EnumAttackType, Float> DEFAULT_WALL_MODIFIERS = new HashMap<EnumAttackType, Float>();
	static {
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.SHARP, 0.5f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.SMASH, 2f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.FIRE, 0.5f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.EXPLOSION, 5f);
	}
	public static final int DESTRUCTION_BASE = 8;
	public static final int DESTRUCTION_MODIFIER = 4;
	
	//Image Names
	public static final String PLAYER_SPRITE = "player.jpg";
	public static final String GOBLIN_SPRITE = "enemy_goblin_base.png";
	
	public static final Map<EnumTheme, String[]> FLOOR_SPRITES = new HashMap<EnumTheme, String[]>();
	static {
		String[] cave = {"cave_floor.jpg"};
		FLOOR_SPRITES.put(EnumTheme.CAVE, cave);
		String[] grayBrick = {"gray_brick_floor_1.jpg", "gray_brick_floor_2.jpg", "gray_brick_floor_3.jpg", "gray_brick_floor_4.jpg"};
		FLOOR_SPRITES.put(EnumTheme.GRAY_BRICK, grayBrick);
		String[] brownBrick = {"brown_brick_floor.jpg"};
		FLOOR_SPRITES.put(EnumTheme.BROWN_BRICK, brownBrick);
		String[] volcano = {"volcano_floor.jpg"};
		FLOOR_SPRITES.put(EnumTheme.VOLCANO, volcano);
		String[] dirt = {"dirt_floor.jpg"};
		FLOOR_SPRITES.put(EnumTheme.DIRT, dirt);
		String[] cyber = {"cyber_floor_1.jpg", "cyber_floor_2.jpg", "cyber_floor_3.jpg", "cyber_floor_4.jpg"};
		FLOOR_SPRITES.put(EnumTheme.CYBER, cyber);
	};
	
	public static final Map<EnumTheme, String> WALL_SPRITES = new HashMap<EnumTheme, String>();
	static {
		WALL_SPRITES.put(EnumTheme.CAVE, "empty.png");
		WALL_SPRITES.put(EnumTheme.GRAY_BRICK, "empty.png");
		WALL_SPRITES.put(EnumTheme.BROWN_BRICK, "empty.png");
		WALL_SPRITES.put(EnumTheme.VOLCANO, "empty.png");
		WALL_SPRITES.put(EnumTheme.DIRT, "empty.png");
		WALL_SPRITES.put(EnumTheme.CYBER, "empty.png");
	};
	
	public static final Map<EnumTheme, String> STAIRS_SPRITES = new HashMap<EnumTheme, String>();
	static {
		STAIRS_SPRITES.put(EnumTheme.CAVE, "cave_stairs.jpg");
		STAIRS_SPRITES.put(EnumTheme.GRAY_BRICK, "gray_brick_stairs.jpg");
		STAIRS_SPRITES.put(EnumTheme.BROWN_BRICK, "brown_brick_stairs.jpg");
		STAIRS_SPRITES.put(EnumTheme.VOLCANO, "volcano_stairs.jpg");
		STAIRS_SPRITES.put(EnumTheme.DIRT, "dirt_stairs.jpg");
		STAIRS_SPRITES.put(EnumTheme.CYBER, "cyber_stairs.jpg");
	};
	
	//Colors
	public static final Map<EnumTheme, Color> BG_COLORS = new HashMap<EnumTheme, Color>();
	static {
		BG_COLORS.put(EnumTheme.CAVE, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.GRAY_BRICK, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.BROWN_BRICK, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.VOLCANO, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.DIRT, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.CYBER, Color.DARK_GRAY);
	};
	
	//Keys
	public static final int UP_KEY = KeyEvent.VK_UP;
	public static final int DOWN_KEY = KeyEvent.VK_DOWN;
	public static final int LEFT_KEY = KeyEvent.VK_LEFT;
	public static final int RIGHT_KEY = KeyEvent.VK_RIGHT;
	public static final int ESC_KEY = KeyEvent.VK_ESCAPE;
	
	
	//Global Variables
	public static String message = "";
	public static int floorNumber = 0;
	public static int spawnX = 0;
	public static int spawnY = 0;
	public static int scrollX = 0;
	public static int scrollY = 0;
	public static int currentTheme = 1;
	public static int floorsOnTheme = 0;
	
	//Global Arrays
	public static EntityPlayer player = null;
	public static List<Entity> entities = new ArrayList<Entity>();
	public static Floor currentFloor = null;
	
	
	//mob stat constants
	public static final int PATHETIC_STAT = 2;
	public static final int VERY_LOW_STAT = 5;
	public static final int LOW_STAT = 10;
	public static final int MID_STAT = 15;
	public static final int HIGH_STAT = 20;
	public static final int VERY_HIGH_STAT = 30;	
	public static final int GOD_STAT = 50;
	
	
}
