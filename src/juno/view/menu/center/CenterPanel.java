package juno.view.menu.center;

import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.JButton;
import javax.swing.JPanel;
import juno.view.exception.JButtonNotSetException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CenterPanel extends JPanel {

	/* Serial Version UID */
	@Serial
	private static final long serialVersionUID = 1L;
	
	/* New game button */
	private JButton newGameButton;
	
	/* Options button */
	private JButton optionsButton;
	
	/* Score button */
	private JButton scoreButton;
	
	/* Exit button */
	private JButton exitButton;
	
	/* The CenterPanel instance */
	private static CenterPanel instance;

	
	/* Builds the CenterPanel instance */
	private CenterPanel() {}


	/**
	 * Returns the CenterPanel instance
	 * @return The Menu instance
	 */
	public static CenterPanel getInstance() {
		if(instance == null) {
			instance = new CenterPanel();
		} return instance;
	}


	/**
	 * Sets the new game button of this object
	 * @param button A JButton object
	 */
	public void setNewGameButton(JButton button) {
		newGameButton = button;
	}

	
	/**
	 * Sets the options button of this object
	 * @param button A JButton object
	 */
	public void setOptionsButton(JButton button) {
		optionsButton = button;
	}

	
	/**
	 * Sets the score button of this object
	 * @param button A JButton object
	 */
	public void setScoreButton(JButton button) {
		scoreButton = button;
	}

	
	/**
	 * Sets the exit button of this object 
	 * @param button A JButton object
	 */
	public void setExitButton(JButton button) {
		exitButton = button;
	}


	/**
	 * Initialize the CenterPanel instance
	 * @throws JButtonNotSetException description here
 	 */
	public void init() throws JButtonNotSetException {

		if(newGameButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'new game' isn't set");
		} if(optionsButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'options' isn't set");
		} if(scoreButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'score' isn't set");
		} if (exitButton == null) {
			throw new JButtonNotSetException(""
					+ "JButton 'exit' isn't set");
		}

		// Layout Settings
		this.setLayout(new GridLayout(3, 1, 0, 0));
		
		// Add components
		this.add(newGameButton);
		this.add(optionsButton);
		this.add(scoreButton);
		this.add(exitButton);

		// Background Settings
		this.setOpaque(false);
		
		// Alignment settings
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
	}
}