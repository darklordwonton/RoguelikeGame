package main.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.dungeon.Floor;
import main.entities.Entity;
import main.filemanager.ImageManager;
import main.tiles.EnumTheme;
import main.tiles.Tile;
import main.util.ControlManager;
import main.util.Globals;

public class MainRenderer {
	
	public static final Dimension SCREEN_RECT = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WINDOW_WIDTH = 832;
	public static final int WINDOW_HEIGHT = 576;
	public static final int TILE_SIZE = WINDOW_HEIGHT / 9;
	private static JFrame frame = new JFrame("Game");
	private static JPanel mapPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Globals.BG_COLORS.get(theme));
			g.fillRect(0, 0, WINDOW_HEIGHT, WINDOW_HEIGHT);
			
			if (tiles != null) {
				for (int i = 0; i < tiles.length; i++) {
					for (int e = 0; e < tiles[0].length; e++) {
						g.drawImage(ImageManager.getTileSprite(tiles[i][e].getSprite()), (i - Globals.scrollX) * TILE_SIZE, WINDOW_HEIGHT - (e - Globals.scrollY) * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
					}
				}
			}
			
			if (entities != null) {
				for (Entity e : entities) {
					g.drawImage(ImageManager.getEntitySprite(e.getSprite()), (e.getX() - Globals.scrollX) * TILE_SIZE, WINDOW_HEIGHT - (e.getY() - Globals.scrollY) * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
				}
			}
			
		}
	};
	private static JPanel guiPane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 2 * TILE_SIZE, WINDOW_HEIGHT);
			g.fillRect(WINDOW_WIDTH - 2 * TILE_SIZE, 0, 2 * TILE_SIZE, WINDOW_HEIGHT);
		}
	};
	
	private static Tile[][] tiles = null;
	private static Entity[] entities = null;
	private static EnumTheme theme = null;
	
	public static void init() {
		
		frame.setBounds((int) (SCREEN_RECT.getWidth() - WINDOW_WIDTH) / 2, (int) (SCREEN_RECT.getHeight() - WINDOW_HEIGHT) / 2, WINDOW_WIDTH, WINDOW_HEIGHT + 22 /*Extra bit because windows are weird*/);
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
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
		mapPane.setBounds(2 * WINDOW_HEIGHT / 9, 0, WINDOW_HEIGHT, WINDOW_HEIGHT);
		guiPane.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
	public static void drawFloor(Floor map) {
		theme = map.getTheme();
		tiles = map.getTileMap();
		entities = map.getEntities();
		frame.repaint();
	}
	
}
