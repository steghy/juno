package main.util;

import java.io.IOException;

/**
 * Classe per i test della classe FileGenerator
 * @author steghy
 *
 */
public class FileGeneratorTest {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "test1";
		
		String path = PathGenerator.generate(fileName);
		
		//creazione di file
		//FileGenerator.makeFile(path);
	
		//creazione di cartella	
		FileGenerator.mkdirOverwrite(path);
		
	}

}
