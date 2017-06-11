package main.entities.ai;

public class AI {
	public static char Creature(int identifier){
		char command = 'v';
		int option = (int)(Math.random() * 4);
		switch(option){
			case 0: command = '^';
			break;
				  
			case 1: command = '>';
			break;
		  
			case 2: command = '<';
			break;
		  
			case 3: command = 'v';
			break;
		}
		

		return command;
	}
}
