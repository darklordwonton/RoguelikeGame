package main.entities;

import java.util.HashSet;

import main.attacks.Attack;
import main.attacks.EnumAttackType;
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
	
	public Entity(String n, int px, int py){
		name = n;
		x = px;
		y = py;
		ai = new AI(5, 0, 2);
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

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
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
	
	public void setSprite(String sheet, int row, int column){
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
		return new Attack(stats.getBuf(), new HashSet<EnumAttackType>());
	}
	
	public void move(EnumDirection dir) {
		if (!(x + dir.getX() < 0 || x + dir.getX() >= Globals.currentFloor.getWidth())) {
			changeX(dir.getX());
		}
		if (Globals.currentFloor.getTile(x, y).isWall()) {
			Globals.currentFloor.getTile(x, y).onAttack(getMeleeAttack());
			changeX(-dir.getX());
		}
		if (!(y + dir.getY() < 0 || y + dir.getY() >= Globals.currentFloor.getHeight())) {
			changeY(dir.getY());
		}
		if (Globals.currentFloor.getTile(x, y).isWall()) {
			Globals.currentFloor.getTile(x, y).onAttack(getMeleeAttack());
			changeY(-dir.getY());
		}
		Globals.currentFloor.getTile(x, y).onStep(this);
	}
}
