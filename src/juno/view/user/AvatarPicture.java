package juno.view.user;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The AvatarPicture class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AvatarPicture extends JLabel {

	/* Serail Version UID */
	private static final long serialVersionUID = 1L;

	
	/** Builds an AvatarLabel object */
	public AvatarPicture() {
		init();
	}

	
	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			Image scaledImage = ((ImageIcon) icon)
								.getImage()
								.getScaledInstance(75, 75, 0);
			super.setIcon(new ImageIcon(scaledImage));
		}
	}
	
	
	/* Initialize an AvatarPanel object */
	private void init() {
		
		// Dimension settings
		this.setSize(new Dimension(75, 75));
		this.setPreferredSize(new Dimension(75, 75));
		this.setMinimumSize(new Dimension(50, 50));
		this.setMaximumSize(new Dimension(100, 100));
	}
}