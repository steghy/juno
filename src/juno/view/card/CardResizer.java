package juno.view.card;

import java.awt.Image;

/**
 * 
 * @author steghy
 *
 */
public class CardResizer {

	/** Static default card width */
	public static final int WIDTH = 125;
	
	/** Static default card height */
	public static final int HEIGHT = 200;
	
	/** Static default Hints */
	public static final int HINTS = 0;
	
	/* */
	private CardResizer() {}

	
	/**
	 * Returns the specified Image object but resized.
	 * @param image An Image object
	 * @return An Image object
	 */
	public static Image getScaledImage(Image image) {
		return image.getScaledInstance(WIDTH, HEIGHT, HINTS);
	}
}