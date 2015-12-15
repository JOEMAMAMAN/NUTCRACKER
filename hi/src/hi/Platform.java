package hi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import picture.Picture;

public class Platform extends GenericObject {

	// declaring variables, min/max of width/height of platforms
	int minHeight = 20;
	int minWidth = 30;
	int maxHeight = 50;
	int maxWidth = 100;
	public Random random;
	public BufferedImage image;

	/**
	 *Constructor for platform Creates each platform with an image
	 */
	public Platform() {

		try {
			this.image = ImageIO.read(new File(Picture.class.getResource(
					"snek.JPG").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * draw method draws platforms image
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		// g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	/**
	 * Spawning a new platform X value Adds previous platforms x value so the
	 * platforms continue to go right
	 * 
	 * @param previousPlatX
	 * @return
	 */
	public int randomSpawnX(int previousPlatX) {
		random = new Random();
		return previousPlatX + random.nextInt(100) + 0;
	}

	/**
	 * Spawning a new platform Y value Limits how far platform can spawn
	 * 
	 * @param previousPlatY
	 * @return
	 */
	public int randomSpawnY(int previousPlatY) {
		random = new Random();
		return random.nextInt(500) + 50;
	}

	/**
	 * Creating a random width between 30-100 for platform
	 * 
	 * @return
	 */
	public int randomWidth() {
		random = new Random();
		return random.nextInt((maxWidth - minWidth) + 1) + minWidth;

	}

	/**
	 * Creating a random height between 20-50 for platform
	 * 
	 * @return
	 */
	public int randomHeight() {
		random = new Random();
		return random.nextInt((maxHeight - minHeight) + 1) + minHeight;
	}
}