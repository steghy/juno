package juno.view.audio.north;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.JPanel;
import juno.view.exception.*;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NorthPanel extends JPanel {

	/* Serial Version UID */
	@Serial
	private static final long serialVersionUID = 1L;
	
	/* The next panel */
	private JPanel nextPanel;
	
	/* The previous panel */
	private JPanel previousPanel;
	
	/* The toggle switch panel */
	private JPanel toggleSwitchPanel;
	
	/* The NorthPanel instance */
	private static NorthPanel instance;
	
	/* Builds the NorthPanel instance */
	private NorthPanel() {

		// DIMENSION
		this.setSize(new Dimension(275, 120));
		this.setPreferredSize(new Dimension(275, 120));
		this.setMinimumSize(new Dimension(275, 120));
		this.setMaximumSize(new Dimension(275, 120));
	}
		
	
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
	 * Sets the 'next' panel of this instance
	 * @param panel A JPanel object
	 */
	public void setNextPanel(JPanel panel) {
		nextPanel = panel;
	}
	
	
	/**
	 * Sets the 'previous' panel of this instance
	 * @param panel A JPanel object
	 */
	public void setPreviousPanel(JPanel panel) {
		previousPanel = panel;
	}
	
	
	/**
	 * Sets the 'toggle switch' panel of this instance 
	 * @param panel A JPanel object
	 */
	public void setTogglePanel(JPanel panel) {
		toggleSwitchPanel = panel;
	}


	/**
	 * Initialize the NorthPanel instance
	 * @throws JPanelNotSetException description here
	 */
	public void init() throws JPanelNotSetException {
		
		// CHECK INTEGRITY
		if(nextPanel == null) {
			throw new JPanelNotSetException("JPanel isn't set");
		} if(previousPanel == null) {
			throw new JPanelNotSetException("JPanel isn't set");
		} if(toggleSwitchPanel == null) {
			throw new JPanelNotSetException("JPanel isn't set");
		}

		// SETTINGS
		this.setLayout(new GridLayout(1, 3, 0, 0));
		this.previousPanel.setOpaque(false);
		this.nextPanel.setOpaque(false);
		this.toggleSwitchPanel.setOpaque(false);

		this.nextPanel.setSize(new Dimension(5, 20));
		this.previousPanel.setSize(new Dimension(5, 20));
		this.toggleSwitchPanel.setSize(new Dimension(5, 20));

		// ADD COMPONENTS
		this.add(previousPanel, 0);
		this.add(toggleSwitchPanel, 1);
		this.add(nextPanel, 2);
		this.setOpaque(false);
	}
}