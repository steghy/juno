package main.config;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class DataProvider {
	
	/**
	 * 
	 * @param path A path
	 * @return A DataPackage
	 * @throws IOException
	 */
	public static DataPackage load(String path) throws IOException{
		File file = new File(path);
		if(file.exists()){
			if(file.isFile()) {
				if(path.endsWith(Json.JSON_EXTENSION)) {
					return Json.loadData(path);
				}
				else {
					throw new IllegalArgumentException("the file needs"
							+ "to be a json file");
				}
			}
			else {
				throw new IllegalArgumentException(path + " needs"
						+ "to be a file");
			}
		}
		else {
			throw new IOException("the file " + path 
					+ "not exists.");
		}
	}
}
