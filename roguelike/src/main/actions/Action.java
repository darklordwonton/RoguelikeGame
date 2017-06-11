package main.actions;

import main.util.Globals;

public class Action {
	public static void command(char action, int identifier){
		switch(action){
		case '^': move(identifier, 8);
		  break;
				  
		case '>': move(identifier, 6);
		  break;
		  
		case 'v': move(identifier, 2);
		  break;
		  
		case '<': move(identifier, 4);
		  break;
		  
		}
	}
	
	public static void move (int identifier, int direction){
		int targX = Globals.entities[identifier].getX();
		int targY = Globals.entities[identifier].getY();
		boolean moves = true;
		
		if(direction == 8 || direction == 2){
			direction = (5 - direction) / 3;
			targY = Globals.entities[identifier].getY() + direction;		
		}else if(direction == 4 || direction == 6){
			direction = -5 + direction;
			targX = Globals.entities[identifier].getX() + direction;
		}
		
		if (targX >= Globals.FLOOR_SIZE || targY >= Globals.FLOOR_SIZE){
			moves = false;
			if (identifier == 0){
				Globals.message = "Off map";
			}
		}
		if (targX < 0 || targY < 0){
			moves = false;			
			if (identifier == 0){
				Globals.message = "Off map";
			}
		}
		if (moves){
			moves = !Globals.map[targX][targY].isWall();
			if (identifier == 0){
				Globals.message = "Wall";
			}
		}
					
		if (moves){
			Globals.entities[identifier].setX(targX);
			Globals.entities[identifier].setY(targY);
			if (identifier == 0){
				Globals.message = "All clear";
			}
		}
	}
}
