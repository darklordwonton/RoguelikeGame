package main.entities;

import java.util.HashMap;
import java.util.HashSet;

import main.effects.attacks.*;
import main.entities.ai.AI;
import main.magic.Spell;
import main.rendering.MainRenderer;
import main.util.EnumDirection;
import main.util.Globals;

public class Entity {
	protected Stats stats = null;
	protected AI ai = null;
	protected int hp = 0;
	protected int mp = 0;
	protected String name = "error";
	protected String species = "";
	protected String pronoun = "";
	protected int x;
	protected int y;
	protected String sprite = null;
	protected int spriteSheetRow;
	protected int spriteSheetColumn;
	protected int totalFrames;
	protected boolean tangible = true;
	protected Attack basicAttack = null;
	protected ModifierChart modifiers = null;
	protected int xpValue = Integer.MAX_VALUE;
	protected int turns = 0;
	protected int maxTurns = 1;
	protected boolean dead = false;
	protected Spell spell = null;
	
	public Entity(int sx, int sy){
		turns = maxTurns;
		x = sx;
		y = sy;
		ai = new AI(5, 0, 0, this);
		basicAttack = new Attack (0, 3, 1, new HashSet<EnumAttackType>(), this);
		modifiers = new ModifierChart(new HashMap<EnumAttackType, Float>());
	}
	
	public Spell getSpell(){
		return spell;
	}
	
	public void turn() {
		ai.turn();
	}
	
	public void setMaxTurns(int t) {
		maxTurns = t;
		turns = maxTurns;
	}
	
	public int getMaxTurns() {
		return maxTurns;
	}
	
	public void incrementTurns() {
		turns--;
	}
	
	public boolean hasTurns() {
		return turns > 0;
	}
	
	public void resetTurns() {
		turns = maxTurns;
	}
	
	public int getTurns() {
		return turns;
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
	
	public void setSprite(String sheet, int column, int row, int numFrames){
		sprite = sheet;
		spriteSheetRow = row;
		spriteSheetColumn = column;
		totalFrames = numFrames;
	}
	
	public String getSprite() {
		return sprite;
	}
	
	public int getSpriteX(){
		return spriteSheetColumn;
	}
	
	public int getSpriteY(){
		return spriteSheetRow;
	}
	
	public int getTotalFrames(){
		return totalFrames;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public boolean getDead(){
		return dead;
	}
	
	public String getSpecies(){
		return species;
	}
	
	public Attack getMeleeAttack() {
		basicAttack.setBuf(this.stats.getBuf());
		return basicAttack;
	}
	
	public boolean getTangible(){
		return tangible;
	}
	
	public String getPronoun(){
		return pronoun;
	}
	
	public void onAttack(Attack a) {
		int damage = Math.max(modifiers.getModifiedDamage(a), 1);
		MainRenderer.addMessage(a.getOrigin().getName() + " hit " + getName() + " for " + damage + " damage!");
		hp -= damage;
		if (hp < 0) {
			hp = 0;
			if (this != Globals.player){
				die();
				if (a.getOrigin().equals(Globals.player)){
					Globals.player.gainXp(this.xpValue);
				}
			}
		}
		//TODO animation stuff
	}
	
	private void die() {
		Globals.currentFloor.getTile(x, y).onLeave(this);
		dead = true;
		MainRenderer.addMessage(name + " died");
		if (this.getSpecies().equals("Player")){
			while(true){
				MainRenderer.addMessage("u ded");
			}
		}
		//Will eventually need overhaul. Works for now
	}
	
	public void move(EnumDirection dir) {
		Globals.currentFloor.getTile(x, y).onLeave(this);
		int oldX = x;
		int oldY = y;
						
		if (!(x + dir.getX() < 0 || x + dir.getX() >= Globals.currentFloor.getWidth())) { //check if x is within bounds of floor
			if (Globals.currentFloor.getTile(x + dir.getX(), y).isWall() && tangible) { //check if there is a wall in the way
				Globals.currentFloor.getTile(x + dir.getX(), y).onAttack(getMeleeAttack()); //attack the wall
			}
			else {
				changeX(dir.getX()); //move only if there is no wall and is within bounds of floor
			}
		}
		
		if (!(y + dir.getY() < 0 || y + dir.getY() >= Globals.currentFloor.getHeight())) {
			if (Globals.currentFloor.getTile(x, y + dir.getY()).isWall() && tangible) {
				Globals.currentFloor.getTile(x, y + dir.getY()).onAttack(getMeleeAttack());
			}
			else {
				changeY(dir.getY());
			}
		}
		
		if (Globals.currentFloor.getTile(x, y).getResidentEntity() != null) {
			Globals.currentFloor.getTile(x, y).getResidentEntity().onAttack(getMeleeAttack());
			setX(oldX);
			setY(oldY);
		}
		Globals.currentFloor.getTile(x, y).onStep(this);
	}
}
