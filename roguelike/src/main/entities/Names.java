package main.entities;

public class Names {
	private static String[] firstSlime = {"Gl", "Bl", "Pl", "Ga", "Bal", "Blo"};
	private static String[] endSlime = {"oorp", "oop", "omp", "urup"};
	
	public static String slimeName(){
		int x = (int)(Math.random() * firstSlime.length);		
		int y = (int)(Math.random() * endSlime.length);
		return firstSlime[x] + endSlime[y];
			
	}
}
