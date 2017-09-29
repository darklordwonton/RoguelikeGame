package main.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import main.util.Globals;
import main.util.RollingCounterManager;

public abstract class MainRenderer {
	
	public static final Dimension SCREEN_RECT = Toolkit.getDefaultToolkit().getScreenSize();
	
	/*public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WINDOW_WIDTH = (int) (screenSize.getWidth() / 3);
	public static final int WINDOW_HEIGHT = (int) (screenSize.getHeight() * 2 / 5);*/
	
	public static final int DEFAULT_WINDOW_WIDTH = 832; //2560
	public static final int DEFAULT_WINDOW_HEIGHT = 656; //1600
	public static final int TILE_SIZE = 64;
	
//	public static final int DEFAULT_WINDOW_WIDTH = (int) (SCREEN_RECT.getWidth() / 3);
//	public static final int DEFAULT_WINDOW_HEIGHT = DEFAULT_WINDOW_WIDTH * 3 / 4;
	
	private static JFrame frame = new JFrame("Goblin Adventure (working title)");
	private static JPanel mapPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Globals.BG_COLORS.get(theme));
			g.fillRect(0, 0, scaleX(DEFAULT_WINDOW_WIDTH), scaleY(9 * TILE_SIZE));
			
			if (tiles != null) {
				for (int i = 0; i < 9; i++) {
					for (int e = 1; e < 10; e++) {
						if (i + Globals.scrollX >= 0 && i + Globals.scrollX < tiles.length && e + Globals.scrollY >= 0 && e + Globals.scrollY < tiles[0].length){
							
							Tile tile = tiles[i + Globals.scrollX][e + Globals.scrollY];
							
							g.drawImage(ImageManager.getTileTexture(tile.getSprite(), 
																	tile.getSpriteSheetColumn(), 
																	tile.getSpriteSheetRow()),
							
//							ImageManager.getTileTexture(tiles[i + Globals.scrollX][e + Globals.scrollY].getSprite(), 0, (Math.random() * 5)), 
									scaleX(i * TILE_SIZE), scaleY((9 - e) * TILE_SIZE), 
									scaleX(TILE_SIZE), 
									scaleY(TILE_SIZE), 
									null);
						}
					}
				}
			}
			
			g.setFont(new Font("Papyrus", 0, scaleXY(15)));
			g.setColor(Color.WHITE);
			if (entities != null) {
				for (Entity e : entities) {
					if (!e.getDead()){
						
						g.drawImage(ImageManager.getEntitySprite(e.getSprite(), 
																e.getSpriteX(), 
																e.getSpriteY()),
								scaleX((e.getX() - Globals.scrollX) * TILE_SIZE), 
								scaleY(9 * TILE_SIZE - (e.getY() - Globals.scrollY) * TILE_SIZE), 
								scaleX(TILE_SIZE), 
								scaleY(TILE_SIZE), 
								null);
						
						g.drawString(e.getName(), scaleX((e.getX() - Globals.scrollX) * TILE_SIZE + 1), 
								scaleY(10 * TILE_SIZE - (e.getY() - Globals.scrollY) * TILE_SIZE + 1));
					}
				}
			}

		}
	};
	private static JPanel guiPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
			g.fillRect(scaleX(DEFAULT_WINDOW_WIDTH - 2 * TILE_SIZE), 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
			g.setFont(new Font("Papyrus", 0, scaleXY(25)));
			g.setColor(Color.WHITE);
			
			EntityPlayer player = Globals.player;
			
			
			g.drawString("HP: " + player.getHp(), scaleX(5), scaleY(25));
			g.drawString("MP: " + player.getMp(), scaleX(5), scaleY(TILE_SIZE + 25));
			g.drawString("LVL: " + player.getStats().getLevel(), scaleX(5), scaleY(3 * TILE_SIZE - 25));
			g.drawString("TUF: " + player.getStats().getTuf(), scaleX(5), scaleY(3 * TILE_SIZE + 10));
			g.drawString("BUF: " + player.getStats().getBuf(), scaleX(5), scaleY(3 * TILE_SIZE + 35));
			g.drawString("WIT: " + player.getStats().getWit(), scaleX(5), scaleY(3 * TILE_SIZE + 60));
			g.drawString("SNK: " + player.getStats().getSnk(), scaleX(5), scaleY(3 * TILE_SIZE + 85));
			
			g.setColor(Color.GRAY);
			g.fillRect(scaleX(5), scaleY(TILE_SIZE / 2), scaleX(2 * TILE_SIZE - 10), scaleY(TILE_SIZE / 2));
			g.fillRect(scaleX(5), scaleY(3 * TILE_SIZE / 2), scaleX(2 * TILE_SIZE - 10), scaleY(TILE_SIZE / 2));
			if (player.getHp() != 0 && player.getStats().getHp() / RollingCounterManager.getDisplayHealth() >= 4)
				g.setColor(Color.RED);
			else
				g.setColor(Color.GREEN);
			g.fillRect(scaleX(6), scaleY(TILE_SIZE / 2 + 1), scaleX((int)(RollingCounterManager.getDisplayHealth() / (float) player.getStats().getHp() * 2 * TILE_SIZE - 12)), scaleY(TILE_SIZE / 2 - 2));
			g.setColor(Color.BLUE);
			g.fillRect(scaleX(6), scaleY(3 * TILE_SIZE / 2 + 1), scaleX((int)(player.getMp() / (float) player.getStats().getMp() * 2 * TILE_SIZE - 12)), scaleY(TILE_SIZE / 2 - 2));
			
		}
	};
	private static MessageBarPane messagePane = new MessageBarPane();
	
	private static Tile[][] tiles = null;
	private static Entity[] entities = null;
	private static Effect[] effects = null;
	private static EnumTheme theme = null;
	
	public static void init() {
		
		frame.setBounds((int) (SCREEN_RECT.getWidth() - DEFAULT_WINDOW_WIDTH) / 2, (int) (SCREEN_RECT.getHeight() - DEFAULT_WINDOW_HEIGHT) / 2, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT/* + 22*/ /*Extra bit because windows are weird*/);
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
		
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(DEFAULT_WINDOW_HEIGHT - 80));
		guiPane.setBounds(0, 0, frame.getWidth(), scaleY(DEFAULT_WINDOW_HEIGHT - 80));
		messagePane.setBounds(0, scaleY(9 * TILE_SIZE), frame.getWidth(), scaleY(80));
		frame.setVisible(true);
	}
	
	public static void updateFloor(Floor map) {
		theme = map.getTheme();
		tiles = map.getTileMap();
		entities = map.getEntities();
	}
	
	public static void refresh() {
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(DEFAULT_WINDOW_HEIGHT - 80));
		guiPane.setBounds(0, 0, frame.getWidth(), scaleY(DEFAULT_WINDOW_HEIGHT - 80));
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
		return num * frame.getWidth() / DEFAULT_WINDOW_WIDTH;
	}
	
	public static int scaleY(int num) {
		return num * frame.getHeight() / DEFAULT_WINDOW_HEIGHT;
	}
	
	public static int scaleXY(int num){
		return num * (frame.getWidth() + frame.getHeight()) / (DEFAULT_WINDOW_HEIGHT + DEFAULT_WINDOW_WIDTH);
	}
	
	
}
