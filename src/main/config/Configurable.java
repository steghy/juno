package main.config;

import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public interface Configurable {
		
	/**
	 * 
	 * @param data
	 * @throws IOException
	 */
	public void configure(DataPackage data) throws IOException;
}
