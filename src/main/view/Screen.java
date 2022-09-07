package main.view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;


/**
 * Classe per la ricezione di informazioni riguardanti
 * lo schermo attualmente in uso nella macchina in cui
 * è in esecuzione il programma
 * @author steghy
 */
public class Screen{
	
	static GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
	static int width =  graphicsDevice.getDisplayMode().getWidth();
	static int height = graphicsDevice.getDisplayMode().getHeight();
	
	/**
	 * Restituisce la larghezza dello schermo in pixel
	 * @return La larghezza dello schermo
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Restituisce l'altezza in pixel dello schermo
	 * @return L'altezza dello schermo
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Ritorna la risoluzione dello schermo in formato dpi.
	 * @return DPI dello schermo
	 */
	public int getDpi() {
		return dpi;
	}
}
