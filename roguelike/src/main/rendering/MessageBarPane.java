package main.rendering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MessageBarPane extends JPanel {

	private List<String> messages = new ArrayList<String>();
	
	public MessageBarPane() {
		// TODO Auto-generated constructor stub
	}

	public MessageBarPane(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public MessageBarPane(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MessageBarPane(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void addMessage (String m){
		messages.add(m);
	}
	
	public void incrementMessage () {
		if (messages.size() == 0)
			messages.remove(0);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		if (messages.get(0) != null) {
			g.setFont(new Font("Papyrus", 0, 25));
			g.drawString(messages.get(0), 5, 5);
		}
	}

}
