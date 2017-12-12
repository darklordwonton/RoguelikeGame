package main.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import main.tiles.Tile;
import main.util.Pair;

public class Maze {
	static char[][] maze;
	static List<Pair> frontier = new ArrayList<Pair>();
	
	static int mapWidth;
	static int mapHeight;
	static boolean checkDiagonals;
	
	public static void generateMaze(int rowLength, int columnLength, int branchRate, boolean checkCorners){
//		creating char[][] to hold values
		mapWidth = columnLength;
		mapHeight = rowLength;
		checkDiagonals = checkCorners;
		
		maze = new char[mapHeight][mapWidth];
		
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				maze[row][column] = '?';
			}
		}
		
//		first coordinates
		int originalRow = (int)(Math.random() * mapHeight);
		int originalColumn = (int)(Math.random() * mapWidth);
		
//		generate maze
		carve(new Pair(originalRow, originalColumn));
		
		while(frontier.size() > 0){
			int pos = (int)(Math.pow(Math.random(), Math.pow(Math.E, -branchRate)) * frontier.size());
			Pair choice = frontier.get(pos);
			
			if(check(choice)){
				carve(choice);
			}
			else{
				harden(choice);
			}
			frontier.remove(choice);
		}
		
//		turn all unchecked elements into walls
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				if (maze[row][column] == '?')
					harden(new Pair(row, column));
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
				return ((column < mapWidth - 1) && 
					   ((row > 0 && maze[row-1][column+1] == '.') || 
						(row < mapHeight - 1 && maze[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 2){
				return ((column > 0) && 
					   ((row > 0 && maze[row-1][column-1] == '.') || 
						(row < mapHeight - 1 && maze[row+1][column-1] == '.'))) ? false : true;
			}
			else if (edgeState == 4){
				return ((row < mapHeight - 1) && 
					   ((column > 0 && maze[row+1][column-1] == '.') || 
						(column < mapWidth - 1 && maze[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 8){
				return ((row > 0) && 
					   ((column > 0 && maze[row-1][column-1] == '.') || 
						(column < mapWidth-1 && maze[row-1][column+1] == '.'))) ? false : true;
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
	
	public static void createRooms(int openness, int smoothing){
		for(int row = 0; row<mapHeight/2; row++){
			for(int column = 0; column<mapWidth/2; column++){
				smooth(new Pair(row, column), smoothing);
				smooth(new Pair(row, mapWidth-1-column), smoothing);
			}
			for(int column = 0; column<mapWidth/2; column++){
				smooth(new Pair(mapHeight-1-row, column), smoothing);
				smooth(new Pair(mapHeight-1-row, mapWidth-1-column), smoothing);
			}
			if (mapWidth % 2 == 1){ 
				smooth(new Pair(row, mapWidth/2), smoothing);
				smooth(new Pair(mapHeight-1-row, mapWidth/2), smoothing);
			}
		}
		if (mapHeight % 2 == 1){
			for(int column = 0; column<mapWidth/2; column++){
				smooth(new Pair(mapHeight/2, column), smoothing);
				smooth(new Pair(mapHeight/2, mapWidth-1-column), smoothing);
			}
		}
		
		for(int row = 0; row<mapHeight/2; row++){
			for(int column = 0; column<mapWidth/2; column++){
				open(new Pair(row, column), openness);
				open(new Pair(row, mapWidth-1-column), openness);
			}
			for(int column = 0; column<mapWidth/2; column++){
				open(new Pair(mapHeight-1-row, column), openness);
				open(new Pair(mapHeight-1-row, mapWidth-1-column), openness);
			}
			if (mapWidth % 2 == 1){ 
				open(new Pair(row, mapWidth/2), openness);
				open(new Pair(mapHeight-1-row, mapWidth/2), openness);
			}
		}
		if (mapHeight % 2 == 1){
			for(int column = 0; column<mapWidth/2; column++){
				open(new Pair(mapHeight/2, column), openness);
				open(new Pair(mapHeight/2, mapWidth-1-column), openness);
			}
		}
	}
	
	private static void smooth(Pair coords, int degree){
		int row = coords.getFirst();
		int column = coords.getSecond();
		int sharedEdges = 0;
		
		char fill = (maze[row][column] == '#') ? '.' : '#';
		
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
	
	private static void open(Pair coords, int degree){
		int row = coords.getFirst();
		int column = coords.getSecond();
		char fill = '.';
		
		if (maze[row][column] != fill){
			boolean[] side = {false, false, false, false};
			boolean[] diagonal = {false, false, false, false};
			int count = 0;
			
			
			if (row < mapHeight-1 && maze[row+1][column] == fill)
				side[0] = true;
			if (row > 0 && maze[row-1][column] == fill)
				side[1] = true;
			if (column < mapWidth-1 && maze[row][column+1] == fill)
				side[2] = true;
			if (column > 0 && maze[row][column-1] == fill)
				side[3] = true;
			
	
			if (side[0] && side[2] && maze[row+1][column+1] == fill)
				diagonal[0] = true;
			if (side[0] && side[3] && maze[row+1][column-1] == fill)
				diagonal[1] = true;
			if (side[1] && side[2] && maze[row-1][column+1] == fill)
				diagonal[2] = true;
			if (side[1] && side[3] && maze[row-1][column-1] == fill)
				diagonal[3] = true;
			
			for(boolean b : side){
				if (b)
					count++;
			}
			for(boolean b : diagonal){
				if (b)
					count++;
			}
			
			if (count >= degree)
				maze[row][column] = fill;
		}
	}
	
	public static void printMaze(){
		for(char[] c : maze)
			System.out.println(new String(c));
		System.out.println();
	}
	
	public static char[][] getMaze(){
		return maze;
	}
	
	public static void main(String[] args){
//		generateMaze(mapHeight, mapWidth, branchRate, checkDiagonals)
		generateMaze(25 	  ,	25		, 5			, false			);
		
		createRooms(4, 5);
		
		printMaze();
		
	}
	
}
