package main.entities;

public class Names {
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "'L", "Shl", "Lol"};
	private static String[] middleSlime = {"o", "oo", "ooo", "oooo", "u", "uu", "uuu", "ou", "olo"};
	private static String[] endSlime = {"rp", "p", "mp", "k", "lp", "lol", "h", "pe", "b", "bby", "rb", "mb", "mpy", "mby"};
	
	private static String[] firstGob = {"Ch", "Kr", "Gr", "N'd"};
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
