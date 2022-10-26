package juno.view.menu;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juno.view.exception.JButtonNotSetException;
import juno.view.exception.JLabelNotSetException;

/**
 * Frame class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class MainMenu extends JPanel {

	/** Serail Version UID */
	public static final long serialVersionUID = 1L;

	/* Frame background */
	private JLabel background;
	
	/* Icon logo */
	private JPanel northPanel;
	
	/* Center panel */
	private JPanel centerPanel;
	
	/* East Panel */
	private JPanel eastPanel;
	
	/* West Panel */
	private JPanel westPanel;
	
	/* South JPanel */
	private JPanel southPanel;
	
	/* Frame object */
	private static MainMenu instance;

	
	/* Builds a Frame object */
	private MainMenu() {}
	
	
	/**
	 * Returns the Frame instance
	 * @return The Frame instance
	 */
	public static MainMenu getInstance() {
		if(instance == null) {
			instance = new MainMenu();
		} return instance;
	}
	
	
	/**
	 * Sets the north panel of this object
	 * @param panel A JPanel object
	 */
	public void setNorthPanel(JPanel panel) {
		northPanel = panel;
	}

	
	/**
	 * Sets the center panel of this object
	 * @param panel A JPanel object
	 */
	public void setCenterPanel(JPanel panel) {
		centerPanel = panel;
	}
	
	
	/**
	 * Sets the east panel of this object
	 * @param panel A JPanel object
	 */
	public void setEastPanel(JPanel panel) {
		eastPanel = panel;
	}
	
	
	/**
	 * Sets the south panel of this object
	 * @param panel A JPanel object
	 */
	public void setSouthPanel(JPanel panel) {
		southPanel = panel;
	}
	
	
	/**
	 * Sets the west panel of this object
	 * @param panel A JPanel object
	 */
	public void setWestPanel(JPanel panel) {
		westPanel = panel;
	}
	
	
	/**
	 * Sets the background of this object
	 * @param label A JLabel object
	 */
	public void setBackground(JLabel label) {
		background = label;
	}

	
	/* Initialize the Frame instance */
	public void init() throws JButtonNotSetException, JLabelNotSetException {
		
		// Check integrity
		if(northPanel == null) {
			throw new JButtonNotSetException(""
					+ "JButton in NORTH area isn't set");
		} if(centerPanel == null) {
			throw new JButtonNotSetException(""
					+ "JButton is CENTER area isn't set");
		} if(eastPanel == null) {
			throw new JButtonNotSetException(""
					+ "JButton in EAST area isn't set");
		} if(southPanel == null) {
			throw new JButtonNotSetException(""
					+ "JButton in SOUTH area isn't set");
		} if(westPanel == null) {
			throw new JButtonNotSetException(""
					+ "JButton in WEST area isn't set");
		} if(background == null) {
			throw new JLabelNotSetException(""
					+ "JLabel background isn't set");
		}
		
		// Add components
		this.add(background);
		background.add(northPanel, BorderLayout.NORTH);
		background.add(centerPanel, BorderLayout.CENTER);
		background.add(eastPanel, BorderLayout.EAST);
		background.add(westPanel, BorderLayout.WEST);
		background.add(southPanel, BorderLayout.SOUTH);
	}
}