package main.util;

import java.io.File;
import java.io.IOException;

/**
 * Classe per la generazione di percorsi
 * @author steghy
 *
 */
public class PathGenerator {
	
	//mac/linux div
	private static final String DEFAULT_DIV = "/";
		
	//win div
	private static final String INVERTED_DIV = "\\";
	
	//genera un percorso con dir corrente
	public static String generate(String filename) {
		String path = Os.getCurrentPath();
		path += (Os.isLinux()==true?DEFAULT_DIV:INVERTED_DIV);
		return path.concat(filename);
	}
	
	//genera un percorso arbitrario
	public static String generate(String src, String fileName) throws IOException {
		File file = new File(src);
		
		if(file.exists()) {
			if(file.isDirectory()) {
				String div = (Os.isLinux() == true ? DEFAULT_DIV : INVERTED_DIV);
				return src.concat(div).concat(fileName);
			}
			else {
				throw new IllegalArgumentException("not a directory");
			}
		}
		else {
			throw new IOException("not exists");
		}
	}
	
	

}
