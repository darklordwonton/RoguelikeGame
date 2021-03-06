package main.dungeon;

import java.util.ArrayList;
import java.util.List;

import main.entities.Entity;
import main.entities.monsters.EntityGoblin;
import main.entities.monsters.EntityOgre;
import main.entities.monsters.EntitySkeleton;
import main.entities.monsters.SlimeVariants.*;
import main.util.Globals;

public class Room {
	protected int x = 0;
	protected int y = 0;
	protected int sizeX = 0;
	protected int sizeY = 0;
	protected boolean[][] wall;
	protected int[] exitX = new int[2];
	protected int[] exitY = new int[2];
	protected Floor floor = null; //Do we need to give it the floor? I can't see where it uses it
	protected List<Entity> entities = new ArrayList<Entity> (); //A list of the entities that start in this room
	protected int ECount = 0;
	
	public Room(int a, int b, Floor f, int e){
		x = a;
		y = b;
		floor = f;
		wall = new boolean [x][y];
		ECount = e;
	}
	
	public void generateRoom(){
		sizeX = Globals.MIN_ROOM_SIZE + (int)(Math.random() * (Globals.MAX_ROOM_SIZE - Globals.MIN_ROOM_SIZE + 1));
		if (x + sizeX > floor.getWidth() - 1) {
			sizeX = floor.getWidth() - 1 - x;
		}
		
		sizeY = Globals.MIN_ROOM_SIZE + (int)(Math.random() * (Globals.MAX_ROOM_SIZE - Globals.MIN_ROOM_SIZE + 1));
		if (y + sizeY > floor.getHeight() - 1){
			sizeY = floor.getHeight() - 1 - y;
		}
		
		wall = new boolean [sizeX][sizeY];
		for (int i = 0; i < sizeY; i++){
			for (int e = 0; e < sizeX; e++){
				wall[e][i] = false;
			}
		}
	}
	
	public void spawnEntities() {
		while (ECount > 0){
			Entity e = null;
			int rand = (int)(Math.random() * 3);
			switch(rand) { 
				case 0 :
					e = new EntitySkeleton(x, y);
					break;
				case 1 :
					e = new EntityGoblin(x, y);
					break;
				case 2 :
					rand = (int)(Math.random() * 5);
					switch(rand) {
					case 0 :
						e = new EntitySlimeDarkBlue(x, y);
						break;
					case 1 :
						e = new EntitySlimeGreen(x, y);
						break;
					case 2 :
						e = new EntitySlimeLightBlue(x, y);
						break;
					case 3 :
						e = new EntitySlimeRed(x, y);
						break;
					case 4 :
						e = new EntitySlimeYellow(x, y);
						break;
					}
					break;
			}
			entities.add(e);
			floor.addEntity(e, x, y);
			ECount --;
		}
	}
	
	public boolean isWall (int x, int y){
		return wall[x][y];
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getSizeX(){
		return sizeX;
	}
	
	public int getSizeY(){
		return sizeY;
	}
	
	public List<Entity> getEntities(int x){
		return entities;
	}
	
}
