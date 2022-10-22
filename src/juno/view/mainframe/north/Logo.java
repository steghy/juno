package juno.view.mainframe.north;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Logo class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Logo extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/** Default Icon object width */
	public static final int DEF_ICON_WIDTH = 450;
	
	/** Default Icon object height */
	public static final int DEF_ICON_HEIGHT = 450;
	
	/** Defautl Icon object hints */
	public static final int DEF_ICON_HINTS = 0;

	/* Default JLabel dimension */
	private Dimension DEF_DIMENSION = new Dimension(500, 500);
	
	/* Default JLabel dimension */
	private Dimension PRF_DIMENSION = new Dimension(500, 500);

	/* Minimun JLabel dimension */
	private Dimension MIN_DIMENSION = new Dimension(500, 500);
	
	/* Maximun JLabel dimension */
	private Dimension MAX_DIMENSION = new Dimension(500, 500);
	
	/* The Logo instance */
	private static Logo instance;

	
	/* Builds the Logo instance */
	private Logo() {
		init();
	}

	
	/**
	 * Returns the Logo instance
	 * @return The Logo instance
	 */
	public static Logo getInstance() {
		if(instance == null) {
			instance = new Logo();
		} return instance;
	}

	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			Image image = temp.getImage();
			image = image.getScaledInstance(temp.getIconWidth() / 2, 
											temp.getIconHeight() / 2, 0);
			super.setIcon(new ImageIcon(image));
		} 
	}
	
	
	/* Initialize the Logo instance */
	private void init() {
		
		// Dimension settings
		this.setPreferredSize(PRF_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setSize(DEF_DIMENSION);

		// Alignment settings
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);

		// Various settings
		this.setOpaque(false);
		
		// Dimensions
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
	}

}