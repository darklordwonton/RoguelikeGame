package main.theme;

public class Theme { //Abandoning this project for now. Unsure how to generate next themes
	protected String floorSpriteSheet = "";
	protected int tileSpriteSheetLength = 0;
	protected String wallSprite = "";
	protected String emptySprite = "";
	protected String breakableSprite = "";
	protected String bgColours = "";
	protected Theme[] nextThemes = null;
	
	public Theme() {
		floorSpriteSheet = "";
		tileSpriteSheetLength = 0;
		wallSprite = "";
		emptySprite = "";
		breakableSprite = "";
		bgColours = "";
		nextThemes = null;
	}
	
	public Theme(String f, int l, String w, String e, String b, String s){
		floorSpriteSheet = f;
		tileSpriteSheetLength = l;
		wallSprite = w;
		emptySprite = e;
		breakableSprite = b;
		bgColours = s;
	}
	
	public String getFloorSpriteSheet(){
		return floorSpriteSheet;
	}

}
