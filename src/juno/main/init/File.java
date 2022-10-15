package juno.main.init;

import juno.annotation.A_Generable;

/**
 * File object list.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum File {
	
	@A_Generable
	PATHS,
	
	/**
	 * Contains the default values
	 * for the initialization of 
	 * the program ( screen size,
	 * card cover, ... ).
	 */
	@A_Generable
	CONFIG,
	
	/**
	 * Contains all the informations
	 * about the last connected user.
	 */
	USER_DATA,
	
	/**
	 * Contains the user values
	 * for the initialization of 
	 * the program (screen size,
	 * card cover, ... ).
	 */
	USER_CONFIG;

	java.io.File file; 

	/*
	 * Builds the File object with 
	 * the specified path
	 */
	private File() {}
	
	
	/**
	 * Returns the path of this file
	 * @return The path of this file
	 */
	java.io.File getFileObject() {
		return this.file;
	}
}