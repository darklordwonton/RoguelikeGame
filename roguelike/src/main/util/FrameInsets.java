package main.util;

import javax.swing.JFrame;

public class FrameInsets extends JFrame{
	
	
	
	public static int get(JFrame frame, String dir){
		String insetString = frame.getInsets().toString();
		int[] insets = new int[4];
		
		insets[0] = Integer.parseInt(insetString.substring(insetString.indexOf("top=") + 4, insetString.indexOf(',')));
		insetString = insetString.substring(insetString.indexOf(',') + 1);
		
		insets[1] = Integer.parseInt(insetString.substring(insetString.indexOf("left=") + 5, insetString.indexOf(',')));
		insetString = insetString.substring(insetString.indexOf(',') + 1);
		
		insets[2] = Integer.parseInt(insetString.substring(insetString.indexOf("bottom=") + 7, insetString.indexOf(',')));
		insetString = insetString.substring(insetString.indexOf(",right=") + 7);
		
		insets[3] = insetString.charAt(0)- '0';
		
		if (dir.equals("top"))
			return insets[0];
		else if (dir.equals("left"))
			return insets[1];
		else if (dir.equals("bottom"))
			return insets[2];
		else if (dir.equals("right"))
			return insets[3];
		else if (dir.equals("sides"))
			return insets[1] + insets[3];
		else if (dir.equals("long"))
			return insets[0] + insets[2];
		else
			return -1;
	}
	
}
