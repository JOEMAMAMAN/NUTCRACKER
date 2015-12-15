package hi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	Game game;

	/**
	 * adding input to this instant of the game
	 *
	 * @param game
	 */
	public Input(Game game) {
		this.game = game;
	}

	/**
	 * When key is pressed move the character in certain direction
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.player.vx = -4;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.player.vx = 4;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (game.player.jump) { // if jump is true, player allowed to jump
				game.player.vy = -20; // jump distance
				game.player.jump = false; // stops jump from being constantly
											// pressed until landed
			}
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			game.player.vy = 0;
			game.player.jump = true;
			game.player
					.setLocation(game.player.getX(), game.player.getY() - 50);
		}
	}

	/**
	 * when key released set values to 0 so player stops moving
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.player.vx = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.player.vx = 0;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}
