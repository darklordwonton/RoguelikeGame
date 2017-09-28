package main.util;

import main.rendering.MainRenderer;

public class StringUtils {

	public static String capitalize (String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1);	
	}

	public static String repeat (char c, int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += c;
		}
		return s;
	}
	
	
}
