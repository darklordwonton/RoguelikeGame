package main.entities.monsters;

import main.entities.Entity;
import main.entities.Stats;
import main.util.Globals;

public abstract class EntityMonster extends Entity {

	protected Stats ideal;
	
	public EntityMonster(String n, int px, int py) {
		super(n, px, py);
		// TODO Auto-generated constructor stub
	}
	
	protected void makeStats(int magnitude) {
		stats = new Stats(magnitude, Globals.floorNumber);
		stats.averageInnate(ideal);
		hp = stats.getHp();
		mp = stats.getMp();
	}

}
