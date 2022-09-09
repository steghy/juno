package main.config;

import java.io.IOException;

/**
 * This class is used for the creation of configuration files.
 * Actually the only supported file type is: JSON.
 * @author steghy
 *
 */
public class Exporter {
	
	/**
	 * Generates a JSON file which contains all the informations
	 * provided by the specified exportable object.
	 * @param path Where save the file.
	 * @param obj The exportable object.
	 * @throws IOException If the parent directory of the specified
	 * path doesn't exist.
	 */
	public static void exportJson(String path, Exportable obj) 
			throws IOException {
		DataPackage data = obj.provideData();
		MyJson.create(path, data);
	}
	
	public static void exportYaml(String path, Exportable obj) 
			throws IOException {
		DataPackage data = obj.provideData();
		// implements
	}
	
	public static void exportConfig(String path, Exportable obj) 
			throws IOException {
		DataPackage data = obj.provideData();
		// implements
	}
}
