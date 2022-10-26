package juno.view.audio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juno.view.exception.JLabelNotSetException;
import juno.view.exception.JPanelNotSetException;

/**
 * PlayerPanel Class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerPanel extends JPanel {

	/* Serial Version UID */
	@Serial
	private static final long serialVersionUID = 1L;
	
	/* AudioPlayerPanel instance */
	private static AudioPlayerPanel instance;

	/* Audio Player panel background */
	private JLabel background;

	/** North panel */
	private JPanel northPanel;
	
	/* South panel */
	private JPanel southPanel;
	
	/* Builds AudioPlayerPanel instance */
	private AudioPlayerPanel() {
		
		// DIMENSION
		this.setSize(new Dimension(350, 200));
		this.setPreferredSize(new Dimension(350, 200));
		this.setMinimumSize(new Dimension(210, 140));
		this.setMaximumSize(new Dimension(210, 140));
		
	}

	
	/**
	 * Returns the AudioPlayerPanel instance
	 * @return The AudioPlayerPanel instance
	 */
	public static AudioPlayerPanel getInstance() {
		if(instance == null) {
			instance = new AudioPlayerPanel();
		} return instance;
	}

	
	/**
	 * Sets the background of this instance
	 * @param label A JLabel object
	 */
	public void setBackground(JLabel label) {
		background = label;
	}

	
	/**
	 * Sets the north panel of this instance
	 * @param panel A JPanel object
	 */
	public void setNorthPanel(JPanel panel) {
		northPanel = panel;
	}
	
	
	/**
	 * Sets the south panel of this instance
	 * @param panel A JPanel object
	 */
	public void setSouthPanel(JPanel panel) {
		southPanel = panel;
	}
	
	
	/**
	 * Initialize the AudioPlayerPanel instance 
	 * @throws JPanelNotSetException description here
	 * @throws JLabelNotSetException description here
	 */
	public void init() throws JPanelNotSetException, JLabelNotSetException {
		
		// CHECK INTEGRITY
		if(northPanel == null) {
			throw new JPanelNotSetException(""
					+ "Panel in NORTH area isn't set");
		} if(southPanel == null) {
			throw new JPanelNotSetException(""
					+ "Panel in SOUTH area isn't set");
		} if(background == null) {
			throw new JLabelNotSetException(""
					+ "Label background isn't set");
		}
		
		// ALIGNMENTS
		background.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		background.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		
		// ADD COMPONENTS
		background.setLayout(new BorderLayout());
		background.add(northPanel, BorderLayout.NORTH);
		background.add(southPanel, BorderLayout.SOUTH);
		this.add(background);

	}
}