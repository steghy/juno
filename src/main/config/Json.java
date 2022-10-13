package main.config;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import main.log.Log;
import main.log.LogMessage;


/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
 public class Json {

	static final String METADATA = "metadata";
	static final String DATA = "data";
	static final String JSON_EXTENSION = ".json";
	
	/**
	 * @param source
	 * @return A JSONArray object
	 * @throws IOException
	 */
	public static JSONArray create(DataPackage source) 
			throws IOException {

		Log.print(LogMessage.SCONF_PROC, "JSON");
		Log.print(LogMessage.SSUPPLY_SUBPROC, METADATA);
		
		// Metadata
		JSONObject jsonMetadata = new JSONObject();
		jsonMetadata.put(METADATA, source.getMetadataObj().getAllMetadata());
		Log.print(LogMessage.ISUPP_DATA, source.getMetadataObj().getAllMetadata());
		Log.print(LogMessage.ESUPPLY_SUBPROC, METADATA);
		
		Log.print(LogMessage.SSUPPLY_SUBPROC, DATA);
		
		// Data
		JSONObject jsonData = new JSONObject();
		jsonData.put(source.getDataObj().getName(), source.getDataObj().getData());	
		Log.print(LogMessage.ISUPP_DATA, source.getDataObj().getData());
		Log.print(LogMessage.ESUPPLY_SUBPROC, DATA);	

		Log.print(LogMessage.ICONF_DATA, "JSONArray");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonMetadata);
		jsonArray.put(jsonData);

		Log.print(LogMessage.ECONF_PROC, "JSON");

		return jsonArray;
	}
    
	
	/**
	 * Creates and return a data from the specified file.
	 * @param path The path of the file
	 * @return A DataPackage instance
	 * @throws IOException
	 * @throws NoSuchFileException
	 */
	public static DataPackage loadData(String path) 
			throws IOException, NoSuchFileException {
		
		Log.print(LogMessage.SLOAD_PROC, "JSON");

		/**
		 * Controls the data first
		 */
		String source = new String(Files.readAllBytes(Paths.get(path)));

		DataPackage dataPackage = new DataPackage();
		JSONArray jsonArray = new JSONArray(source);
	
		confDataPackage(jsonArray, dataPackage);
		
		Log.print(LogMessage.ELOAD_PROC, "JSON");
		return dataPackage;
	}

	
	/**
	 * 
	 * @param jsonArray
	 * @param dataPackage
	 * @throws IOException
	 */
	@SuppressWarnings({ })
	private static void confDataPackage(JSONArray jsonArray, 
			DataPackage dataPackage) throws IOException {
		
		// getting metadata from json array
		Map<String, Object> metadata = jsonArray.getJSONObject(0).toMap();
		
		// getting data from json array
		Map<String, Object> data = jsonArray.getJSONObject(1).toMap();
			
		// prepare metadata
		setMetadata(metadata, dataPackage);
		
		// prepare data
		setData(data, dataPackage);
	
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getMetadataObj());
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getDataObj());
	}
	
		
	/**
	 * 
	 * @param jsonMetadata
	 * @param dataPackage
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void setMetadata(Map<String, Object> jsonMetadata,
			DataPackage dataPackage) {
		
		String key = (String) jsonMetadata.keySet().toArray()[0];
		Map<String, Object> metadata = (HashMap) jsonMetadata.get(key);
		
		// Local-date-time
		Optional<Object> opt1 = Optional.ofNullable(
				metadata.get(Metadata.LOCAL_DATE_TIME));
		
		if(opt1.isPresent()) {
			String localDateTime = (String) opt1.get();
			dataPackage.getMetadataObj().setLocalDateTime(localDateTime);
		}

		// Os type
		Optional<Object> opt2 = Optional.ofNullable(
				metadata.get(Metadata.OS));
		if(opt2.isPresent()) {
			String os = (String) opt2.get();
			dataPackage.getMetadataObj().setOs(os);
		}

		// Architercture
		Optional<Object> opt3 = Optional.ofNullable(
				metadata.get(Metadata.ARCH));
		if(opt2.isPresent()) {
			String arch = (String) opt3.get();
			dataPackage.getMetadataObj().setArch(arch);
		}
		
		// Version
		Optional<Object> opt4 = Optional.ofNullable(
				metadata.get(Metadata.VERSION));
		if(opt2.isPresent()) {
			String version = (String) opt4.get();
			dataPackage.getMetadataObj().setVersion(version);
		}
	}

	
	/*
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void setData(Map<String, Object> jsonData, 
			DataPackage dataPackage) throws IOException {
			
		String key = (String) jsonData.keySet().toArray()[0];
		Map<String, Object> data = (HashMap) jsonData.get(key);
		
		if (data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
			throw new IllegalArgumentException("JSONObject data empty");
		}
		else {
			Log.print(LogMessage.C_DATA_FOUND, "");
		}
		dataPackage.setData(new Data(data, key));
	}
}