package juno.view.card;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * AbstractCardButton class.
 * @author steghy
 * @email steghy.github@proton.me
 */
abstract class AbstractCardButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			Image scaledImage = ((ImageIcon)icon)
								.getImage()
								.getScaledInstance(getCardHeight(), 
												   getCardWidth(), 
												   getCardHints());
			super.setIcon(new ImageIcon(scaledImage));
		}
	}
	
	abstract int getCardWidth();
	
	abstract int getCardHeight();
	
	abstract int getCardHints();
	
	
}
