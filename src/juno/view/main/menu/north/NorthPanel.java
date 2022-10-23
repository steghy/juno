package juno.view.main.menu.north;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* Default Dimension */
	private Dimension DEF_DIMENSION = new Dimension(400, 400);
	
	/* Preferred Dimension */
	private Dimension PRF_DIMENSION = new Dimension(400, 400);
	
	/* Minimun Dimension */
	private Dimension MIN_DIMENSION = new Dimension(0, 0);
	
	/* Maximun Dimension */
	private Dimension MAX_DIMENSION = new Dimension(0, 0);
	
	/* The NorthPanel instance */
	private static NorthPanel instance;

	
	/* Builds the NorthPanel instance */
	private NorthPanel() {
		init();
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

	
	@Override
	public void setPreferredSize(Dimension dimension) {
		super.setPreferredSize(dimension);
	}
	
	/* Initialize the NorthPanel instance */
	private void init() {
	
		// Setting Layout
		this.setLayout(new BorderLayout());

		// Logo
		Logo logo = Logo.getInstance();
		
		// Add component
		this.add(logo);
		
		// Background settings
		this.setOpaque(false);

		// Dimension settings
		this.setPreferredSize(PRF_DIMENSION);
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
	}
}
