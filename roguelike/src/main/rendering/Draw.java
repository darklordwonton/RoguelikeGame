package main.rendering;

public class Draw {
	public static void drawEverything(){
		mapFloor();
		playerInfo();
	}
	
	public static void mapFloor(){
	/*	for (int i = 0; i < Globals.FLOOR_SIZE; i++){
			for (int e = 0; e < Globals.floorSize; e++){
				boolean drawn = false;
				for (int z = 0; z < Globals.currentCreatures; z++){
					if (Globals.entities[z].getX() == e && Globals.entities[z].getY() == i && !drawn){
						System.out.print(Globals.entities[z].getSymbol());
						drawn = true;
					}
				}
				if (!drawn){
					System.out.print(Globals.map[e][i].getSymbol());
				}
			}
			System.out.println();
		}*/
		//rework to use swing
	}
	
	public static void playerInfo(){
	/*	for(int i = 0; i < Globals.floorSize; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println(Globals.entities[0].getName());
		System.out.println(Globals.entities[0].getHp() + "/" + Globals.entities[0].getMaxhp() + "hp");
		System.out.println(Globals.message);
		System.out.print("Command: ");*/
		//rework to use swing
	}
}
