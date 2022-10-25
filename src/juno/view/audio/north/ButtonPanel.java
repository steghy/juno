package juno.view.audio.north;

import javax.swing.JButton;
import javax.swing.JPanel;

import juno.view.exception.JButtonNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ButtonPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* A JButton */
	private JButton button;

	
	/** Builds an empty ButtonPanel object */
	public ButtonPanel() {
		this.setSize(70, 100);
		this.setOpaque(false);
	}

	
	/**
	 * Builds a ButtonPanel object with the specified
	 * JButton object
	 * @param button A JButton object
	 */
	public ButtonPanel(JButton button) {
		this.setSize(70, 100);
		this.button = button;
	}
	

	/**
	 * Sets the button for this object 
	 * @param button A JButton object
	 */
	public void setButton(JButton button) {
		this.button = button;
	}

	
	/**
	 * Initialize this object
	 * @throws JButtonNotSettedException
	 */
	public void init() throws JButtonNotSettedException {
		
		// CHECK INTEGRITY
		if(this.button == null) {
			throw new JButtonNotSettedException(""
					+ "JButton isn't setted");
		}

		// ADD COMPONENT
		this.add(this.button);
	}
}