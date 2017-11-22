package main.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import main.util.Pair;

public class Maze {
	static char[][] tiles;
	static List<Pair> frontier = new ArrayList<Pair>();
	
	static int mapWidth;
	static int mapHeight;
	static boolean checkDiagonals;
	
	public static void generateMaze(int rowLength, int columnLength, int branchRate, boolean checkCorners){
//		creating char[][] to hold values
		mapWidth = columnLength;
		mapHeight = rowLength;
		checkDiagonals = checkCorners;
		
		tiles = new char[mapHeight][mapWidth];
		
		for(int row = 0; row<mapHeight; row++){
			for(int column = 0; column<mapWidth; column++){
				tiles[row][column] = '?';
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
				if (tiles[row][column] == '?')
					harden(new Pair(row, column));
			}
		}
	}
	
	private static void carve(Pair coords){
		List<Pair> extra = new ArrayList<Pair>();
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		tiles[row][column] = '.';
		
		if (column > 0 				&& tiles[row][column-1] == '?'){
			tiles[row][column-1] = ',';
			extra.add(new Pair(row, column-1));
		}
		if (column < mapWidth-1 && tiles[row][column+1] == '?'){
			tiles[row][column+1] = ',';
			extra.add(new Pair(row, column+1));
		}
		if (row > 0 				&& tiles[row-1][column] == '?'){
			tiles[row-1][column] = ',';
			extra.add(new Pair(row-1, column));
		}
		if (row < mapHeight-1 		&& tiles[row+1][column] == '?'){
			tiles[row+1][column] = ',';
			extra.add(new Pair(row+1, column));
		}
		
		shuffleList(extra);
		frontier.addAll(extra);
	}
	private static void harden(Pair coords){
		tiles[coords.getFirst()][coords.getSecond()] = '#';
	}
	private static boolean check(Pair coords){
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		int edgeState = 0;
		
		if (column > 0 && tiles[row][column-1] == '.')
			edgeState += 1;
		if (column < mapWidth - 1 && tiles[row][column+1] == '.')
			edgeState += 2;
		if (row > 0 && tiles[row-1][column] == '.')
			edgeState += 4;
		if (row < mapHeight - 1 && tiles[row+1][column] == '.')
			edgeState += 8;
		
		if (checkDiagonals){
			if (edgeState == 1){
				return ((column < mapWidth - 1) && 
					   ((row > 0 && tiles[row-1][column+1] == '.') || 
						(row < mapHeight - 1 && tiles[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 2){
				return ((column > 0) && 
					   ((row > 0 && tiles[row-1][column-1] == '.') || 
						(row < mapHeight - 1 && tiles[row+1][column-1] == '.'))) ? false : true;
			}
			else if (edgeState == 4){
				return ((row < mapHeight - 1) && 
					   ((column > 0 && tiles[row+1][column-1] == '.') || 
						(column < mapWidth - 1 && tiles[row+1][column+1] == '.'))) ? false : true;
			}
			else if (edgeState == 8){
				return ((row > 0) && 
					   ((column > 0 && tiles[row-1][column-1] == '.') || 
						(column < mapWidth-1 && tiles[row-1][column+1] == '.'))) ? false : true;
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
	
	public static void smoothMaze(int type, int degree, int passes){
		for(int i = 0; i<passes; i++)
			smoothType(type, degree);
	}
	public static void smoothMaze(int type, int degree, int wallPasses, int floorPasses, int mode){
		switch (mode){
		case 0:
			for(int i = 0; i<wallPasses || i<floorPasses; i++){
				if (i < wallPasses)
					smoothType(type, degree, '#');
				if (i < floorPasses)
					smoothType(type, degree, '.');
			}
			break;
		case 1:
			for(int i = 0; i<wallPasses; i++)
				smoothType(type, degree, '#');
			for(int i = 0; i<floorPasses; i++)
				smoothType(type, degree, '.');
			break;
		case 2:
			for(int i = 0; i<floorPasses; i++)
				smoothType(type, degree, '.');
			for(int i = 0; i<wallPasses; i++)
				smoothType(type, degree, '#');
			
			break;
		}
	}
	
	private static void smoothType(int type, int degree){
		switch (type){
		case 0:
			for(int row = 0; row<mapHeight; row++)
				for(int column = 0; column<mapWidth; column++)
					smooth(new Pair(row, column), degree);
			break;
		case 1: 
			for(int row = 0; row<mapHeight/2; row++){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(row, column), degree);
					smooth(new Pair(row, mapWidth-1-column), degree);
				}
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(mapHeight-1-row, column), degree);
					smooth(new Pair(mapHeight-1-row, mapWidth-1-column), degree);
				}
				if (mapWidth % 2 == 1){ 
					smooth(new Pair(row, mapWidth/2), degree);
					smooth(new Pair(mapHeight-1-row, mapWidth/2), degree);
				}
			}
			if (mapHeight % 2 == 1){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(mapHeight/2, column), degree);
					smooth(new Pair(mapHeight/2, mapWidth-1-column), degree);
				}
			}
			break;
		}
	}
	private static void smoothType(int type, int degree, char fill){
		switch (type){
		case 0:
			for(int row = 0; row<mapHeight; row++){
				for(int column = 0; column<mapWidth; column++){
					smooth(new Pair(row, column), degree, fill);
				}
			}
			break;
		case 1: 
			for(int row = 0; row<mapHeight/2; row++){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(row, column), degree, fill);
					smooth(new Pair(row, mapWidth-1-column), degree, fill);
				}
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(mapHeight-1-row, column), degree, fill);
					smooth(new Pair(mapHeight-1-row, mapWidth-1-column), degree, fill);
				}
				if (mapWidth % 2 == 1){ 
					smooth(new Pair(row, mapWidth/2), degree, fill);
					smooth(new Pair(mapHeight-1-row, mapWidth/2), degree, fill);
				}
			}
			if (mapHeight % 2 == 1){
				for(int column = 0; column<mapWidth/2; column++){
					smooth(new Pair(mapHeight/2, column), degree, fill);
					smooth(new Pair(mapHeight/2, mapWidth-1-column), degree, fill);
				}
			}
			break;
		}
	}
	
	private static void smooth(Pair coords, int degree){
		int row = coords.getFirst();
		int column = coords.getSecond();
		int sharedEdges = 0;
		
		char fill = (tiles[row][column] == '#') ? '.' : '#';
		
		if (checkDiagonals){
			if (row > 0){
				if (tiles[row-1][column] == fill)
					sharedEdges++;
				if (column > 0 && tiles[row-1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && tiles[row-1][column+1] == fill)
					sharedEdges++;
			}
			if (row < mapHeight-1){
				if (tiles[row+1][column] == fill)
					sharedEdges++;
				if (column > 0 && tiles[row+1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && tiles[row+1][column+1] == fill)
					sharedEdges++;
			}
			if (column > 0 && tiles[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && tiles[row][column+1] == fill)
				sharedEdges++;
		}
		else{
			if (row > 0 && tiles[row-1][column] == fill)
					sharedEdges++;
			if (row < mapHeight-1 && tiles[row+1][column] == fill)
					sharedEdges++;
			if (column > 0 && tiles[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && tiles[row][column+1] == fill)
				sharedEdges++;
		}
		if (sharedEdges >= degree)
			tiles[row][column] = fill;
	}
	private static void smooth(Pair coords, int degree, char fill){
		int row = coords.getFirst();
		int column = coords.getSecond();
		int sharedEdges = 0;
		
		if (checkDiagonals){
			if (row > 0){
				if (tiles[row-1][column] == fill)
					sharedEdges++;
				if (column > 0 && tiles[row-1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && tiles[row-1][column+1] == fill)
					sharedEdges++;
			}
			if (row < mapHeight-1){
				if (tiles[row+1][column] == fill)
					sharedEdges++;
				if (column > 0 && tiles[row+1][column-1] == fill)
					sharedEdges++;
				if (column < mapWidth-1 && tiles[row+1][column+1] == fill)
					sharedEdges++;
			}
			if (column > 0 && tiles[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && tiles[row][column+1] == fill)
				sharedEdges++;
		}
		else{
			if (row > 0 && tiles[row-1][column] == fill)
					sharedEdges++;
			if (row < mapHeight-1 && tiles[row+1][column] == fill)
					sharedEdges++;
			if (column > 0 && tiles[row][column-1] == fill)
				sharedEdges++;
			if (column < mapWidth-1 && tiles[row][column+1] == fill)
				sharedEdges++;
		}
		if (sharedEdges >= degree)
			tiles[row][column] = fill;
	}
	
	public static void printMaze(){
		for(char[] c : tiles)
			System.out.println(new String(c));
		System.out.println();
	}
	
	public static void main(String[] args){
//		generateMaze(mapHeight, mapWidth, branchRate, checkDiagonals)
		generateMaze(25 	  ,	25		, 0			, false			);
		
//		smoothMaze(type, degree, passes)
//		smoothMaze(0   , 6     , 5	   );
		
//		smoothMaze(type, degree, wallPasses, floorPasses, mode)
		
		printMaze();
	}
	
}
