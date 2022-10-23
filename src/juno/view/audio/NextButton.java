package juno.view.audio;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * NextButton class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NextButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The Default dimension */
	private final Dimension DEF_DIMENSION = new Dimension();
	
	/* The Preferred dimension */
	private final Dimension PRF_DIMENSION = new Dimension();

	/* The Minimun dimension */
	private final Dimension MIN_DIMENSION = new Dimension();
	
	/* The Maximun dimension */
	private final Dimension MAX_DIMENSION = new Dimension();
	
	/* The NextButton instance */
	private static NextButton instance;
	
	/* Builds the NextButton instance */
	private NextButton() {
		init();
	}

	
	/**
	 * Returns the NextButton instance 
	 * @return The NextButton instance
	 */
	public static NextButton getInstance() {
		if(instance == null) {
			instance = new NextButton();
		} return instance;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			Image image = temp.getImage();
			image = image.getScaledInstance(temp.getIconWidth(), 
											temp.getIconHeight(), 0);
			super.setIcon(new ImageIcon(image));
		} 
	}

	
	/* Initialize the NextButton instance */
	private void init() {

		// Dimension settings
		this.setPreferredSize(PRF_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setSize(DEF_DIMENSION);
	}
}