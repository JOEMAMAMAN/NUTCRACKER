package hi;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picture.Picture;

public class Player extends GenericObject {

	// Declaring variables
	Game game;
	int score = 0;
	int previousCoinX;				 // previous x value of coin to help determine new place to spawn
	public int vx = 0; 			     // speed at which character moves
	public int vy = 0; 				 // how far character jumps
	public int landed = this.getY(); // setting character to land on top of platform
	public BufferedImage image;

	public boolean jump = true; // stops player from constantly jumping

	/**
	 * Constructor for player
	 * Makes the image of the player
	 * sets players starting location and size
	 * reads image
	 * @param game
	 */
	public Player(Game game) {
		this.setLocation(0, 150);
		this.game = game;

		try {
			this.image = ImageIO.read(new File(Picture.class.getResource(
					"ianconyers.JPG").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setSize(45, 70);
	}

	/**
	 * draw method
	 * draws player image
	 * draws score on the screen
	 * @param g
	 */
	public void draw(Graphics g) {
		// g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
		g.drawString("Score: " + score, game.off_x + 30, 650);

	}

	/**
	 * update method constantly running
	 * takes care of collision and player movements
	 */
	public void update() {
		this.setLocation(getX() + vx, getY() + vy);

		vy += 2; // player falling if not landed
		
		// Collision between platforms, loops through every platform
		for (int i = 0; i < game.platforms.size(); i++) {
			Platform platform = game.platforms.get(i);
			if (this.collision(game.platforms.get(i))) { 	// collision method for each platform in the array
				landed = (platform.getY()); 	// if landed, set player y value to be above platform
				vy = 0; // stops character from falling
				if (this.getY() + this.getHeight() > platform.getY()) {
					jump = true; // lets you re-jump
				}

			}
		}
		
		// Collision between coins, loops though every coin
		for (int i = 0; i < game.coins.size(); i++) {
			if (this.collision(game.coins.get(i))) {	
				score++; 
			//	previousCoinX = game.coins.get(i).getX(); 		 // used to help determine new spawn location
																	// saving location in a variable before removing it
				game.coins.remove(i);				 // removing old coin
				game.coins.add(new Coin()); 		 // creating new coin
				game.coins.get(i).setLocation(Coin.spawnCoinX(this.getX()),
						Coin.spawnCoinY());

			}
		}

	}
	/*
	 * for (int i = 0; i < game.platforms.size(); i++) { Platform platform =
	 * game.platforms.get(i); if (this.getY() + this.getHeight() >
	 * platform.getY() && this.getX() < platform.getX() + platform.getWidth() &&
	 * (this.getX() + getWidth()) > platform.getX()) { landed = (platform.getY()
	 * + platform.getHeight()); vy = 0; jump = true;
	 */
}
