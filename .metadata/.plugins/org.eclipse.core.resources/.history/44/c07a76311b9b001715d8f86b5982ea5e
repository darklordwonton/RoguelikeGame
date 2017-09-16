package main.entities.ai;

import main.entities.Entity;
import main.util.EnumDirection;
import main.util.Globals;

public class AI {
	private static int anger = 0;
	private static int bravery = 0;
	private static int inte = 0;
	private static Entity entity = null;
	private static int targetX = -1;
	private static int targetY = -1;
	
	public AI(int a, int b, int i){
		anger = a;
		bravery = b;
		inte = i;
		targetX = -1;
		targetY = -1;
	}
	
	public char turn (){
		char action = ' ';
		switch(inte){
		case 0: action = stupidMove();
			break;
		}
		
		
		return action;
	}

	public char stupidMove(){
		int ownX = entity.getX();
		int ownY = entity.getY();
		boolean moved = false;
		char move = ' ';
		
		if (Math.random() > .5 && targetX != -1 && targetY != -1){
			if (targetX > ownX && !moved){
				move = Globals.RIGHT_KEY;
				moved = true;
			}else if (targetX < ownX && !moved){
				move = Globals.LEFT_KEY;
				moved = true;
			}
			if (targetY > ownY && !moved){
				move = Globals.UP_KEY;
				moved = true;
			}else if (targetY > ownY && !moved){
				move = Globals.DOWN_KEY;
				moved = true;
			}
		}else if (targetX != -1 && targetY != -1){
			if (targetY > ownY && !moved){
				move = Globals.UP_KEY;
				moved = true;
			}else if (targetY > ownY && !moved){
				move = Globals.DOWN_KEY;
				moved = true;
			}	
			if (targetX > ownX && !moved){
				move = Globals.RIGHT_KEY;
				moved = true;
			}else if (targetX < ownX && !moved){
				move = Globals.LEFT_KEY;
				moved = true;
			}
		}else {
			switch((int)(Math.random() * 4)){
			case 0: move = Globals.DOWN_KEY;
			  break;
					  
			case 1: move = Globals.RIGHT_KEY;
			  break;
			  
			case 2: move = Globals.LEFT_KEY;
			  break;
			  
			case 3: move = Globals.UP_KEY;
			  break;
			  
			}
		}
		return move;
	}

}
