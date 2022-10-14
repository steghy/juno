package juno.model.util;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class FileGenerator {		
	
	
	/**
	 * 
	 * @param path
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
	 * 
	 * @param path
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
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static void deleteRecursive(String path) throws IOException {
		
		File file = new File(path);
		
		if(file.isFile()) {
			file.delete();
			return;
		}
		for(String fileName : file.list()) {
			String newPath = PathGenerator.generate(path, fileName);
			File newFile = new File(newPath);			
			if(newFile.isFile()) {
				newFile.delete();
			}
			else {
				deleteRecursive(newPath);
			}
		}
		file.delete();
	}
	
	/**
	 * 
	 * @param path
	 * @param value
	 * @return
	 */
	private static String getNewPath(String path, int value) {
		String newPath = path + value;
		if(new File(newPath).exists()) {
			value++;
			return getNewPath(path, value);
		}
		return newPath;
	}
	
	
	
}
