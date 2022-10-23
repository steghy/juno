package juno.view.main.menu;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Background component.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Background extends JLabel {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* The Background instance */
	private static Background instance;
	
	
	/* Builds the Background instance */
	private Background() {
		init();
	}

	
	/**
	 * Returns the Background instance
	 * @return The Background instance
	 */
	public static Background getInstance() {
		if(instance == null) {
			instance = new Background();
		} return instance;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		Dimension screenDimension = Toolkit
							.getDefaultToolkit()
							.getScreenSize();
		if(icon instanceof ImageIcon) {
			Image scaledImage = ((ImageIcon) icon)
								.getImage()
								.getScaledInstance((int)screenDimension.getWidth(), 
												   (int)screenDimension.getHeight(), 
												   0);
			super.setIcon(new ImageIcon(scaledImage));
		}
	}
	
	
	/* Iinitialize the Background instance */
	private void init() {}
	
}