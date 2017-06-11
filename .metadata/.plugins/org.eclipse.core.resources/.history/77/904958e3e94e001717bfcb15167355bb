package main;

import java.util.Scanner;

import main.actions.Action;
import main.dungeon.Generator;
import main.entities.ai.AI;
import main.rendering.Draw;
import main.util.Globals;
import main.util.Initializer;

public class Hub {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		
		Initializer.start();
		Generator.blankFloor();
		Generator.newEntity();
		Draw.drawEverything();
		while(true){
			Action.command(s.nextLine().charAt(0), 0);
			for (int i = 1; i < Globals.currentCreatures; i++){
				Action.command(AI.Creature(i), i);
			}
			Draw.drawEverything();
		}
	}
}
