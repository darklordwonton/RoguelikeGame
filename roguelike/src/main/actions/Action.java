package main.actions;

import main.entities.Entity;
import main.util.EnumDirection;
import main.util.Globals;

public class Action {
	
	public static void command(int action, Entity e){
		switch(action){
		case Globals.UP_KEY: e.move(EnumDirection.UP);
		  break;
				  
		case Globals.RIGHT_KEY: e.move(EnumDirection.RIGHT);
		  break;
		  
		case Globals.DOWN_KEY: e.move(EnumDirection.DOWN);
		  break;
		  
		case Globals.LEFT_KEY: e.move(EnumDirection.LEFT);
		  break;
		  
		}
	}
	
	//Replacing this with a method in the entity class
	/*public static void move (int identifier, int direction){
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
	}*/
}
