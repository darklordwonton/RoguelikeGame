package main.filemanager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class ImageManager {
	
	private static HashMap<String, BufferedImage> masterList = new HashMap<String, BufferedImage>();
	
	public static void init () {
		masterList.putAll(loadAllImages("src/resources"));
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
	
	public static BufferedImage getImage (String image) {
		return masterList.get(image);
	}
	
}
