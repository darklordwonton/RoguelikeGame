package main.entities;

public class Entity {
	private int maxhp = 0;
	private int hp = 0;
	private String name = "";
	private int x;
	private int y;
	private char symbol = ';';
	
	public Entity(){
		setMaxhp(0);
		setHp(0);
		setName("");
		setX(0);
		setY(0);
		setSymbol(' ');
	}
	
	public Entity(String n, int h, int px, int py, char s){
		setName(n);
		setMaxhp(h);
		setHp(h);
		setX(px);
		setY(py);
		setSymbol(s);
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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
