package main;

import main.util.Initializer;
import main.util.Names;

public class Main {
		
	public static void main(String [] args){
		for (int i = 0; i < 100; i++){
			System.out.println(Names.materialName());
		}
		
		Initializer.start();
	}
}
