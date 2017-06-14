package main.dungeon;

import main.util.Globals;

public class Room {
	protected int x = 0;
	protected int y = 0;
	protected int sizeX = 0;
	protected int sizeY = 0;
	protected boolean[][] wall;
	protected int[] exitX = new int[2];
	protected int[] exitY = new int[2];
	protected Floor floor = null;
	
	public Room(int a, int b, Floor f){
		x = a;
		y = b;
		floor = f;
		wall = new boolean [x][y];
	}
	
	public void basicRoom(){
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
	
}
