package main.entities;

public class Names {
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "Gl", "Blo", "'L", "Shl", "Lol"};
	private static String[] middleSlime = {"o", "oo", "ooo", "oooo", "a", "aa", "ao", "oa", "u", "ou", "uo", "olo", "uo"};
	private static String[] endSlime = {"rp", "p", "mp", "p", "k", "lp", "lol", "h"};
	
	private static String[] firstGob = {"Ch", "Kr"};
	private static String[] middleGob = {"a"};
	private static String[] endGob = {"h", "k"};
	
	
	public static String slimeName() {
		int x = (int)(Math.random() * firstSlime.length);		
		int y = (int)(Math.random() * middleSlime.length);
		int z = (int)(Math.random() * endSlime.length);
		return firstSlime[x] + middleSlime[y]+ endSlime[z];
	}
	
	public static String gobName(){
		int x = (int)(Math.random() * firstGob.length);		
		int y = (int)(Math.random() * middleGob.length);
		int z = (int)(Math.random() * endGob.length);
		return firstGob[x] + middleGob[y]+ endGob[z];
	}
	
}
