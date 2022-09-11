package main.util;

import java.io.File;

/**
 * This class defines some utility methods for 
 * checking the system and files on the disk.
 * @author steghy
 */
public class Os {
	
	/**
	 * Returns the OS name
	 * @return The OS name
	 */
	public static String getName() {
		return System.getProperty("os.name");
	}
	
	
	/**
	 * Returns the OS version
	 * @return The OS version
	 */
	public static String getVersion() {
		return System.getProperty("os.version");
	}
	
	
	/**
	 * Returns the OS architecture 
	 * @return The OS architecture
	 */
	public static String getArch() {
		return System.getProperty("os.arch");
	}
	
	
	/**
	 * Returns true if the OS is Windows, otherwise
	 * returns false
	 * @return A boolean
	 */
	public static boolean isWindows() {
		return getName().startsWith("Linux");
	}
	
	
	/**
	 * Returns true if the OS is Unix-like, otherwise
	 * returns false 
	 * @return A boolean
	 */
	public static boolean isUnix() {
		return getName().startsWith("Linux") ||
				getName().startsWith("Mac Os X");
	}
	
	
	/**
	 * Returns the current path of this project
	 * @return The current path of this project
	 */
	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}
	

	/**
	 * Returns true if the path exists, otherwise
	 * returns false
	 * @param path A file path
	 * @return A boolean
	 */
	public static boolean exists(String path) {
			return new File(path).exists();
	}
	
	
	/**
	 * Returns true is the path is a directory, otherwise
	 * returns false 
	 * @param path A file path
	 * @return A boolean
	 */
	public static boolean isDir(String path) {
		return new File(path).isDirectory();
	}
	
	
	/**
	 * Returns true if the path is a file, otherwise
	 * returns false 
	 * @param path A file path
	 * @return A boolean
	 */
	public static boolean isFile(String path) {
		return new File(path).isFile();
	}
}
