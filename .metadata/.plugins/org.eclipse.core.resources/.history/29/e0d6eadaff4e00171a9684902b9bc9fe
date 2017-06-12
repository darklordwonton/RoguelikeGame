package main.entities;

import main.util.EnumDirection;
import main.util.Globals;

public class Entity {
	private int maxhp = 0;
	private int hp = 0;
	private String name = "";
	private int x;
	private int y;
	protected String sprite = null;
	
	public Entity(){
		setMaxhp(0);
		setHp(0);
		setName("");
		setX(0);
		setY(0);
	}
	
	public Entity(String n, int h, int px, int py){
		setName(n);
		setMaxhp(h);
		setHp(h);
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

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
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
	
	public void move(EnumDirection dir) {
		changeX(dir.getX());
		if (Globals.maps.get(Globals.currentFloor).getTile(x, y).isWall()) {
			changeX(-dir.getX());
		}
		changeY(dir.getY());
		if (Globals.maps.get(Globals.currentFloor).getTile(x, y).isWall()) {
			changeY(-dir.getY());
		}
	}
}
