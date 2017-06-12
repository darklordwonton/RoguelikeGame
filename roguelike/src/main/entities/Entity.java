package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class Entity {
	protected Stats stats = null;
	protected int hp = 0;
	protected int mp = 0;
	protected String name = "";
	protected int x;
	protected int y;
	protected String sprite = null;
	
	public Entity(String n, int px, int py){
		setName(n);
		setX(px);
		setY(py);
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

	public String getSprite() {
		return sprite;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public void move(EnumDirection dir) {
		changeX(dir.getX());
		if (Globals.currentFloor.getTile(x, y).isWall()) {
			changeX(-dir.getX());
		}
		changeY(dir.getY());
		if (Globals.currentFloor.getTile(x, y).isWall()) {
			changeY(-dir.getY());
		}
	}
}
