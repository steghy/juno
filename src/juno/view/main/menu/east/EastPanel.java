package juno.view.main.menu.east;

import javax.swing.JPanel;

import juno.view.exception.FactoryNotSettedException;

public class EastPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* AudioPlayer panel */
	private static AbstractAudioPlayerFactory audioPlayerFactory;
	
	/* The SouthPanel instance */
	private static EastPanel instance;


	/* Builds SouthPath instance */
	private EastPanel() {}

	
	/**
	 * Returns the SouthPanel instance
	 * @return The SouthPanel instance
	 */
	public static EastPanel getInstance() {
		if(instance == null) {
			instance = new EastPanel();
		} return instance;
	}
	
	/**
	 * Sets the AudioPlayerFactory of this instance
	 * @param factory An AbstractAudioPlayerFactory object
	 */
	public static void setAudioPlayerPanelFactory(AbstractAudioPlayerFactory factory) {
		audioPlayerFactory = factory;
	}
	
	
	/* Initialize the SouthPanel instance */
	public void init() throws FactoryNotSettedException {
		
		// Check if AudioPlayerFactory is present
		if(audioPlayerFactory == null) {
			throw new FactoryNotSettedException();
		} else {
			this.add(audioPlayerFactory.getAudioPlayerPanel());
		}
		
		// Opaque
		this.setOpaque(false);
	}
}
