package main.entities;

import java.util.Random;

public class Stats {
	/* buffness - physical damage, carry weight
	 * toughness - determines natural damage resistance
	 * wit - magical damage
	 * snark - magical resistance
	 * sexiness - npc relations, can be negative, maybe range from -100 to 100
	 * dexterity - disarm/notice/avoid traps, climb (?), ranged weapons, 
	 * smartness - max mp, AI, and something with rituals
	 * luck - average of all players is used, influences loot, maybe enemy difficulty (only bad luck influences)
	 * 
	 * tuf + dex => hp
	 * wit + snk => mp regen
	 * 
	 */
	
	private int innateHp = 0;
	private int innateMp = 0;
	private int innateBuf = 0;
	private int innateTuf = 0;
	private int innateWit = 0;
	private int innateSnk = 0;
	
	private int hp = 0; //Health points
	private int mp = 0; //Mana points
	private int buf = 0; //Buffness - physical damage and range
	private int tuf = 0; //Toughness - physical damage resistance
	private int wit = 0; //Wit - magic offense
	private int snk = 0; //Snark - magic defense
	
	private int level = 0;
	
	//Set stats specifically
	public Stats(int health, int mana, int buffness, int toughness, int wit, int snark, int level) {
		innateHp = health;
		innateMp = mana;
		innateBuf = buffness;
		innateTuf = toughness;
		innateWit = wit;
		innateSnk = snark;
		this.level = level;
		calculateStats();
	}
	
	//Set stats randomly, use this mostly
	public Stats(int magnitude, int level) {
		Random rand = new Random();
		innateHp = rand.nextInt(magnitude / 5);
		innateMp = rand.nextInt(magnitude / 5);
		innateBuf = rand.nextInt(magnitude / 5);
		innateTuf = rand.nextInt(magnitude / 5);
		innateWit = rand.nextInt(magnitude / 5);
		innateSnk = rand.nextInt(magnitude / 5);
		int total = innateHp + innateMp + innateBuf
				+ innateTuf + innateWit + innateSnk;
		int change = (magnitude - total) / 6;
		innateHp += change;
		innateMp += change;
		innateBuf += change;
		innateTuf += change;
		innateWit += change;
		innateSnk += change;
		this.level = level;
		calculateStats();
	}
	
	public void calculateStats() {
		setHp(10 + innateHp * (8 + 2 * level));
		setMp(10 + innateMp * (8 + 2 * level));
		setBuf(5 + innateBuf * level / 4);
		setTuf(5 + innateTuf * level / 4);
		setWit(5 + innateWit * level / 4);
		setSnk(5 + innateSnk * level / 4);
	}
	
	public void changeInnateStat(int stat, int amount) {
		switch (stat) {
			case 0:
				innateHp += amount;
				break;
			case 1:
				innateMp += amount;
				break;
			case 2:
				innateBuf += amount;
				break;
			case 3:
				innateTuf += amount;
				break;
			case 4:
				innateWit += amount;
				break;
			case 5:
				innateSnk += amount;
				break;
		}
		calculateStats();
	}
	
	public void setInnateStat(int stat, int amount) {
		switch (stat) {
			case 0:
				innateHp = amount;
				break;
			case 1:
				innateMp = amount;
				break;
			case 2:
				innateBuf = amount;
				break;
			case 3:
				innateTuf = amount;
				break;
			case 4:
				innateWit = amount;
				break;
			case 5:
				innateSnk = amount;
				break;
		}
		calculateStats();
	}
	
	public int getInnateStat(int stat) {
		switch (stat) {
			case 0:
				return innateHp;
			case 1:
				return innateMp;
			case 2:
				return innateBuf;
			case 3:
				return innateTuf;
			case 4:
				return innateWit;
			case 5:
				return innateSnk;
			default:
				return Integer.MIN_VALUE;
		}
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		level = this.level;
		calculateStats();
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

	public int getBuf() {
		return buf;
	}

	public void setBuf(int buf) {
		this.buf = buf;
	}

	public int getTuf() {
		return tuf;
	}

	public void setTuf(int tuf) {
		this.tuf = tuf;
	}

	public int getWit() {
		return wit;
	}

	public void setWit(int wit) {
		this.wit = wit;
	}

	public int getSnk() {
		return snk;
	}

	public void setSnk(int snk) {
		this.snk = snk;
	}

	public void average(Stats s) {
		hp += s.getHp();
		hp /= 2;
		mp += s.getMp();
		mp /= 2;
		buf += s.getBuf();
		buf /= 2;
		tuf += s.getTuf();
		tuf /= 2;
		wit += s.getWit();
		wit /= 2;
		snk += s.getSnk();
		snk /= 2;
		calculateStats();
	}
	
	public void averageInnate(Stats s) {
		for (int i = 0; i < 6; i++) {
			changeInnateStat(i,s.getInnateStat(i));
			setInnateStat(i,getInnateStat(i)/2);
		}
	}
	
}
