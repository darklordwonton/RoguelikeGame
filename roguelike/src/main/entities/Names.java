package main.entities;

public class Names {
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "'L", "Shl", "Lol"};
	private static String[] middleSlime = {"o", "oo", "ooo", "u", "uu", "ou", "olo"};
	private static String[] endSlime = {"rp", "p", "mp", "k", "lp", "lol", "h", "pe", "b", "bby", "rb", "mb", "mpy", "mby"};
	
	private static String[] firstGob = {"Ch", "Kr", "Gr", "N'd", "Big Kr"};
	private static String[] middleGob = {"a", "o"};
	private static String[] endGob = {"h", "k", "r"};
	
	private static String[] firstOgre = {"Shr", "Gr", "Kr", "K"};
	private static String[] middleOgre = {"e", "a", "o", "u"};
	private static String[] endOgre = {"k", "nk", "nt", "t"};
	
	
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
	
	public static String ogreName() {
		int x = (int)(Math.random() * firstOgre.length);		
		int y = (int)(Math.random() * middleOgre.length);
		int z = (int)(Math.random() * endOgre.length);
		return firstOgre[x] + middleOgre[y]+ endOgre[z];
	}
}
