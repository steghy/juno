package main.config;

import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Loader {
	
	/**
	 * 
	 * @param data
	 * @param obj
	 * @throws IOException
	 */
	public static void load(DataPackage data, Configurable obj) throws IOException {
		obj.configure(data);
	}
}
