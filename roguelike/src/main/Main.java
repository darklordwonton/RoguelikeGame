package main;

import java.util.Scanner;

import main.actions.Action;
import main.dungeon.Generator;
import main.entities.ai.AI;
import main.filemanager.ImageManager;
import main.rendering.MainRenderer;
import main.util.Globals;
import main.util.Initializer;

public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		
		Initializer.start();
		MainRenderer.init();
		ImageManager.init();
		while(true){
			MainRenderer.drawFloor(Globals.floors.get(Globals.currentFloor));
		}
	}
	
	
}