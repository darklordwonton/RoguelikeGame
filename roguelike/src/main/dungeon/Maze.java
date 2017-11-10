package main.dungeon;

import main.tiles.Tile;

public class Maze {
	
	public static void generateMaze(int floorNum, Tile[][] tiles){
		int rowLength = tiles.length;
		int columnLength = tiles[0].length;
		
		char[][] tileList = new char[rowLength][columnLength];
		
		for(int row = 0; row<rowLength; row++){
			for(int column = 0; column<columnLength; column++){
				tileList[row][column] = '?';
			}
		}
		
		carve(, y);
		
		
		
		
		for(int row = 0; row<rowLength/2; row++){ //iterate columns
			for(int column = 0; column<columnLength/2; column++){
				tiles[row][column]; //start at beginning of column
				tiles[rowLength-row][columnLength-column]; //start at end of column
			}
			
			if (columnLength % 2 == 1){ //meet in middle of column
				tiles[rowLength/2][columnLength/2];
			}
		}
		if (rowLength % 2 == 1){ //meet in middle of rows
			for(int column = 0; column<columnLength/2; column++){
				tiles[rowLength/2][column]; //start at beginning
				tiles[rowLength/2][columnLength-column]; //start at end
			}
		}
	}
	
	public static int carve(int row, int column){
		
	}
	
}
