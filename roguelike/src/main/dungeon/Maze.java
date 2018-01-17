package main.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import main.util.Globals;
import main.util.Pair;

public class Maze {
	static char[][] maze;
	static char[][] altMaze;
	
	static List<Pair> frontier = new ArrayList<Pair>();
	
	static int mapWidth;
	static int mapHeight;
	static boolean checkDiagonals;
	
	public static void generateMaze(int height, int width, int branchRate, boolean checkCorners){
//		creating char[][] to hold values
		mapWidth = width;
		mapHeight = height;
		checkDiagonals = checkCorners;
		
		maze = new char[mapHeight][mapWidth];
		
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				maze[row][column] = '?';
			}
		}
		
//		first coordinates
		Globals.spawnY = (int)(Math.random() * mapHeight);
		Globals.spawnX = (int)(Math.random() * mapWidth);
		
//		generate maze
		carve(new Pair(Globals.spawnY, Globals.spawnX));
		
		while(frontier.size() > 0){
			int pos = (int)(Math.pow(Math.random(), Math.pow(Math.E, -branchRate)) * frontier.size());
			Pair choice = frontier.get(pos);
			
			if(check(choice))
				carve(choice);
			else
				harden(choice);
			frontier.remove(choice);
		}
		
//		turn all unchecked elements into walls
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				if (maze[row][column] == '?')
					harden(new Pair(row, column));
			}
		}
		
		altMaze = new char[mapHeight][mapWidth];
		
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				altMaze[row][column] = maze[row][column];
			}
		}
		
	}
	
	private static void carve(Pair coords){
		List<Pair> extra = new ArrayList<Pair>();
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		maze[row][column] = '.';
		
		if (column > 0 				&& maze[row][column-1] == '?'){
			maze[row][column-1] = ',';
			extra.add(new Pair(row, column-1));
		}
		if (column < mapWidth-1 && maze[row][column+1] == '?'){
			maze[row][column+1] = ',';
			extra.add(new Pair(row, column+1));
		}
		if (row > 0 				&& maze[row-1][column] == '?'){
			maze[row-1][column] = ',';
			extra.add(new Pair(row-1, column));
		}
		if (row < mapHeight-1 		&& maze[row+1][column] == '?'){
			maze[row+1][column] = ',';
			extra.add(new Pair(row+1, column));
		}
		
		shuffleList(extra);
		frontier.addAll(extra);
	}
	private static void harden(Pair coords){
		maze[coords.getFirst()][coords.getSecond()] = '#';
	}
	private static boolean check(Pair coords){
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		int edgeState = 0;
		
		if (column > 0 && maze[row][column-1] == '.')
			edgeState += 1;
		if (column < mapWidth - 1 && maze[row][column+1] == '.')
			edgeState += 2;
		if (row > 0 && maze[row-1][column] == '.')
			edgeState += 4;
		if (row < mapHeight - 1 && maze[row+1][column] == '.')
			edgeState += 8;
		
		if (checkDiagonals){
			if (edgeState == 1){
				return ((column < mapWidth-1) 	&& 
					     ((row > 0 				&& maze[row-1][column+1] == '.') || 
						  (row < mapHeight-1 	&& maze[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 2){
				return ((column > 0) 			&& 
					     ((row > 0 				&& maze[row-1][column-1] == '.') || 
						  (row < mapHeight-1 	&& maze[row+1][column-1] == '.'))) ? false : true;
			}
			else if (edgeState == 4){
				return ((row < mapHeight-1)		&& 
					     ((column > 0 			&& maze[row+1][column-1] == '.') || 
						  (column < mapWidth-1	&& maze[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 8){
				return ((row > 0) 				&& 
					     ((column > 0 			&& maze[row-1][column-1] == '.') || 
						  (column < mapWidth-1  && maze[row-1][column+1] == '.'))) ? false : true;
			}
			return false;
		}
		else{
			for(int i : new int[]{1, 2, 4, 8}){
				if (edgeState == i) 
					return true;
			}
			return false;
		}
	}
	private static <T> void shuffleList(List<T> list){
		Random rnd = ThreadLocalRandom.current();
		for (int i = list.size() - 1; i > 0; i--){
			Collections.swap(list, rnd.nextInt(i + 1), i);
		}
	}
	
	public static void createRooms(char[][] maze, char mode, int rooms, int halls, boolean smoothFirst){
		
		if(smoothFirst)
			smooth(maze, mode, halls);
		else
			smooth(maze, mode, rooms, '.');
		
		if (!smoothFirst)
			smooth(maze, mode, rooms, '.');
		else
			smooth(maze, mode, halls);
		
	}
	private static void smooth(char[][] maze, char mode, int smoothing){
		if (mode == 'n'){
			for(int row = 0; row<mapHeight; row++){
				for(int column = 0; column<mapWidth; column++){
					smooth(maze, new Pair(row, column), smoothing);
				}
			}
		}
		else{
			for(int row = 0; row<mapHeight/2; row++){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(row, column), smoothing);
					smooth(maze, new Pair(row, mapWidth-1-column), smoothing);
				}
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(mapHeight-1-row, column), smoothing);
					smooth(maze, new Pair(mapHeight-1-row, mapWidth-1-column), smoothing);
				}
				if (mapWidth % 2 == 1){ 
					smooth(maze, new Pair(row, mapWidth/2), smoothing);
					smooth(maze, new Pair(mapHeight-1-row, mapWidth/2), smoothing);
				}
			}
			if (mapHeight % 2 == 1){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(mapHeight/2, column), smoothing);
					smooth(maze, new Pair(mapHeight/2, mapWidth-1-column), smoothing);
				}
			}
		}
	}
	private static void smooth(char[][] maze, char mode, int smoothing, char fill){
		if (mode == 'n'){
			for(int row = 0; row<mapHeight; row++){
				for(int column = 0; column<mapWidth; column++){
					smooth(maze, new Pair(row, column), smoothing);
				}
			}
		}
		else{
			for(int row = 0; row<mapHeight/2; row++){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(row, column), smoothing, fill);
					smooth(maze, new Pair(row, mapWidth-1-column), smoothing, fill);
				}
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(mapHeight-1-row, column), smoothing, fill);
					smooth(maze, new Pair(mapHeight-1-row, mapWidth-1-column), smoothing, fill);
				}
				if (mapWidth % 2 == 1){ 
					smooth(maze, new Pair(row, mapWidth/2), smoothing, fill);
					smooth(maze, new Pair(mapHeight-1-row, mapWidth/2), smoothing, fill);
				}
			}
			if (mapHeight % 2 == 1){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(maze, new Pair(mapHeight/2, column), smoothing, fill);
					smooth(maze, new Pair(mapHeight/2, mapWidth-1-column), smoothing, fill);
				}
			}
	}
	}
	private static void smooth(char[][] maze, Pair coords, int degree){
		int row = coords.getFirst();
		int column = coords.getSecond();
		int sharedEdges = 0;
		
		char fill = (maze[row][column] == '#') ? '.' : '#';
		
		if (checkDiagonals){
			if (row > 0){
				if (					   maze[row-1][column] == fill)
					sharedEdges++;
				if (column > 0 			&& maze[row-1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && maze[row-1][column+1] == fill)
					sharedEdges++;
			}
			if (row < mapHeight-1){
				if (					   maze[row+1][column] == fill)
					sharedEdges++;
				if (column > 0 			&& maze[row+1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && maze[row+1][column+1] == fill)
					sharedEdges++;
			}
			if (column > 0 			&& maze[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && maze[row][column+1] == fill)
				sharedEdges++;
		}
		else{
			if (row > 0 && maze[row-1][column] == fill)
					sharedEdges++;
			if (row < mapHeight-1 && maze[row+1][column] == fill)
					sharedEdges++;
			if (column > 0 && maze[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && maze[row][column+1] == fill)
				sharedEdges++;
		}
		if (sharedEdges >= degree)
			maze[row][column] = fill;
	}
	private static void smooth(char[][] maze, Pair coords, int degree, char fill){
		int row = coords.getFirst();
		int column = coords.getSecond();
		int sharedEdges = 0;
		
		if (checkDiagonals){
			if (row > 0){
				if (maze[row-1][column] == fill)
					sharedEdges++;
				if (column > 0 && maze[row-1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && maze[row-1][column+1] == fill)
					sharedEdges++;
			}
			if (row < mapHeight-1){
				if (maze[row+1][column] == fill)
					sharedEdges++;
				if (column > 0 && maze[row+1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && maze[row+1][column+1] == fill)
					sharedEdges++;
			}
			if (column > 0 && maze[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && maze[row][column+1] == fill)
				sharedEdges++;
		}
		else{
			if (row > 0 && maze[row-1][column] == fill)
					sharedEdges++;
			if (row < mapHeight-1 && maze[row+1][column] == fill)
					sharedEdges++;
			if (column > 0 && maze[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && maze[row][column+1] == fill)
				sharedEdges++;
		}
		if (sharedEdges >= degree)
			maze[row][column] = fill;
	}
	
	public static void printMaze(){
		for(char[] c : maze)
			System.out.println(new String(c));
		System.out.println();
	}
	
	public static void printMazeDif(char[][] maze1, char[][] maze2){
		for(int row = 0; row<mapHeight; row++){
			String s1 = new String(maze1[row]);
			String s2 = "";
			String s3 = new String(maze2[row]);
			for(int column = 0; column<mapWidth; column++){
					if (maze1[row][column] == maze2[row][column]){
						s2 += ' ';
					}
					else if (maze1[row][column] == '.')
						s2 += '+';
					else
						s2 += '-';
			}
			System.out.println(s1 + "   " + s2 + "   " + s3);
		}
		System.out.println();
	}
	
	public static char[][] getMaze(){
		return maze;
	}
	
	public static void main(String[] args){
//		generateMaze(0<mapHeight, 0<mapWidth, -10<branchRate<10, checkDiagonals)
		generateMaze(25			, 25		, 5				   , true		   );
		
		/*
		if checkDiagonals is true
		5<halls, identical above 8
		halls = 9;  6<=room<=7		 ; false = true all room
		halls = 8; 	6<=room<=7		 ; false = true all room
		halls = 7; 	6<=room			 ; false = true when 7<=room
		halls = 6; 	6 & false 8<=room; false = true when 9<=room
		
		if checkDiagonals is false
		halls = 5; 4<=rooms; false = true all room
		halls = 4; 4<=rooms; false = true all room
		*/
		
		int halls = 8;
		int rooms = 8;
		
		createRooms(maze, 'n', rooms, halls, false);
		createRooms(altMaze, 'w', rooms, halls, false);
		printMazeDif(maze, altMaze);
	}
	
}
