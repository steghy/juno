package juno.main.init;

import java.io.FileNotFoundException;
import java.util.HashMap;
import juno.annotation.ConfigurableAnnotation;
import juno.annotation.GenerableAnnotation;
import juno.exception.DataException;
import juno.model.util.Os;

/**
 * File object list.
 * @author steghy
 * @email steghy.github@proton.me
 */
@ConfigurableAnnotation
public enum File implements Configurable {
	
	/**
	 * Contains the default values
	 * for the initialization of 
	 * the program ( screen size,
	 * card cover, ... ).
	 */
	@GenerableAnnotation
	CONFIG(""),
	
	/**
	 * Contains all the informations
	 * about the last connected user.
	 */
	USER_DATA(""),
	
	/**
	 * Contains the user values
	 * for the initialization of 
	 * the program (screen size,
	 * card cover, ... ).
	 */
	USER_CONFIG("");
	
	/* File path */
	private String path;

	
	/*
	 * Builds the File object with 
	 * the specified path
	 */
	private File(String path) {
		this.path = path;
	}
	
	
	/**
	 * Returns the path of this file
	 * @return The path of this file
	 */
	String getPath() {
		return this.path;
	}
	
	
	/**
	 * Sets the path of this file
	 * @param path
	 */
	void setPath(String path) {
		this.path = path;
	}

	
	/**
	 * Returns the name of this file
	 * @return The name of this file
	 */
	String getName() {
		char div = this.path.charAt(0);
		String[] names;
		if(div == '/') {
			names = this.path.split("/");
		} else {
			names = this.path.split("\\");
		} return names[names.length-1];
	}


	@Override
	public void configure(Data data) throws DataException, FileNotFoundException {
		Object temp = data.getData().get("paths");
		if(temp instanceof HashMap) {
			 String path = (String) ((HashMap<?, ?>) temp).get(this.name().toLowerCase());
			 if(Os.isFile(path)) {
				 this.path = path;
			 } else {
				 throw new FileNotFoundException();
			 }
		} else {
			throw new DataException();
		}
	}
}