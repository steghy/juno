package main.util;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author steghy
 *
 */
public class PathGenerator {
	
	// unix-like
	private static final String DEFAULT_DIV = "/";
		
	// windows
	private static final String INVERTED_DIV = "\\";

	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static String generate(String filename) {
		String path = Os.getCurrentPath();
		path += (Os.isUnix()==true?DEFAULT_DIV:INVERTED_DIV);
		return path.concat(filename);
	}
	
	
	/**
	 * 
	 * @param src
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String generate(String src, String fileName) throws IOException {
		File file = new File(src);
		if(file.exists()) {
			if(file.isDirectory()) {
				String div = (Os.isUnix() == true ? DEFAULT_DIV : INVERTED_DIV);
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
