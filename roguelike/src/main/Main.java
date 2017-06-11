package main;

import java.util.Scanner;

import main.actions.Action;
import main.dungeon.Generator;
import main.entities.ai.AI;
import main.filemanager.ImageManager;
import main.rendering.Draw;
import main.rendering.MainRenderer;
import main.util.Globals;
import main.util.Initializer;

public class Main {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		
		Initializer.start();
		//Generator.blankFloor();
		//Generator.newEntity();
		//Draw.drawEverything();
		MainRenderer.init();
		ImageManager.init();
		while(true){
			//Action.command(s.nextLine().charAt(0), Globals.player);
			MainRenderer.drawMap(Globals.maps.get(Globals.currentFloor));
		}
	}
	
	
}
