package main.util;

import java.io.File;
import java.io.IOException;

/*
 * Classe per la creazioni di file all'interno del sistema 
 * operativo
 */
public class FileGenerator {		
	
	
	/**
	 * Crea una cartella nel percorso indicato. Se esiste,
	 * sovrascrive la cartella.
	 * @param path Il percorso di file
	 * @throws IOException 
	 */
	public static void mkdirOverwrite(String path) throws IOException {
		
		File file = new File(path);
		
		if(file.exists()) {
			if(file.isDirectory()) {
				deleteRecursive(path);
			}
			else {
				throw new IllegalArgumentException("Not a directory");
			}
		}
		file.mkdir();
	}
	
	/**
	 * Crea una cartella nel percorso indicato. Se esiste,
	 * genera un nuovo nome di cartella e genera la medesima
	 * nel percorso indicato
	 * @param path Il percorso del file
	 */
	public static void mkdirWithoutOverwrite(String path) {
		
		File file = new File(path);
		
		if(new File(path).exists()) {
			
			String newPath = getNewPath(path, 1);
			
			file = new File(newPath);
		}
		
		file.mkdir();
	}
	
	/**
	 * Cancella ricorsivamente ogni file e directory all'interno
	 * del percorso specificato.
	 * @param path Un percorso 
	 * @throws IOException In caso il percorso non esista 
	 */
	private static void deleteRecursive(String path) throws IOException {
		
		File file = new File(path);
		
		if(file.isFile()) {
			
			//dovrebbe cancellare il file
			file.delete();
			return;
		}
		
		//altrimenti è una directory
		for(String fileName : file.list()) {
			
			String newPath = PathGenerator.generate(path, fileName);
			File newFile = new File(newPath);			
			
			if(newFile.isFile()) {

				//dovrebbe cancella il file
				newFile.delete();
				
			}
			
			else {
				deleteRecursive(newPath);
			}
		}
		
		//cancella la directory
		file.delete();
	}
	
	/**
	 * Invocato quando si tenta di creare un file il cui nome
	 * è già presente all'interno dello stesso percorso. Inserisce
	 * in coda al nome del file un numero intero. Il numero intero
	 * è ricavato sommando 1 ad esso ogni volta che viene rilevato 
	 * un nome di file uguale.
	 * @param path Il percorso in cui deve essere scritto il file
	 * @param value Dovrebbe partire da 0
	 * @return Un percorso di file
	 */
	private static String getNewPath(String path, int value) {
		
		//aggiunge il numero al percorso
		String newPath = path + value;
		
		//se esiste, incrementa il numero
		if(new File(newPath).exists()) {
			
			value++;
			return getNewPath(path, value);
		}
		
		return newPath;
	}
	
	
	
}
