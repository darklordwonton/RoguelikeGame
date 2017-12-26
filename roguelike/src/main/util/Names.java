package main.util;

public class Names {
	private static String[] prefix = {"Li'l ", "Big ", "N'"};
	
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "Shl", "Lol", "Sphl"};  //Goopy sounds
	private static String[] firstHard = {"Shr", "Gr", "Kr", "K", "G", "Br"};		//Harsh names	
	private static String[] firstPrim = {"Ch", "Kr", "Gr", "N'd", "Big Kr", "Li'l B"};	//Primitive names
	private static String[] firstMat = {"M", "S", "St", "W", "Ir", "Br", "C", "Sil", "Anth", "R", "Ur", "P", "N", "Th", "T", "Ith"}; //Material names
	
	private static String[] endSlime = {"rp", "p", "mp", "k", "lp", "h", "pe", "b", "bby", "rb", "mb", "mpy", "mby"};
	private static String[] endPrim = {"h", "k", "r", "rk", "rh", "w", "ch"};
	private static String[] endHard = {"k", "nk", "nt", "t", "ck", "m", "sh", "g"};
	private static String[] endMat = {"t", "th", "thr", "m", "st", "d", "ral", "ril", "n", "l", "ll", "lf", "dun", "san", "ln", "r", "p", "lt", "b", "sten", "g"};
	
	
	private static String[] vowels = {"a", "e", "i", "o", "u"};
	private static String[] vowel1 = {"a", "e", "o", "u"};
	private static String[] vowel2 = {"a", "e", "o"};
	private static String[] slimeVowels = {"o", "oo", "ooo", "u", "uu", "ou", "olo", ""};
	private static String[] matVowels = {"i", "y", "u", "o", "oe", "eo", "ee", "e", "a", "ar", "ra"};
	
	private static String[] jobDescriptors = {"Holy", "Blood", "Destrution", "Sword", "Witch", "Magic", "Doomsday", "Apocalypse", "Stealthy", "Axe", "Chaos"};
	private static String[] fightJobNames = {"fighter", "rager", "soldier", "warrior", "devastator"};
	private static String[] mageJobNames = {"mage", "wiazard", "sorcerer", "caster", "magic dude", "wizardly boi", "Potter"};
	private static String[] sneakJobNames = {"rogue", "sneak", "assassin", "stealth", "sneaky boi", "hideyman"};
			
	public static String slimeName() {
		int a = (int)(Math.random() * firstSlime.length);		
		int b = (int)(Math.random() * slimeVowels.length);
		int c = (int)(Math.random() * endSlime.length);
		return StringUtils.capitalize(firstSlime[a] + slimeVowels[b]+ endSlime[c]);
	}
	
	public static String gobName(){
		//int a = (int)(Math.random() * prefix.length);
		int b = (int)(Math.random() * firstPrim.length);		
		int c = (int)(Math.random() * vowels.length);
		int d = (int)(Math.random() * endPrim.length);
		int e = (int)(Math.random() * vowel1.length);
		int f = (int)(Math.random() * endPrim.length);
		return firstPrim[b] + vowels[c]+ endPrim[d] + vowel1[e] + endPrim[f];
	}
	
	public static String ogreName() {
		int a = (int)(Math.random() * firstHard.length);		
		int b = (int)(Math.random() * vowel1.length);
		int c = (int)(Math.random() * endHard.length);
		return firstHard[a] + vowel1[b]+ endHard[c];
	}

	public static String materialName(){
		int syl = 1 + (int)(Math.random() * 1.85);
		String ret = firstMat[(int)(Math.random() * firstMat.length)];
		for (int i = 0; i < syl; i++) {
			ret += matVowels[(int)(Math.random() * matVowels.length)];
			ret += endMat[(int)(Math.random() * endMat.length)];
		}
		if (Math.random() < 0.44) {
			ret += "ium";
		}
		if (Math.random() < 0.2) {
			ret += "ite";
		}
		return ret;
	}
	
	public static String fighterName() {
		return jobDescriptors[(int)(Math.random() * jobDescriptors.length)] + " " + fightJobNames[(int)(Math.random() * fightJobNames.length)];
	}
	public static String mageName() {
		return jobDescriptors[(int)(Math.random() * jobDescriptors.length)] + " " + mageJobNames[(int)(Math.random() * mageJobNames.length)];
	}
	public static String sneakName() {
		return jobDescriptors[(int)(Math.random() * jobDescriptors.length)] + " " + sneakJobNames[(int)(Math.random() * sneakJobNames.length)];
	}
}
