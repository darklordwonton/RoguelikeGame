package main.items;

import main.util.Names;

public class Material {
	String name = "";
	int hardness = -1; //effectiveness as armor
	int sharpness = -1; //effectiveness as weapon
	
	public Material() {
		name = Names.materialName();
	}

}
