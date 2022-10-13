package main.config;

import java.io.IOException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public interface Exportable{
	
	/**
	 * 
	 * @return A DataPackage
	 * @throws IOException
	 */
DataPackage provideData() throws IOException;
}
