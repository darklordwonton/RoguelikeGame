package main.rendering;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.util.StringUtils;

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
		messages.add(StringUtils.capitalize(m));
	}
	
	public void incrementMessage () {
		if (messages.size() > 0)
			messages.remove(0);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,MainRenderer.scaleX(MainRenderer.DEFAULT_WINDOW_WIDTH), MainRenderer.scaleY(80));
		if (messages.size() > 0) {
			g.setFont(new Font("Papyrus", 0, MainRenderer.scaleXY(25)));
			g.setColor(Color.WHITE);
			g.drawString(messages.get(0), MainRenderer.scaleX(5), MainRenderer.scaleY(40));
		}
	}

}
