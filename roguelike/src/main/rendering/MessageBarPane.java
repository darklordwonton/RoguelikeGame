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
	}

	public MessageBarPane(LayoutManager layout) {
		super(layout);
	}

	public MessageBarPane(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public MessageBarPane(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
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
		
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		
//		System.out.println(getX() + "+" + getWidth() + " ->" + MainRenderer.scaleX(MainRenderer.DEFAULT_WINDOW_WIDTH));
		
		if (messages.size() > 0) {
			g.setFont(new Font("Papyrus", 0, MainRenderer.scaleXY(MainRenderer.TILE_SIZE / 3)));
			g.setColor(Color.red);
			
			g.drawString(messages.get(0), 
					MainRenderer.scaleX(MainRenderer.TILE_SIZE / 10), 
					getHeight() - MainRenderer.scaleY(MainRenderer.TILE_SIZE / 3));
			
//			g.drawString(StringUtils.capitalize(messages.get(0)), 
//					MainRenderer.scaleX(MainRenderer.TILE_SIZE / 10), 
//					MainRenderer.scaleY(MainRenderer.TILE_SIZE));
			
//			for(int messageNum = 0; messageNum < messages.size(); messageNum++){
//				g.drawString(StringUtils.capitalize(messages.get(messages.size() - messageNum - 1)),  
//						MainRenderer.scaleX(MainRenderer.TILE_SIZE / 10), 
//						getHeight() - (messageNum * MainRenderer.scaleY(MainRenderer.TILE_SIZE * 2 / 3)));
//			}
//			TODO keep old messages one line above
//			TODO actions you make are not printed
		}
	}

}
