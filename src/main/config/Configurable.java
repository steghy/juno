package main.config;

import java.io.IOException;

/**
 * This class defines configurable class
 * @author steghy
 * @email steghy.github@proton.me
 */
public interface Configurable {
		
	/**
	 * It configures the configurable object with
	 * the specified DapaPackage object. 
	 * @param data A DataPackage 
	 * @throws IOException
	 */
	void configure(DataPackage data) throws IOException;
}
