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
	
	public AI(int a, int b, int i, Entity e){
		anger = a;
		bravery = b;
		inte = i;
		entity = e;
		targetX = -1;
		targetY = -1;
	}
	
	public static char turn (){
		char action = ' ';
		switch(inte){
		case 0: action = stupidMove();
			break;
		}
		
		
		return action;
	}

	public static char stupidMove(){
		int ownX = entity.getX();
		int ownY = entity.getY();
		boolean moved = false;
		char move = ' ';
		
		if (Math.random() > .5 && targetX != -1 && targetY != -1){
			if (targetX > ownX && !moved){
				move = '>';
				moved = true;
			}else if (targetX < ownX && !moved){
				move = '<';
				moved = true;
			}
			if (targetY > ownY && !moved){
				move = '^';
				moved = true;
			}else if (targetY > ownY && !moved){
				move = 'v';
				moved = true;
			}
		}else if (targetX != -1 && targetY != -1){
			if (targetY > ownY && !moved){
				move = '^';
				moved = true;
			}else if (targetY > ownY && !moved){
				move = 'v';
				moved = true;
			}	
			if (targetX > ownX && !moved){
				move = '>';
				moved = true;
			}else if (targetX < ownX && !moved){
				move = '<';
				moved = true;
			}
		}else {
			switch((int)(Math.random() * 4)){
			case 0: move = 'v';
			  break;
					  
			case 1: move = '>';
			  break;
			  
			case 2: move = '<';
			  break;
			  
			case 3: move = '^';
			  break;
			  
			}
		}
		return move;
	}

}
