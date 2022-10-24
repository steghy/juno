package juno.view.main.menu.north;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import juno.view.exception.JLabelNotSettedException;

public class NorthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	private JLabel logo;
	
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
	 * Sets the logo of this object
	 * @param label A JLabel object
	 */
	public void setLogo(JLabel label) {
		logo = label;
	}
	
	
	/* Initialize the NorthPanel instance */
	public void init() throws JLabelNotSettedException {
		if(logo == null) {
			throw new JLabelNotSettedException();
		}
		this.add(logo);
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
	}
}