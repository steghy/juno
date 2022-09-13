package main.config;

import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public interface Exportable{
	
	/**
	 * 
	 * @return A DataPackage
	 * @throws IOException
	 */
	public DataPackage provideData() throws IOException;
}
