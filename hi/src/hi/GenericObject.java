package hi;

import java.awt.Rectangle;

import javax.swing.JLabel;

public class GenericObject extends JLabel {

	// int x;
	// int y;
	// int width;
	// int height;

	/**
	 * Collision method between two objects use between player and
	 * platforms/coins
	 * @param object
	 * @return
	 */
	public boolean collision(GenericObject object) {
		Rectangle rect = new Rectangle(this.getX(), this.getY(),
				this.getWidth(), this.getHeight());
		Rectangle rect2 = new Rectangle(object.getX(), object.getY(),
				object.getWidth(), object.getHeight());
		return rect.intersects(rect2);
	}

}
