package main.mobs;

import main.entities.Stats;
import main.util.Globals;
import main.entities.ai.*;

public class Goblin {
	int statDeviation = (int) Math.round(Math.random() * 2 * -1);
	
	
	
	
	
	Goblin(){
		Stats stats = new Stats(Globals.midStat + statDeviation, 
								Globals.lowStat + statDeviation, 
								Globals.midStat + statDeviation, 
								Globals.midStat + statDeviation,
								Globals.midStat + statDeviation,
								Globals.midStat + statDeviation,
								Globals.currentFloor);
								
		
	}
	
	public void move(){
		
	}
	
	public void Attack(){
		
	}
}
