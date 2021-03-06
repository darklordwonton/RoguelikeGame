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
import main.rendering.animation.Animation;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.util.ControlManager;
import main.util.FrameInsets;
import main.util.Globals;
import main.util.RollingCounterManager;

public abstract class MainRenderer {
	
	public static final Dimension SCREEN_RECT = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final Insets DEFAULT_INSETS = new Insets(16, 16, 16, 16);
	
	public static final int DEFAULT_WINDOW_WIDTH = 1152;
	public static final int DEFAULT_WINDOW_HEIGHT = 576;
	public static final int TILE_SIZE = 64;
	private static JFrame frame = new JFrame("Goblin Adventure (working title)");
	private static JPanel mapPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Globals.BG_COLORS.get(theme));
			g.fillRect(0, 0, getWidth(), getHeight());
			
			if (tiles != null) {
				for (int x = 0; x < 9; x++) {
					for (int y = 1; y < 10; y++) {
						
						if (x + Globals.scrollX >= 0 && 
								x + Globals.scrollX < tiles.length && 
								y + Globals.scrollY >= 0 && 
								y + Globals.scrollY < tiles[0].length){
							
							Tile tile = tiles[x + Globals.scrollX][y + Globals.scrollY];
							
							g.drawImage(ImageManager.getTileTexture(tile.getSprite(), 
																	tile.getSpriteSheetColumn(), 
																	tile.getSpriteSheetRow()),
									x * scaleX(TILE_SIZE),	(9 - y) * scaleY(TILE_SIZE), 
									scaleX(TILE_SIZE), 		scaleY(TILE_SIZE), 
									null);
							
							Entity entity = tile.getResidentEntity();
							
							if (entity != null)
								g.drawImage(ImageManager.getEntitySprite(entity.getSprite(), 
																		 entity.getSpriteX(), 
																		 entity.getSpriteY()),
										x * scaleX(TILE_SIZE), 
										(9 - y) * scaleY(TILE_SIZE), 
										scaleX(TILE_SIZE), 
										scaleY(TILE_SIZE), 
										null);
							
							for (Effect effect : tile.getEffects()) {
								g.drawImage(effect.getSprite(),
										x * scaleX(TILE_SIZE),	(9 - y) * scaleY(TILE_SIZE), 
										scaleX(TILE_SIZE), 		scaleY(TILE_SIZE), 
										null);
							}
						}
					}
				}
			}
			
			/*g.setFont(new Font("Papyrus", Font.BOLD, scaleXY(TILE_SIZE / 3)));
			g.setColor(Color.WHITE);
			if (entities != null) {
				for (Entity e : entities) {
					if (!e.getDead() || e.getSpecies().equals("Player")){
						// TODO refine boundaries for drawing entities
						if (Math.abs(e.getX() - Globals.player.getX()) <5 && Math.abs(e.getY() - Globals.player.getY()) <5){
							g.drawImage(ImageManager.getEntitySprite(e.getSprite(), 
																	e.getSpriteX(), 
																	e.getSpriteY()),
									(e.getX() - Globals.scrollX) * scaleX(TILE_SIZE), 
									(9 - (e.getY() - Globals.scrollY)) * scaleY(TILE_SIZE), 
									scaleX(TILE_SIZE), 
									scaleY(TILE_SIZE), 
									null);
							
							g.drawString(e.getName(), scaleX((e.getX() - Globals.scrollX) * TILE_SIZE), 
									scaleY((10 - (e.getY() - Globals.scrollY)) * TILE_SIZE));
						}
					}
				}
			}*/
			
			if (effects != null) {
				for (int x = 0; x < 9; x++) {
					for (int y = 1; y < 10; y++) {
						
						if (x + Globals.scrollX >= 0 && x + Globals.scrollX < tiles.length && y + Globals.scrollY >= 0 && y + Globals.scrollY < tiles[0].length){
							
							Effect e = effects[x + Globals.scrollX][y + Globals.scrollY];
							if (e != null)
								g.drawImage(e.getSprite(),
									x * scaleX(TILE_SIZE),	(9 - y) * scaleY(TILE_SIZE), 
									scaleX(TILE_SIZE), 		scaleY(TILE_SIZE), 
									null);
						}
					}
				}
			}
			
//			TODO integrate into ondeath in entity
			if (Globals.player.getDead()){
				g.setColor(new Color(128, 128, 128, 128));
				g.fillRect(0, 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
				g.setColor(Color.BLACK);
				g.setFont(new Font("Papyrus", Font.BOLD, scaleXY(TILE_SIZE * 2)));
				g.drawString("u ded", scaleX(TILE_SIZE * 2), mapPane.getHeight()/2);
			}
		}
	};
	
	private static JPanel guiPane = new JPanel() {
//		TODO increase distance between lines
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
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
	private static Effect[][] effects = null;
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
		
		guiPane.setBounds(0, 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		messagePane.setBounds(scaleX(11 * TILE_SIZE), 0, scaleX(7 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		frame.setVisible(true);
		
		frame.setBounds((int) (SCREEN_RECT.getWidth() - DEFAULT_WINDOW_WIDTH - FrameInsets.get(frame, "sides")) / 2, 
				(int) (SCREEN_RECT.getHeight() - DEFAULT_WINDOW_HEIGHT - FrameInsets.get(frame, "long")) / 2, 
				DEFAULT_WINDOW_WIDTH + FrameInsets.get(frame, "sides"), 
				DEFAULT_WINDOW_HEIGHT + FrameInsets.get(frame, "long"));
		
		guiPane.setBounds(0, 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		mapPane.setBounds(scaleX(2 * TILE_SIZE), 0, scaleX(9 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		messagePane.setBounds(scaleX(11 * TILE_SIZE), 0, scaleX(7 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		
		/*System.out.println("guiPane x: " + guiPane.getX() + "+" + guiPane.getWidth() + "->" + mapPane.getX() // 0 + 128 = 128
				+ "    " + "mapPane x: " + mapPane.getX() + "+" + mapPane.getWidth() + "->" + messagePane.getX()); //128 + 576 = 704
		System.out.println("guiPane y: " + guiPane.getY() + "->" + guiPane.getHeight() + "    " //0->576 
				+ "    " + "mapPane y: " + mapPane.getY() + "->" + mapPane.getHeight()); // 0->576
		
		System.out.println();
		System.out.println("messagePane x: " + messagePane.getX() + "+" + messagePane.getWidth() + "->" + scaleX(DEFAULT_WINDOW_WIDTH)); //0+1116 -> 1133
		System.out.println("messagePane x: " + scaleX(11 * TILE_SIZE) + "+" + scaleX(7 * TILE_SIZE) + "->" + scaleX(DEFAULT_WINDOW_WIDTH));//692 + 440 -> 1133
		System.out.println("messagePane y: " + messagePane.getY() + "->" + messagePane.getHeight());//0 -> 473 || 0 -> 576
		System.out.println("messagePane y: " + 0 + "->" + scaleY(9 * TILE_SIZE));//0 -> 473 || 0 -> 576
		System.out.println();
		
		System.out.println("frame x: " + frame.getWidth()); //1152 - 19 (horizontal insets) = 1133 || 1171 - 19 = 1152
		System.out.println("frame y: " + frame.getHeight()); //576 - 103 (vertical insets) = 473 || 679 - 103 = 576
		
		System.out.println("heightwise insets: " + FrameInsets.get(frame, "long"));
		System.out.println("lengthwise insets: " + FrameInsets.get(frame, "sides"));*/
		
	}
	
	public static void updateFloor(Floor map) {
		theme = map.getTheme();
		tiles = map.getTileMap();
		entities = map.getEntities();
	}
	
	public static void refresh() {
		guiPane.setBounds(0, 0, scaleX(2 * TILE_SIZE), scaleY(9 * TILE_SIZE));
		mapPane.setBounds(guiPane.getWidth(), 0, scaleX(9 * TILE_SIZE), guiPane.getHeight());
		messagePane.setBounds(scaleX(11 * TILE_SIZE), 0, scaleX(7 * TILE_SIZE), guiPane.getHeight());
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
		return num * (frame.getWidth() - FrameInsets.get(frame, "sides")) / DEFAULT_WINDOW_WIDTH;
	}
	
	public static int scaleY(int num) {
		return num * (frame.getHeight() - FrameInsets.get(frame, "long")) / DEFAULT_WINDOW_HEIGHT;
	}
	
	public static int scaleXY(int num){
		return num * (frame.getWidth() + frame.getHeight()) / (DEFAULT_WINDOW_HEIGHT + DEFAULT_WINDOW_WIDTH);
	}
	
}
