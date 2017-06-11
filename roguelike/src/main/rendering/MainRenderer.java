package main.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.filemanager.ImageManager;
import main.util.ControlManager;

public class MainRenderer {
	
	public static final Dimension SCREEN_RECT = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private static JFrame frame = new JFrame("Game");
	private static JPanel pane = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	};
	
	public static void init() {
		
		frame.setBounds((int) (SCREEN_RECT.getWidth() - WINDOW_WIDTH) / 2, (int) (SCREEN_RECT.getHeight() - WINDOW_HEIGHT) / 2, WINDOW_WIDTH, WINDOW_HEIGHT);
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
		
		frame.setContentPane(pane);
		pane.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
}
