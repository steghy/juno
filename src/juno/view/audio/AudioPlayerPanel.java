package juno.view.audio;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import juno.view.exception.JLabelNotSettedException;
import juno.view.exception.JPanelNotSettedException;

/**
 * PlayerPanel Class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* AudioPlayerPanel instance */
	private static AudioPlayerPanel instance;

	/* Audio Player panel backgroud */
	private JLabel background;

	/** North panel */
	private JPanel northPanel;
	
	/* South panel */
	private JPanel southPanel;
	
	/* Builds AudioPlayerPanel instance */
	private AudioPlayerPanel() {}

	
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
	 * @throws JPanelNotSettedException 
	 * @throws JLabelNotSettedException 
	 */
	public void init() throws JPanelNotSettedException, JLabelNotSettedException {
		
		// CHECK INTEGRITY
		if(northPanel == null) {
			throw new JPanelNotSettedException();
		} if(southPanel == null) {
			throw new JPanelNotSettedException();
		} if(background == null) {
			throw new JLabelNotSettedException();
		}
		
		// DIMENSION
		this.setSize(new Dimension(400, 200));
		this.setPreferredSize(new Dimension(400, 200));
		this.setMinimumSize(new Dimension(400, 200));
		this.setMaximumSize(new Dimension(400, 200));
		
		// ADD COMPONENTS
		background.setLayout(new BorderLayout());
		background.add(northPanel, BorderLayout.NORTH);
		background.add(southPanel, BorderLayout.SOUTH);
		
	}
}