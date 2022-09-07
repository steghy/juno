package main.view;
/**
 * Classe per la gestione della immagine imposta con
 * background
 * @author steghy
 *
 */
public class Backgroud {

	//percorso della immagine
	String path;
	
	//larghezza della immagine
	int width;
	
	//lunghezza della immagine
	int height;
	
	//costruisce il profilo digitale della immagine
	Backgroud(String path) {
		this.path = path;
	}
	
	//imposta il percorso della immagine
	void setPath(String path) {
		this.path = path;
	}
	
	//imposta il valore di larghezza
	void setWidth(int width) {
		this.width = width;
	}
	
	//imposta il valore della lunghezza
	void setHeight(int height) {
		this.height = height;
	}
	
	//ritorna il percorso della immagine
	String getPath() {
		return path;
	}
	
	//restituisce la larghezza della immagine
	int getWidth() {
		return this.width;
	}
	
	//restituisce la lunghezza della immagine
	int getHeight() {
		return this.height;
	}
}
