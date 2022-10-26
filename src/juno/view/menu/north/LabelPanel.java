package juno.view.menu.north;

import java.awt.*;
import java.io.Serial;

import javax.swing.*;

public class LabelPanel extends JPanel {

	/* Serial Version UID */
	@Serial
	private static final long serialVersionUID = 1L;

	/* The JLabel object, or the 'Logo' */
	private JLabel label;
	
	/* The NorthPanel instance */
	private static LabelPanel instance;

	
	/* Builds the NorthPanel instance */
	private LabelPanel() {
		init();
	}
	
	
	/**
	 * Returns the NorthPanel instance
	 * @return The NorthPanel instance
	 */
	public static LabelPanel getInstance() {
		if(instance == null) {
			instance = new LabelPanel();
		} return instance;
	}


	public void setIcon(Icon icon){
		if(icon instanceof ImageIcon){
			Image scaledImage = ((ImageIcon)icon).getImage()
					.getScaledInstance(this.getWidth(), this.getHeight(), 0);
			this.label.setIcon(new ImageIcon(scaledImage));
		}
	}

	
	/* Initialize the NorthPanel instance */
	public void init() {

		this.label = new JLabel();
		label.setOpaque(false);

		// DIMENSION
		Dimension dimension = new Dimension(300, 300);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);

		// ADD LABEL
		this.add(label);

		// SETTINGS
		this.setOpaque(false);
	}
}