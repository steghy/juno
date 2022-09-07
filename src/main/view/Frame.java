package main.view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	//valore di default generato
	private static final long serialVersionUID = 1L;
	
	//larghezza di default del frame
	private final int DEFAULT_WIDTH=800;
	
	//lunghezza di default del frame
	private final int DEFAULT_HEIGHT=600;
	
	//titolo di default della finestra
	private final String TITLE = "juno";
	
	/**
	 * Costruisce il frame principale della
	 * applicazione.
	 */
	public Frame() {
		//impostando il frame con valori di default.
		init();
	}
	
	/**
	 * Imposta il frame con valori di default.
	 */
	private void init() {
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setTitle(TITLE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
