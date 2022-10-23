package juno.view.user;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AvatarPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	public static final Dimension DEF_DIMENSION = new Dimension(75, 75);
	
	
	/** Builds an AvatarPanel object */
	public AvatarPanel() {
		init();
	}
	
	/* Initialize this AvatarPanel object */
	private void init() {

		// Background Settings
		this.setOpaque(false);
	}


}
