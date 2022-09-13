package main.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class allows to export configuration files in
 * different formats
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Exporter {
	
	/**
	 * Generates a JSON file which contains all the informations
	 * provided by the specified exportable object.
	 * @param path Where save the file.
	 * @param obj The exportable object.
	 * @throws IOException If the parent directory of the specified
	 * path doesn't exist
	 */
	public static void exportJson(String path, Exportable obj) 
			throws IOException {
		DataPackage data = obj.provideData();
		FileWriter file = new FileWriter(new File(path));
		file.write(MyJson.create(data).toString());
		file.close();
	}

	
	/**
	 * implements 
	 * @param path A path
	 * @param obj An Exportable objectj
	 * @throws IOException if the parent directory of the specified
	 * path doesn't exist
	 */
	public static void exportYaml(String path, Exportable obj) 
			throws IOException {
		// DataPackage data = obj.provideData();
		// implements
	}
	
	
	/**
	 * implements
	 * @param path A path
	 * @param obj An Exportable object
	 * @throws IOException if the parent directory of the specified
	 * path doesn't exists
	 */
	public static void exportConfig(String path, Exportable obj) 
			throws IOException {
		// DataPackage data = obj.provideData();
		// implements
	}
}
