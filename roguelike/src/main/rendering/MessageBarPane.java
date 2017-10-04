package main.rendering;

import java.awt.Color;
import java.awt.Dimension;
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

	public String getMessage(int num){
		return messages.get(num);
	}
	
	public int getMessageAmount(){
		return messages.size();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (getMessageAmount() > 0) {
			g.setFont(new Font("Papyrus", 0, MainRenderer.scaleXY(MainRenderer.TILE_SIZE / 3)));
			g.setColor(Color.WHITE);
			
			for(int messageNum = 0; messageNum < 13 && messageNum < getMessageAmount(); messageNum++){
				g.drawString(StringUtils.capitalize(getMessage(messageNum)),  
						MainRenderer.scaleX(MainRenderer.TILE_SIZE / 10), 
						getHeight() - (messageNum + 1) * MainRenderer.scaleY(MainRenderer.TILE_SIZE * 2 / 3));
			}
		}
	}

}
