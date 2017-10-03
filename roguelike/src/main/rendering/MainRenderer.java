package main.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.dungeon.Floor;
import main.effects.Effect;
import main.entities.Entity;
import main.entities.EntityPlayer;
import main.filemanager.ImageManager;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.util.ControlManager;
import main.util.FrameInsets;
import main.util.Globals;
import main.util.RollingCounterManager;

public abstract class MainRenderer {
	
	public static final Dimension SCREEN_RECT = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int DEFAULT_WINDOW_WIDTH = 832;
	public static final int DEFAULT_WINDOW_HEIGHT = 636;
	public static final int TILE_SIZE = 64;
	private static JFrame frame = new JFrame("Goblin Adventure (working title)");
	private static JPanel mapPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Globals.BG_COLORS.get(theme));
			g.fillRect(0, 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
			
			if (tiles != null) {
				for (int i = 0; i < 9; i++) {
					for (int e = 1; e < 10; e++) {
						
						if (i + Globals.scrollX >= 0 && i + Globals.scrollX < tiles.length && e + Globals.scrollY >= 0 && e + Globals.scrollY < tiles[0].length){
							
							Tile tile = tiles[i + Globals.scrollX][e + Globals.scrollY];
							
							g.drawImage(ImageManager.getTileTexture(tile.getSprite(), 
																	tile.getSpriteSheetColumn(), 
																	tile.getSpriteSheetRow()),
									i * scaleX(TILE_SIZE),	(9 - e) * scaleY(TILE_SIZE), 
									scaleX(TILE_SIZE), 		scaleY(TILE_SIZE), 
									null);
						}
					}
				}
			}
			
			g.setFont(new Font("Papyrus", 0, scaleXY(TILE_SIZE / 3)));
			g.setColor(Color.WHITE);
			if (entities != null) {
				for (Entity e : entities) {
					if (!e.getDead()){
						// TODO stop drawing entities off screen
						g.drawImage(ImageManager.getEntitySprite(e.getSprite(), 
																e.getSpriteX(), 
																e.getSpriteY()),
								scaleX((e.getX() - Globals.scrollX) * TILE_SIZE), 
								scaleY((9 - (e.getY() - Globals.scrollY)) * TILE_SIZE), 
								scaleX(TILE_SIZE), 
								scaleY(TILE_SIZE), 
								null);
						
						g.drawString(e.getName(), scaleX((e.getX() - Globals.scrollX) * TILE_SIZE), 
								scaleY((10 - (e.getY() - Globals.scrollY)) * TILE_SIZE));
					}
				}
			}
			if (Globals.player.getDead()){
				g.setColor(new Color(128, 128, 128, 128));
				g.fillRect(0, 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
				g.drawString("test", DEFAULT_WINDOW_WIDTH/2, DEFAULT_WINDOW_HEIGHT/2);
			}
		}
	};
	private static JPanel guiPane = new JPanel() {
//		TODO increase distance between lines
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
			g.fillRect(scaleX(DEFAULT_WINDOW_WIDTH - 2 * TILE_SIZE), 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
			g.setFont(new Font("Papyrus", 0, scaleXY(TILE_SIZE * 2 / 5)));
			g.setColor(Color.WHITE);
			
			EntityPlayer player = Globals.player;
			
			
			g.drawString("HP: " + player.getHp(), scaleX(TILE_SIZE / 50), scaleY(TILE_SIZE / 2));
			g.drawString("MP: " + player.getMp(), scaleX(TILE_SIZE / 50), scaleY(TILE_SIZE * 3 / 2));
			g.drawString("LVL: " + player.getStats().getLevel(), scaleX(TILE_SIZE / 50), scaleY(5 * TILE_SIZE / 2));
			g.drawString("TUF: " + player.getStats().getTuf(), scaleX(TILE_SIZE / 50), scaleY(3 * TILE_SIZE));
			g.drawString("BUF: " + player.getStats().getBuf(), scaleX(TILE_SIZE / 50), scaleY(7 * TILE_SIZE / 2));
			g.drawString("WIT: " + player.getStats().getWit(), scaleX(TILE_SIZE / 50), scaleY(4 * TILE_SIZE));
			g.drawString("SNK: " + player.getStats().getSnk(), scaleX(TILE_SIZE / 50), scaleY(9 * TILE_SIZE / 2));
			
			g.setColor(Color.GRAY);
			g.fillRect(scaleX(TILE_SIZE / 25), scaleY(TILE_SIZE * 15 / 24), scaleX(2 * TILE_SIZE - TILE_SIZE / 10), scaleY(TILE_SIZE / 2));
			g.fillRect(scaleX(TILE_SIZE / 25), scaleY(TILE_SIZE * 39 / 24), scaleX(2 * TILE_SIZE - TILE_SIZE / 10), scaleY(TILE_SIZE / 2));
			if (player.getHp() != 0 && player.getStats().getHp() / RollingCounterManager.getDisplayHealth() >= 4)
				g.setColor(Color.RED);
			else
				g.setColor(Color.GREEN);
			int borderWidth = (TILE_SIZE/15 - TILE_SIZE/25);
			float healthPercent = RollingCounterManager.getDisplayHealth() / (float) player.getStats().getHp();
			g.fillRect(scaleX(TILE_SIZE / 25 + borderWidth), scaleY(TILE_SIZE * 15 / 24 + borderWidth), scaleX((int)(healthPercent * (2 * TILE_SIZE - TILE_SIZE / 10) - 2 * borderWidth)), scaleY(TILE_SIZE / 2 - 2 * borderWidth));
			g.setColor(Color.BLUE);
			g.fillRect(scaleX(TILE_SIZE / 25 + borderWidth), scaleY(TILE_SIZE * 39 / 24 + borderWidth), scaleX(2 * TILE_SIZE - TILE_SIZE / 10 - 2 * borderWidth), scaleY(TILE_SIZE / 2 - 2 * borderWidth));
		}
	};
	private static MessageBarPane messagePane = new MessageBarPane();
	
	private static Tile[][] tiles = null;
	private static Entity[] entities = null;
	private static Effect[] effects = null;
	private static EnumTheme theme = null;
	
	public static void init() {

		frame.setBounds((int) (SCREEN_RECT.getWidth() - DEFAULT_WINDOW_WIDTH) / 2, 
				(int) (SCREEN_RECT.getHeight() - DEFAULT_WINDOW_HEIGHT) / 2, 
				DEFAULT_WINDOW_WIDTH, 
				DEFAULT_WINDOW_HEIGHT);
		
		
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent event){
	             System.exit(0);
	         }
		});
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				ControlManager.keyUp(e.getKeyCode());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				ControlManager.keyDown(e.getKeyCode());
			}
		});
		
		frame.getContentPane().add(mapPane);
		frame.getContentPane().add(guiPane);
		frame.getContentPane().add(messagePane);
		
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		guiPane.setBounds(0, 0, frame.getWidth(), scaleY(9 * TILE_SIZE));
		messagePane.setBounds(0, scaleY(9 * TILE_SIZE), frame.getWidth(), scaleY(80));
		frame.setVisible(true);
		

		
	}
	
	public static void updateFloor(Floor map) {
		theme = map.getTheme();
		tiles = map.getTileMap();
		entities = map.getEntities();
	}
	
	public static void refresh() {
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		guiPane.setBounds(0, 0, frame.getWidth(), scaleY(9 * TILE_SIZE));
		messagePane.setBounds(0, scaleY(9 * TILE_SIZE), frame.getWidth(), scaleY(80));
		frame.repaint();
	}
	
	public static void closeWindow(){
		frame.dispose();
	}
	
	public static void addMessage(String m){
		messagePane.addMessage(m);
		refresh();
	}
	
	public static void incrementMessage() {
		messagePane.incrementMessage();
	}
	
	public static int scaleX(int num) {
		return num * (frame.getWidth() - FrameInsets.getInsets(frame, "sides")) / DEFAULT_WINDOW_WIDTH;
	}
	
	public static int scaleY(int num) {
		return num * (frame.getHeight() - FrameInsets.getInsets(frame, "long")) / DEFAULT_WINDOW_HEIGHT;
	}
	
	public static int scaleXY(int num){
		return num * (frame.getWidth() + frame.getHeight()) / (DEFAULT_WINDOW_HEIGHT + DEFAULT_WINDOW_WIDTH);
	}
	
	
}
