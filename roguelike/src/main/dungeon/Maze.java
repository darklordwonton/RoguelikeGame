package main.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import main.tiles.Tile;
import main.util.Pair;

public class Maze {
	
	int rowLength = -1;
	int columnLength = -1;
	
	char[][] tiles;
	List<Pair> frontier = new ArrayList<Pair>();
	
	public Maze(int rowLength, int columnLength){
		this.rowLength = rowLength; 
		this.columnLength = columnLength;
		
		tiles = new char[rowLength][columnLength];
		
		for(int row = 0; row<rowLength; row++){
			for(int column = 0; column<columnLength; column++){
				tiles[row][column] = '?';
			}
		}
	}
	
	public void carve(Pair coords){
		List<Pair> extra = new ArrayList<Pair>();
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		tiles[row][column] = '.';
		
		if (column > 0 				&& tiles[row][column-1] == '?'){
			tiles[row][column-1] = ',';
			extra.add(new Pair(row, column-1));
		}
		if (column < columnLength-1 && tiles[row][column+1] == '?'){
			tiles[row][column+1] = ',';
			extra.add(new Pair(row, column-+1));
		}
		if (row > 0 				&& tiles[row-1][column] == '?'){
			tiles[row-1][column] = ',';
			extra.add(new Pair(row-1, column));
		}
		if (row < rowLength-1 		&& tiles[row+1][column] == '?'){
			tiles[row+1][column] = ',';
			extra.add(new Pair(row+1, column));
		}
		
		shuffleList(extra);
		frontier.addAll(extra);
	}
	
	public void harden(Pair coords){
		tiles[coords.getFirst()][coords.getSecond()] = '#';
	}
	
	public boolean check(Pair coords){
		
		int row = coords.getFirst();
		int column = coords.getSecond();
		
		boolean noDiagonals = true;
		
		int edgeState = 0;
		
		if (column > 0 && tiles[row][column-1] == '.')
			edgeState += 1;
		if (column < columnLength - 1 && tiles[row][column+1] == '.')
			edgeState += 2;
		if (row > 0 && tiles[row-1][column] == '.')
			edgeState += 4;
		if (row < rowLength - 1 && tiles[row+1][column] == '.')
			edgeState += 8;
		
		
		if (noDiagonals){
			if (edgeState == 1){
				if (column < columnLength - 1){
					if (row > 0 && tiles[row-1][column+1] == '.')
						return false;
					if (row < rowLength - 1 && tiles[row+1][column+1] == '.')
						return false;
				}
				return true;
			}
			else if (edgeState == 2){
				if (column > 0){
					if (row > 0 && tiles[row-1][column-1] == '.')
						return false;
					if (row < rowLength - 1 && tiles[row+1][column-1] == '.')
						return false;
				}
				return true;
			}
			else if (edgeState == 4){
				if (row < rowLength - 1){
					if (column > 0 && tiles[row+1][column-1] == '.')
							return false;
					if (column < columnLength - 1 && tiles[row+1][column+1] == '.')
							return false;
					return true;
				}
			}
			else if (edgeState == 8){
				if (row > 0){
					if (column > 0 && tiles[row-1][column-1] == '.')
						return false;
					if (column < columnLength-1 && tiles[row-1][column+1] == '.')
						return false;
				}
				return true;
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
	
	public static <T> void shuffleList(List<T> list){
		Random rnd = ThreadLocalRandom.current();
		for (int i = list.size() - 1; i > 0; i--){
			Collections.swap(list, rnd.nextInt(i + 1), i);
		}
	}
	
	public void printMaze(){
		for(int row = 0; row<rowLength; row++){
			String s = "";
			for(int column = 0; column<columnLength; column++){
				s += tiles[row][column];
			}
			System.out.println(s);
		}
	}
	
	public void generateMaze(){
		int originalRow = (int)(Math.random() * rowLength);
		int originalColumn = (int)(Math.random() * columnLength);
		
		Pair originalCoords = new Pair(originalRow, originalColumn);
		
		carve(originalCoords);
		
		int branchRate = 50;
		
		while(frontier.size() > 0){
			double rand = Math.random();
			int pos = (int)Math.pow(rand, Math.pow(Math.E, -branchRate));
			Pair choice = frontier.get((int)(pos * frontier.size()));
			
			if(check(choice)){
				carve(choice);
			}
			else{
				harden(choice);
			}
			frontier.remove(choice);
		}
		
		for(int row = 0; row<rowLength; row++){
			for(int column = 0; column<columnLength; column++){
				if (tiles[row][column] == '?')
					tiles[row][column] = '#';
			}
		}
		
		this.printMaze();
		
		/*
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
		*/
	}
	
	public static void main(String[] args){
		Maze maze = new Maze(10, 10);
		
		maze.generateMaze();
		
		
	}
	
}
