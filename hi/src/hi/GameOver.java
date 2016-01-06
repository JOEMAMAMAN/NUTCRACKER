package hi;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picture.Picture;

public class GameOver {
	
	public static BufferedImage image;
	
	public GameOver() {
		
		try {
			this.image = ImageIO.read(new File(Picture.class.getResource(
					"coolstuff123.png").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void draw(Graphics g) {
		g.drawImage(image,0, 0, null);
	}
}
