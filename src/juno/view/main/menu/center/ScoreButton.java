package juno.view.main.menu.center;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ScoreButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* ScoreButton instance */
	private static ScoreButton instance;
		
	
	/* Builds the ScoreButton instance */
	private ScoreButton() {
		init();
	}

	
	/**
	 * Returns the ScoreButton instance
	 * @return The ScoreButton instance
	 */
	public static ScoreButton getInstance() {
		if(instance == null) {
			instance = new ScoreButton();
		} return instance;
	}
	
	
	@Override
	public void setIcon(Icon icon) {
		if(icon instanceof ImageIcon) {
			ImageIcon temp = (ImageIcon) icon;
			temp.setImage(temp.getImage()
					.getScaledInstance(temp.getIconWidth() / 3,
									   temp.getIconHeight() / 3, 0));
			super.setIcon(temp);
		}
	}
	
	
	/* Initialize the ScoreButton instance */
	private void init() {

		// Button settings
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}
