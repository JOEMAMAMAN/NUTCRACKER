package hi;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import picture.Picture;

public class Coin extends GenericObject {

	public static Random random;
	public BufferedImage image;

	/**
	 * Constructor for coin Creates predetermined size and gives each coin an
	 * image	
	 * 
	 */
	public Coin() {
		this.setSize(15, 15);

		try {
			this.image = ImageIO.read(new File(Picture.class.getResource(
					"gold.png").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * draw method draws coins image
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);

	}

	/**
	 * Spawning new coin in random X location between 100-450 units right of old
	 * coin, never spawns behind old coin
	 * 
	 * @param oldX
	 * @return
	 */
	public static int spawnCoinX(int oldX) {
		random = new Random();
		return oldX + random.nextInt(450) + 100;
	}

	/**
	 * Spawning new coin in random Y location between 100-450
	 * 
	 * @return
	 */
	public static int spawnCoinY() {
		random = new Random();
		return random.nextInt(450) + 100;
	}
}
