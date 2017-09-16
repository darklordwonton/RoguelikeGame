package main.entities.ai;

import main.entities.Entity;
import main.util.EnumDirection;
import main.util.Globals;

public class AI {
	private static int anger = 0;
	private static int bravery = 0;
	private static int inte = 0;
	private static Entity entity = null;
	
	public AI(int a, int b, int i){
		anger = a;
		bravery = b;
		inte = i;
	}
	
	//Anything the monster does will be in this method
	public void turn (){
		char action = ' ';
		switch(inte){
		case 0: stupidMove();
			break;
		}
		
	}

	//Temporary method to show how to do monster actions
	public void stupidMove() {
		int rand = (int)Math.random() * 4;
		switch(rand) {
			case 0 :
				entity.move(EnumDirection.RIGHT);
				break;
			case 1 :
				entity.move(EnumDirection.DOWN);
				break;
			case 2 :
				entity.move(EnumDirection.UP);
				break;
			case 3 :
				entity.move(EnumDirection.LEFT);
				break;
		}
	}

}
