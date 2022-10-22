package juno.view.mainframe.north;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* Default Dimension */
	private Dimension DEF_DIMENSION = new Dimension(250, 500);
	
	/* Preferred Dimension */
	private Dimension PRF_DIMENSION = new Dimension(500, 350);
	
	/* Minimun Dimension */
	private Dimension MIN_DIMENSION = new Dimension(200, 500);
	
	/* Maximun Dimension */
	private Dimension MAX_DIMENSION = new Dimension(500, 500);
	
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
		
		this.setLayout(new BorderLayout());

		// Logo
		Logo logo = Logo.getInstance();
		JLabel emptyLabel = new JLabel();
	
		this.add(logo, BorderLayout.CENTER);
		this.add(emptyLabel, BorderLayout.NORTH);
		this.setOpaque(false);

		// Dimension settings
		this.setPreferredSize(PRF_DIMENSION);
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
	}
}
