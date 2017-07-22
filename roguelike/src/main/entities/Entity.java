package main.entities;

import java.util.HashMap;

import main.attacks.Attack;
import main.attacks.EnumAttackType;
import main.attacks.ModifierChart;
import main.entities.ai.AI;
import main.util.EnumDirection;
import main.util.Globals;

public class Entity {
	protected Stats stats = null;
	protected AI ai = null;
	protected int hp = 0;
	protected int mp = 0;
	protected String name = "";
	protected int x;
	protected int y;
	protected String sprite = null;
	protected int spriteSheetRow = 0;
	protected int spriteSheetColumn = 0;
	protected boolean tangible = true;
	protected Attack basicAttack = null;
	protected ModifierChart modifiers = null;
	
	public Entity(String n, int px, int py){
		name = n;
		x = px;
		y = py;
		ai = new AI(5, 0, 2);
		basicAttack = new Attack (0, 3, 1, null);
		modifiers = new ModifierChart(new HashMap<EnumAttackType, Float>());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void changeX(int x) {
		this.x += x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void changeY(int y) {
		this.y += y;
	}
	
	public void setSprite(String sheet, int column, int row){
		sprite = sheet;
		spriteSheetRow = row;
		spriteSheetColumn = column;
	}
	
	public String getSprite() {
		return sprite + "&" + spriteSheetRow + "&" + spriteSheetColumn;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public Attack getMeleeAttack() {
		return basicAttack;
	}
	
	public boolean getTangible(){
		return tangible;
	}
	
	public void onAttack(Attack a) {
		hp -= modifiers.getModifiedDamage(a);
		if (hp < 0) {
			hp = 0;
			if (this != Globals.player)
				die();
		}
		//TODO animation stuff
	}
	
	private void die() {
		//TODO put stuff here
	}
	
	public void move(EnumDirection dir) {

		if (!(x + dir.getX() < 0 || x + dir.getX() >= Globals.currentFloor.getWidth())) { //check if x is within bounds of floor
			if (Globals.currentFloor.getTile(x + dir.getX(), y).isWall() && tangible){ //check if there is a wall in the way
				Globals.currentFloor.getTile(x, y).onAttack(getMeleeAttack()); //attack the wall
			}
			else{
				changeX(dir.getX()); //move only if there is no wall and is within bounds of floor
			}
		}
		
		if (!(y + dir.getY() < 0 || y + dir.getY() >= Globals.currentFloor.getHeight())) {
			if (Globals.currentFloor.getTile(x, y + dir.getY()).isWall() && tangible) {
				Globals.currentFloor.getTile(x, y).onAttack(getMeleeAttack());
			}
			else{
			changeY(dir.getY());
			}
		}
		
		Globals.currentFloor.getTile(x, y).onStep(this); 
	}

}
