package main.filemanager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class ImageManager {
	
	private static HashMap<String, BufferedImage> tiles = new HashMap<String, BufferedImage>();
	private static HashMap<String, BufferedImage> entities = new HashMap<String, BufferedImage>();
	
	public static void init () {
		tiles.putAll(loadAllImages("src/resources/tiles"));
		entities.putAll(loadAllImages("src/resources/entities"));
	}
	
	public static HashMap<String, BufferedImage> loadAllImages (String path) {
		HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();
		File folder = new File(path);
		for (File file: folder.listFiles()) {
			images.put(file.getName(), readImageFromFile(file));
		}
		return images;
	}
	
	public static BufferedImage readImageFromFile (String path) {
		BufferedImage ret = null;
		try {
		    ret = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("ERROR: Could not locate image file at " + path);
		}
		return ret;
	}
	
	public static BufferedImage readImageFromFile (File file) {
		BufferedImage ret = null;
		try {
		    ret = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("ERROR: Could not locate image file at " + file.getPath());
		}
		return ret;
	}
	
	public static BufferedImage getTileTexture (String image) {
		return tiles.get(image);
	}
	
	public static BufferedImage getEntitySprite (String image, int column, int row) {
		return entities.get(image).getSubimage(column*16, row*16, 16, 16);
	}
	
}
