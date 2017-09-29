package main.entities;

public class Names {
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "'L", "Shl", "Lol", "Sphl"};
	private static String[] middleSlime = {"o", "oo", "ooo", "u", "uu", "ou", "olo"};
	private static String[] endSlime = {"rp", "p", "mp", "k", "lp", "lol", "h", "pe", "b", "bby", "rb", "mb", "mpy", "mby"};
	
	private static String[] firstGob = {"Ch", "Kr", "Gr", "N'd", "Big Kr", "Li'l B"};
	private static String[] middleGob = {"a", "o", "aka", "aha"};
	private static String[] endGob = {"h", "k", "r", "rk"};
	
	private static String[] firstOgre = {"Shr", "Gr", "Kr", "K"};
	private static String[] middleOgre = {"e", "a", "o", "u"};
	private static String[] endOgre = {"k", "nk", "nt", "t", "ck"};
	
	
	public static String slimeName() {
		int a = (int)(Math.random() * firstSlime.length);		
		int b = (int)(Math.random() * middleSlime.length);
		int c = (int)(Math.random() * endSlime.length);
		return firstSlime[a] + middleSlime[b]+ endSlime[c];
	}
	
	public static String gobName(){
		int a = (int)(Math.random() * firstGob.length);		
		int b = (int)(Math.random() * middleGob.length);
		int c = (int)(Math.random() * endGob.length);
		int d = (int)(Math.random() * middleGob.length);
		int e = (int)(Math.random() * endGob.length);
		return firstGob[a] + middleGob[b]+ endGob[c] + middleGob[d] + endGob[e];
	}
	
	public static String ogreName() {
		int a = (int)(Math.random() * firstOgre.length);		
		int b = (int)(Math.random() * middleOgre.length);
		int c = (int)(Math.random() * endOgre.length);
		return firstOgre[a] + middleOgre[b]+ endOgre[c];
	}
}
