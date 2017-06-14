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
import main.entities.Entity;
import main.entities.EntityPlayer;
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
						g.drawImage(ImageManager.getTileTexture(tiles[i][e].getSprite()), (i - Globals.scrollX) * TILE_SIZE, WINDOW_HEIGHT - (e - Globals.scrollY) * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
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
			g.setFont(new Font("Papyrus", 0, 25));
			g.setColor(Color.WHITE);
			
			EntityPlayer player = Globals.player;
			
			g.drawString("HP: " + player.getHp(), 5, 25);
			g.drawString("MP: " + player.getMp(), 5, TILE_SIZE + 25);
			g.drawString("TUF: " + player.getStats().getTuf(), 5, 3 * TILE_SIZE - 25);
			g.drawString("BUF: " + player.getStats().getBuf(), 5, 3 * TILE_SIZE);
			g.drawString("WIT: " + player.getStats().getWit(), 5, 3 * TILE_SIZE + 25);
			g.drawString("SNK: " + player.getStats().getSnk(), 5, 3 * TILE_SIZE + 50);
			
			g.setColor(Color.GRAY);
			g.fillRect(5, TILE_SIZE / 2, 2 * TILE_SIZE - 10, TILE_SIZE / 2);
			g.fillRect(5, 3 * TILE_SIZE / 2, 2 * TILE_SIZE - 10, TILE_SIZE / 2);
			if (player.getHp() != 0 && player.getStats().getHp() / player.getHp() >= 4)
				g.setColor(Color.RED);
			else
				g.setColor(Color.GREEN);
			g.fillRect(6, TILE_SIZE / 2 + 1, player.getHp() / player.getStats().getHp() * 2 * TILE_SIZE - 12, TILE_SIZE / 2 - 2);
			g.setColor(Color.BLUE);
			g.fillRect(6, 3 * TILE_SIZE / 2 + 1, player.getMp() / player.getStats().getMp() * 2 * TILE_SIZE - 12, TILE_SIZE / 2 - 2);
			
		}
	};
	
	private static Tile[][] tiles = null;
	private static Entity[] entities = null;
	private static EnumTheme theme = null;
	
	public static void init() {
		
		frame.setBounds((int) (SCREEN_RECT.getWidth() - WINDOW_WIDTH) / 2, (int) (SCREEN_RECT.getHeight() - WINDOW_HEIGHT) / 2, WINDOW_WIDTH, WINDOW_HEIGHT + 22 /*Extra bit because windows are weird*/);
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
		frame.setVisible(true);
	}
	
	public static void drawFloor(Floor map) {
		theme = map.getTheme();
		tiles = map.getTileMap();
		entities = map.getEntities();
		frame.repaint();
	}
	
}
