package main.config;

import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public interface Exportable {
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public DataPackage provideData() throws IOException;
}
