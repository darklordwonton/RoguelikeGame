package main.magic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import main.attacks.Attack;
import main.attacks.EnumAttackType;
import main.entities.Entity;
import main.util.EnumDirection;
import main.util.Globals;

public class Spell {
	Attack attack = null;
	String name = "";
	int value = 0;
	int manaCost = 0;
	
	EnumDirection d = null;
	Entity entity = null;
	
	public Spell(){
		attack = null;
		entity = null;
		name = "";
		manaCost = 0;
		
		value = 0;
	}
	
	public Spell(Attack a, String n, Entity e, int m){
		attack = a;
		name = n;
		entity = e;
		manaCost = m;
		
		value = 0;
	}

	public void generateSpell(int v){ //This will eventually randomly generate a spell of a given value. Until then, this is default.
		value = v;
		
		attack = new Attack(100, 1000, 1, new HashSet<EnumAttackType>(), entity);
		attack.addType(EnumAttackType.FIRE);
	}
	
	public void setDirection(EnumDirection de){
		d = de;
	}
	
	public List<int[]> squaresTargeted(int x, int y, EnumDirection d){
		List<int[]> hits = new ArrayList<int[]>();
		boolean stopped= false;
		
		while (x + d.getX() >= 0 && x + d.getX() < Globals.currentFloor.getWidth() &&
			   y + d.getY() >= 0 && y + d.getY() < Globals.currentFloor.getHeight() &&
			   !stopped){
			x += d.getX();
			y += d.getY();
			int[] temp = new int[2];
			temp [0] = x;
			temp [1] = y;
			hits.add(temp);
			if (Globals.currentFloor.getTile(x, y).isWall()){
				stopped = true;
			}
			if (Globals.currentFloor.getTile(x, y).getResidentEntity() != null){
				stopped = true;
			}
		}
		
		return hits;
	}

	public void cast (){
		List<int[]> l = squaresTargeted(entity.getX(), entity.getY(), EnumDirection.LEFT);
		for (int i = 0; i < l.size(); i++){
			Globals.currentFloor.getTile(l.get(i)[0], l.get(i)[1]).getResidentEntity().onAttack(attack);
		}
	}
}
