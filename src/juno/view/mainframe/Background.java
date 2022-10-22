package juno.view.mainframe;

import java.awt.Dimension;
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
	
	
	/** Builds the Background instance */
	public Background() {
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
	
	
	public void setIcon(Icon icon) {
		Dimension screenDimension = Toolkit
							.getDefaultToolkit()
							.getScreenSize();
		
		int width = (int)screenDimension.getWidth();
		int height = (int)screenDimension.getHeight();
		
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			temp = new ImageIcon(temp
						.getImage()
						.getScaledInstance(width, height, 0));
			super.setIcon(temp);
		}
	}
	
	
	/* Iinitialize the Background instance */
	private void init() {
		
	}
	
	
}
