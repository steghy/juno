package juno.view.mainframe.center;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Menu component.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Menu extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/** Default JPanel width */
	private Dimension DEF_DIMENSION = new Dimension();
	
	/** Minimun JPanel dimension */
	private Dimension MIN_DIMENSION = new Dimension();
	
	/** Maximun JPanel dimension */
	private Dimension MAX_DIMENSION = new Dimension();
	
	/* New game button */
	private JButton newGameButton;
	
	/* Options button */
	private JButton options;
	
	/* Exit button */
	private JButton exit;
	
	/* The Menu instance */
	private static Menu instance;

	
	/* Builds the Menu instance */
	private Menu() {
		init();
	}
	

	/**
	 * Returns the Menu instance
	 * @return The Menu instance
	 */
	public static Menu getInstance() {
		if(instance == null) {
			instance = new Menu();
		} return instance;
	}
	
	
	/* Initialize the Menu instance */
	private void init() {
		// Buttons
		this.newGameButton = NewGameButton.getInstance();
		this.options = OptionsButton.getInstance();
		this.exit = ExitButton.getInstance();
	
		// Panel settings
		this.setLayout(new GridLayout(3, 1));
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
		this.setOpaque(false);
		
		// Alignment settings
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
	
		// Add components
		this.add(newGameButton);
		this.add(options);
		this.add(exit);
	}


}
