package juno.view.main.menu.center;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Default Dimension */
	private Dimension DEF_DIMENSION = new Dimension(0, 0);
	
	/* Preferred Dimension */
	private Dimension PRF_DIMENSION = new Dimension(0, 0);
	
	/* Minimun Dimension */
	private Dimension MIN_DIMENSION = new Dimension(0, 0);
	
	/* Maximun Dimension */
	private Dimension MAX_DIMENSION = new Dimension(0, 0);
	
	/* Instance */
	private static ExitButton instance;
		
	
	/* Builds the ExitButton instance */
	private ExitButton() {
		init();
	}
	
	/**
	 * Returns the ExitButton instance
	 * @return The ExitButton instance
	 */
	public static ExitButton getInstance() {
		if(instance == null) {
			instance = new ExitButton();
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
	
	
	/* Initialize the ExitButton instance */
	private void init() {
		
		// Dimensions
		this.setSize(DEF_DIMENSION);
		this.setPreferredSize(PRF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);	

		// Trasparent button
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}
