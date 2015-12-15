package hi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	// Declaring everything
	Player player = new Player(this); // creating player object to this game
	List<Platform> platforms = new ArrayList<Platform>(); // dynamic data structure
	List<Coin> coins = new ArrayList<Coin>(); // dynamic data structure
	Timer timer = new Timer(1000 / 60, this); // game timer
	Timer platTimer = new Timer(1000 / 3, this); // timer to spawn platforms
	int platNumber = 1;

	/**
	 * initializing method starts timers 
	 * creates the first coin and first platform location
	 * 
	 */
	public void init() {

		timer.start();
		platTimer.start();

		// Create first platform in spawning location
		Platform startPlat = new Platform();
		startPlat.setLocation(0, 450);
		startPlat.setSize(80, 20);
		platforms.add(startPlat);

		// Create first coin in pre-generated place
		Coin coin = new Coin();
		coin.setLocation(50, 300);
		coins.add(coin);

		// for (int i = 1; i < 50; i++) {
		// platforms.add(new Platform());
		// platforms.get(i).setSize(platforms.get(i).randomWidth(),
		// platforms.get(i).randomHeight());
		// platforms.get(i).setLocation(
		// platforms.get(i).randomSpawnX(platforms.get(i - 1).getX()),
		// platforms.get(i).randomSpawnY(platforms.get(i - 1).getY()));
		// }
	}

	/**
	 * paints player, coins and platforms by calling draw method
	 */
	public void paint(Graphics g) {

		g.clearRect(0, 0, getWidth(), getHeight());

		player.draw(g);

		for (int i = 0; i < coins.size(); i++) { // loops through all the coins in array list
			coins.get(i).draw(g);
		}

		for (int i = 0; i < platforms.size(); i++) { // loops through all platforms in array list
			platforms.get(i).draw(g);
		}

	}

	/**
	 * main method to run game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Game game = new Game();
		game.init();
		JFrame frame = new JFrame();
		frame.setSize(1200, 700);

		game.setSize(frame.getSize());
		game.setFocusable(true);
		game.setDoubleBuffered(true); // stop the platforms from flickering, setting property of double buffering to true

		frame.setTitle("IAN CONYERS THE GAME");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new Input(game));
		frame.add(game);
	}

	@Override
	/**
	 * game timer and timer to spawn platforms
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == timer) {
			repaint();
			player.update();
			
		}

		// creating new platforms
		if (e.getSource() == platTimer) {
			platforms.add(new Platform());
			platforms.get(platNumber).setSize(
					platforms.get(platNumber).randomWidth(),
					platforms.get(platNumber).randomHeight());
			platforms.get(platNumber).setLocation(
					platforms.get(platNumber).randomSpawnX(
							platforms.get(platNumber - 1).getX()),
					platforms.get(platNumber).randomSpawnY(
							platforms.get(platNumber - 1).getY()));
			platNumber++;

		}

	}
}
