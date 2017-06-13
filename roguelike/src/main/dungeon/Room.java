package main.dungeon;

public class Room {
	protected int x = 0;
	protected int y = 0;
	protected int sizeX = 0;
	protected int sizeY = 0;
	protected boolean[][] wall;
	
	public Room (){
		x = 1;
		y = 1;
		wall = new boolean [x][y];
		sizeX = 1;
		sizeY = 1;
	}
	
	public Room(int a, int b){
		x = a;
		y = b;
	}
	
	public void basicRoom(){
		sizeX = 2 + (int)(Math.random() * 3);
		sizeY = 2 + (int)(Math.random() * 3);
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
