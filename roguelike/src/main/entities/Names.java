package main.entities;

import main.util.StringUtils;

public class Names {
	private static String[] prefix = {"Li'l ", "Big ", "N'"};
	
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "Shl", "Lol", "Sphl"};  //Goopy sounds
	private static String[] firstHard = {"Shr", "Gr", "Kr", "K", "G", "Br"};		//Harsh names	
	private static String[] firstPrim = {"Ch", "Kr", "Gr", "N'd", "Big Kr", "Li'l B"};	//Primitive names
	private static String[] firstMat = {"M", "S", "St", "W", "I", "Br", "C", "Sil"}; //Material names
	
	private static String[] endSlime = {"rp", "p", "mp", "k", "lp", "h", "pe", "b", "bby", "rb", "mb", "mpy", "mby"};
	private static String[] endPrim = {"h", "k", "r", "rk", "rh", "w", "ch"};
	private static String[] endHard = {"k", "nk", "nt", "t", "ck", "m", "sh", "g"};
	private static String[] endMat = {"d", "ral", "ril", "il", "n", "l", "dun", "san", "mon", "oln"};
	
	
	
	private static String[] vowels = {"a", "e", "i", "o", "u"};
	private static String[] vowel1 = {"a", "e", "o", "u"};
	private static String[] vowel2 = {"a", "e", "o"};
	private static String[] slimeVowels = {"o", "oo", "ooo", "u", "uu", "ou", "olo", ""};
	private static String[] matVowels = {"ith", "yth", "ic", "ron", "on", "ee", "e", "o", "mar"};
	
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
		int rand = (int)(Math.random() * 5);
		String ret = "";
		switch(rand){
		case 0: ret = firstMat[(int)(Math.random() * firstMat.length)];
				ret += matVowels[(int)(Math.random() * matVowels.length)];
				break;
		case 1: ret = firstMat[(int)(Math.random() * firstMat.length)];
				ret += matVowels[(int)(Math.random() * matVowels.length)];
				ret += endMat[(int)(Math.random() * endMat.length)];
				break;		
				
		case 2: ret = firstMat[(int)(Math.random() * firstMat.length)];
			    ret += matVowels[(int)(Math.random() * matVowels.length)];
			    ret += matVowels[(int)(Math.random() * matVowels.length)];
			    ret += endMat[(int)(Math.random() * endMat.length)];
			    break;		
			    
		case 3: ret = firstMat[(int)(Math.random() * firstMat.length)];
				ret += endMat[(int)(Math.random() * endMat.length)];
				break;	
				
		case 4: ret = firstMat[(int)(Math.random() * firstMat.length)];
				ret += matVowels[(int)(Math.random() * matVowels.length)];	
				ret += endMat[(int)(Math.random() * endMat.length)];
			    ret += matVowels[(int)(Math.random() * matVowels.length)];
			    ret += endMat[(int)(Math.random() * endMat.length)];
				break;		
				
		}
		return ret;
	}
}
