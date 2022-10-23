package juno.view.user;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * AvatarFrame class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AvatarFrame extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	
	/** 
	 * Builds the AvatarFrame instance 
	 */
	public AvatarFrame() {
		init();
	}

	
	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			Dimension panelDimension = AvatarPanel.DEF_DIMENSION;
			Image scaledImage = ((ImageIcon) icon)
								.getImage()
								.getScaledInstance(panelDimension.width, 
												   panelDimension.height, 
												   0);
			super.setIcon(new ImageIcon(scaledImage));
		}
	}
	
	
	/* Iinitialize the Background instance */
	private void init() {

		// Dimension settings 
		// this.setSize(DEF_DIMENSION);
		// this.setPreferredSize(PRF_DIMENSION);
		// this.setMinimumSize(MIN_DIMENSION);
		// this.setMaximumSize(MAX_DIMENSION);
	}
	
}
