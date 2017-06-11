package main.rendering;

import main.entities.Entity;
import main.util.Globals;

public class Draw {
	public static void drawEverything(){
		mapFloor();
		playerInfo();
	}
	
	public static void mapFloor(){
		for (int i = 0; i < Globals.FLOOR_SIZE; i++){
			for (int e = 0; e < Globals.FLOOR_SIZE; e++){
				boolean drawn = false;
				for (Entity entity : Globals.entities){
					if (entity.getX() == e && entity.getY() == i && !drawn){
						System.out.print(entity.getSymbol());
						drawn = true;
					}
				}
				if (!drawn){
					System.out.print(Globals.maps.get(Globals.currentFloor).getTile(e,i).getSymbol());
				}
			}
			System.out.println();
		}
		//rework to use swing
	}
	
	public static void playerInfo(){
		for(int i = 0; i < Globals.FLOOR_SIZE; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println(Globals.player.getName());
		System.out.println(Globals.player.getHp() + "/" + Globals.player.getMaxhp() + "hp");
		System.out.println(Globals.message);
		System.out.print("Command: ");
		//rework to use swing
	}
}
