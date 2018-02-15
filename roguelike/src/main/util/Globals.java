package main.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.effects.attacks.EnumAttackType;
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
	
	public static final int BASE_CREATURES = 5;
	public static final float CREATURES_INCREASE = .3f; //Creatures should go up exponentially. 
														//Maybe make them a property of rooms so it's based off rooms per floor instead?
	
	
	public static final int FLOORS_PER_THEME = 5; //Number of floors per theme
	
	public static final int LEVEL_XP_BASE = 10;
	public static final int LEVEL_XP_MODIFIER = 5;
	
	//Walls
	public static final Map<EnumAttackType, Float> DEFAULT_WALL_MODIFIERS = new HashMap<EnumAttackType, Float>();
	static {
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.SHARP, 0.5f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.SMASH, 2f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.FIRE, 0.5f);
		DEFAULT_WALL_MODIFIERS.put(EnumAttackType.EXPLOSION, 5f);
	}
	public static final int DESTRUCTION_BASE = 1; 
	public static final int DESTRUCTION_MODIFIER = 4;
	
	//Image Names
	public static final String PLAYER_SPRITE_SHEET = "player.png";
	public static final String GOBLIN_SPRITE = "enemy_goblin_base.png";
	public static int PLAYER_SPRITE_ROW = 0;
	public static int PLAYER_SPRITE_COLUMN = 0;
	public static int PLAYER_SPRITE_FRAME_COUNT = 1;
	
	public static final Map<EnumTheme, String> FLOOR_SPRITE_SHEETS = new HashMap<EnumTheme, String>();
	static {
		FLOOR_SPRITE_SHEETS.put(EnumTheme.CAVE, "cave_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.GRAY_BRICK, "gray_brick_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.BROWN_BRICK, "brown_brick_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.VOLCANO, "volcano_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.DIRT, "dirt_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.CYBER, "cyber_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.SAND, "sand_floor_sheet.png");
		FLOOR_SPRITE_SHEETS.put(EnumTheme.WEEDSTONE, "weedStone_floor_sheet.png");
	};
	
	public static final Map<EnumTheme, Integer> TILE_SPRITE_SHEET_LENGTHS = new HashMap<EnumTheme, Integer>();
	static {
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.CAVE, 1);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.GRAY_BRICK, 4);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.BROWN_BRICK, 1);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.VOLCANO, 1);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.DIRT, 1);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.CYBER, 4);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.SAND, 1);
		TILE_SPRITE_SHEET_LENGTHS.put(EnumTheme.WEEDSTONE, 2);
	};
	
	public static final Map<EnumTheme, String> WALL_SPRITES = new HashMap<EnumTheme, String>();
	static {
		WALL_SPRITES.put(EnumTheme.CAVE, "wall.png");
		WALL_SPRITES.put(EnumTheme.GRAY_BRICK, "wall.png");
		WALL_SPRITES.put(EnumTheme.BROWN_BRICK, "wall.png");
		WALL_SPRITES.put(EnumTheme.VOLCANO, "wall.png");
		WALL_SPRITES.put(EnumTheme.DIRT, "wall.png");
		WALL_SPRITES.put(EnumTheme.CYBER, "wall.png");
		WALL_SPRITES.put(EnumTheme.SAND, "wall.png");
		WALL_SPRITES.put(EnumTheme.WEEDSTONE, "wall.png");
	};
	
	public static final Map<EnumTheme, String> EMPTY_SPRITES = new HashMap<EnumTheme, String>();
	static {
		EMPTY_SPRITES.put(EnumTheme.CAVE, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.GRAY_BRICK, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.BROWN_BRICK, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.VOLCANO, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.DIRT, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.CYBER, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.SAND, "empty.png");
		EMPTY_SPRITES.put(EnumTheme.WEEDSTONE, "empty.png");
	};
	
	public static final Map<EnumTheme, String> BREAKABLE_SPRITES = new HashMap<EnumTheme, String>();
	static { //If they're all the same, do we really need this?
		BREAKABLE_SPRITES.put(EnumTheme.CAVE, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.GRAY_BRICK, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.BROWN_BRICK, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.VOLCANO, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.DIRT, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.CYBER, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.SAND, "cracked_wall.png");
		BREAKABLE_SPRITES.put(EnumTheme.WEEDSTONE, "cracked_wall.png");
	};
	
	//Colors
	public static final Map<EnumTheme, Color> BG_COLORS = new HashMap<EnumTheme, Color>();
	static {//See above
		BG_COLORS.put(EnumTheme.CAVE, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.GRAY_BRICK, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.BROWN_BRICK, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.VOLCANO, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.DIRT, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.CYBER, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.SAND, Color.DARK_GRAY);
		BG_COLORS.put(EnumTheme.WEEDSTONE, Color.DARK_GRAY);
	};
	
	//Themes
	public static final Map<EnumTheme, EnumTheme[]> RELATED_THEMES = new HashMap<EnumTheme, EnumTheme[]>();
	static {
		EnumTheme[] caveRelated = {EnumTheme.CAVE, EnumTheme.GRAY_BRICK, EnumTheme.VOLCANO, EnumTheme.DIRT, EnumTheme.SAND, EnumTheme.WEEDSTONE};
		RELATED_THEMES.put(EnumTheme.CAVE, caveRelated);
		EnumTheme[] grayBrickRelated = {EnumTheme.CAVE, EnumTheme.GRAY_BRICK, EnumTheme.BROWN_BRICK, EnumTheme.DIRT, EnumTheme.WEEDSTONE};
		RELATED_THEMES.put(EnumTheme.GRAY_BRICK, grayBrickRelated);
		EnumTheme[] brownBrickRelated = {EnumTheme.GRAY_BRICK, EnumTheme.BROWN_BRICK, EnumTheme.CYBER};
		RELATED_THEMES.put(EnumTheme.BROWN_BRICK, brownBrickRelated);
		EnumTheme[] volcanoRelated = {EnumTheme.CAVE, EnumTheme.VOLCANO, EnumTheme.CYBER};
		RELATED_THEMES.put(EnumTheme.VOLCANO, volcanoRelated);
		EnumTheme[] dirtRelated = {EnumTheme.CAVE, EnumTheme.GRAY_BRICK, EnumTheme.DIRT, EnumTheme.SAND, EnumTheme.WEEDSTONE};
		RELATED_THEMES.put(EnumTheme.DIRT, dirtRelated);
		EnumTheme[] cyberRelated = {EnumTheme.BROWN_BRICK, EnumTheme.VOLCANO, EnumTheme.CYBER};
		RELATED_THEMES.put(EnumTheme.CYBER, cyberRelated);
		EnumTheme[] sandRelated = {EnumTheme.CAVE, EnumTheme.DIRT, EnumTheme.SAND, EnumTheme.WEEDSTONE};
		RELATED_THEMES.put(EnumTheme.SAND, sandRelated);
		EnumTheme[] weedStoneRelated = {EnumTheme.CAVE, EnumTheme.GRAY_BRICK, EnumTheme.BROWN_BRICK, EnumTheme.SAND, EnumTheme.WEEDSTONE};
		RELATED_THEMES.put(EnumTheme.WEEDSTONE, weedStoneRelated);
	};
	
	
	//Keys
	public static final int UP_KEY = KeyEvent.VK_UP;
	public static final int DOWN_KEY = KeyEvent.VK_DOWN;
	public static final int LEFT_KEY = KeyEvent.VK_LEFT;
	public static final int RIGHT_KEY = KeyEvent.VK_RIGHT;
	public static final int ESC_KEY = KeyEvent.VK_ESCAPE;
	public static final int ENTER_KEY = KeyEvent.VK_ENTER;
	public static final int BACKSLASH = KeyEvent.VK_BACK_SLASH;
	public static final int S = KeyEvent.VK_S;
	public static final int M = KeyEvent.VK_M;
	
	//Global Variables
	public static String message = "";
	public static int floorNumber = 0;
	public static int spawnX = 0;
	public static int spawnY = 0;
	public static int scrollX = 0;
	public static int scrollY = 0;
	public static EnumTheme currentTheme = EnumTheme.GRAY_BRICK;
	public static EntityPlayer player = null;
	public static Floor currentFloor = null;
	
	//Global Arrays
	
	//Mob stat constants
	public static final int PATHETIC_STAT = 2;
	public static final int VERY_LOW_STAT = 5;
	public static final int LOW_STAT = 10;
	public static final int MID_STAT = 15;
	public static final int HIGH_STAT = 20;
	public static final int VERY_HIGH_STAT = 30;	
	public static final int GOD_STAT = 50;
	
	//Debug features
	public static final boolean NO_CLIP = false;	//Walk through walls
	public static final boolean SKIP_FLOORS = true; //Skip floor button, currently "\"
	public static final boolean SKIP_LEVEL = true;  //Skip level button, currently "s"
}
