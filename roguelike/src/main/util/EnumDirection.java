package main.util;

public enum EnumDirection {
	LEFT, RIGHT, UP, DOWN;
	
	public int getX() {
		switch(this) {
			case LEFT:
				return -1;
			case RIGHT:
				return 1;
			default:
				return 0;
		}
	}
	
	public int getY() {
		switch(this) {
			case DOWN:
				return -1;
			case UP:
				return 1;
			default:
				return 0;
		}
	}
}
