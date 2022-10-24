package juno.view.audio.north;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import juno.view.exception.JButtonNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NorthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The next button */
	private JButton nextButton;
	
	/* The previous button */
	private JButton previousButton;
	
	/* The toggle switch button */
	private JButton toggleSwitchButton;
	
	/* The NorthPanel instance */
	private static NorthPanel instance;
	
	/* Builds the NorthPanel instance */
	private NorthPanel() {}
	
	/**
	 * Returns the NorthPanel instance
	 * @return The NorthPanel instance
	 */
	public static NorthPanel getInstance() {
		if(instance == null) {
			instance = new NorthPanel();
		} return instance;
	}
	
	
	/**
	 * Sets the next button of this instance
	 * @param button A JButton object
	 */
	public void setNextButton(JButton button) {
		nextButton = button;
	}
	
	
	/**
	 * Sets the previous button of this instance 
	 * @param button A JButton object
	 */
	public void setPreviousButton(JButton button) {
		previousButton = button;
	}
	
	
	/**
	 * Sets the toggle switch button of this instance
	 * @param button A JButton object
	 */
	public void setToggleButton(JButton button) {
		toggleSwitchButton = button;
	}
	
	
	/**
	 * Initialize the NorthPanel instance 
	 * @throws JButtonNotSettedException if any of the
	 * 			required button is not setted.
	 */
	public void init() throws JButtonNotSettedException {
		
		// CHECK INTEGRITY
		if(nextButton == null) {
			throw new JButtonNotSettedException();
		} if(previousButton == null) {
			throw new JButtonNotSettedException();
		} if(toggleSwitchButton == null) {
			throw new JButtonNotSettedException();
		}
		
		// ADD COMPONENT
		this.setLayout(new GridLayout(3, 1));
		this.add(previousButton, 0);
		this.add(toggleSwitchButton, 1);
		this.add(nextButton, 2);
		
		this.setOpaque(false);
	}
}