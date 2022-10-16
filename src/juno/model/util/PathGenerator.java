package juno.model.util;

/**
 * Questa classe permette di generare
 * percorsi per file nel disco. I divisori
 * utilizzati per formare il percorso vengono 
 * gestiti automaticamente da questa classe.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class PathGenerator {
	
	/* Unix divisor */
	private static final String DEFAULT_DIV = "/";
		
	/* Windows divisor */
	private static final String INVERTED_DIV = "\\";

	
	/**
	 * Genera un percorso unendo il fileName al
	 * valore di ritorno del metodo System.getCurrentPath()
	 * @param fileName Il nome del file
	 * @return Il percorso 
	 */
	public static String generate(String fileName) {
		String path = Os.getCurrentPath();
		path += (Os.isUnix() == true ? DEFAULT_DIV : INVERTED_DIV);
		return path.concat(fileName);
	}
	
	
	/**
	 * Genera un percorso concatenando le due stringhe in 
	 * input con il divisore ottenuto sulla base del tipo
	 * del Sistema Operativo
	 * @param src Percosto sorgente
	 * @param fileName Il nome del file
	 * @return Il percorso
	 */
	public static String generate(String src, String fileName) {
		String div = (Os.isUnix() == true ? DEFAULT_DIV : INVERTED_DIV);
		return src.concat(div).concat(fileName);
	}
}