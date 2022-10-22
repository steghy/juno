package juno.view.card;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import juno.main.init.Paths;
import juno.model.util.PathGenerator;

/**
 * Cover class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardCover {
	
	/** Default cover */
	public static final String DEFAULT_COVER_ICON = "default.png";
	
	/* The icon cover */
	private Icon icon;
	
	/* The instance */
	private static CardCover instance;

	
	/* Builds the cover object */
	private CardCover() {
		init();
	}

	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static CardCover getInstance() {
		if(instance == null) {
			instance = new CardCover();
		} return instance;
	}
	
	
	/**
	 * Sets the icon of this Cover object
	 * @param icon The new icon for this Cover object
	 */
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	
	/**
	 * Returns the icon of this Cover object
	 * @return The icon of this Cover object
	 */
	public Icon getIcon() {
		return this.icon;
	}

	
	/* Initialize the Cover object */
	private void init() {
		String path = PathGenerator
				.generate(Paths.COVER.getPath(), DEFAULT_COVER_ICON);
		ImageIcon image = new ImageIcon(path);
		image.setImage(CardResizer.getScaledImage(image.getImage()));
		this.icon = image;
	}
}