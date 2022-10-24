package juno.view.avatar;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AvatarFrame extends JLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The panel */
	private JPanel panel;

	
	/**
	 * Builds an AvatarFrame object with the specified
	 * JPanel object
	 * @param panel A JPanel object
	 */
	public AvatarFrame(JPanel panel) {
		this.panel = panel;
	}

	
	/**
	 * Builds the AvatarFrame instance
	 */
	public AvatarFrame() {}

	
	/**
	 * Sets the panel of this object
	 * @param panel A JPanel object
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		if(this.panel != null) {
			if(icon instanceof ImageIcon) {
				Image scaledImage = ((ImageIcon)icon).getImage()
						.getScaledInstance(panel.getWidth(), 
										   panel.getHeight(), 0);
				super.setIcon(new ImageIcon(scaledImage));
			}
		}
	}
}