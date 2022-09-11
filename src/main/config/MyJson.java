package main.config;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import main.log.messages.LogMessage;
import main.log.main.Log;


/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
 public class MyJson {

	static final String METADATA = "metadata";
	static final String DATA = "data";
	static final String JSON_EXTENSION = ".json";
	
	/**
	 * 
	 * @param path
	 * @param source
	 * @throws IOException
	 */
	public static void create(String path, DataPackage source) 
			throws IOException {

		Log.print(LogMessage.SCONF_PROC, "JSON");
		Log.print(LogMessage.SSUPPLY_SUBPROC, METADATA);
		
		// metadata
		JSONObject jsonMetadata = new JSONObject();
		jsonMetadata.put(METADATA, source.getMetadata());
		Log.print(LogMessage.ISUPP_DATA, source.getMetadata());
		Log.print(LogMessage.ESUPPLY_SUBPROC, METADATA);
		
		Log.print(LogMessage.SSUPPLY_SUBPROC, DATA);
		
		// data
		JSONObject jsonData = new JSONObject();
		jsonData.put(source.getName(), source.getData());	
		Log.print(LogMessage.ISUPP_DATA, source.getData());
		Log.print(LogMessage.ESUPPLY_SUBPROC, DATA);	

		Log.print(LogMessage.ICONF_DATA, "JSONArray");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonMetadata);
		jsonArray.put(jsonData);

		FileWriter file = new FileWriter(path);
		file.write(jsonArray.toString());
		file.flush();  // i really need this ? 
		file.close();

		Log.print(LogMessage.ECONF_PROC, "JSON" 
				+ " json file writing completed");

	}
    
	
	/**
	 * 
	 * @param path
	 * @return A DataPackage instance
	 * @throws IOException
	 * @throws NoSuchFileException
	 */
	public static DataPackage loadData(String path) 
			throws IOException, NoSuchFileException {
		
		Log.print(LogMessage.SLOAD_PROC, "JSON");

		String source = new String(Files.readAllBytes(Paths.get(path)));

		DataPackage dataPackage = new DataPackage("");
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
	
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getMetadata());
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getData());
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
		Map<String, Object> metadata = (HashMap)jsonMetadata.get(key);
		
		// local-date-time
		Optional<Object> opt1 = Optional.ofNullable(
				metadata.get(DataPackage.LOCAL_DATE_TIME));
		if(opt1.isPresent()) {
			String localDateTime = (String) opt1.get();
			dataPackage.setLocalDateTime(localDateTime);
		}

		// os type
		Optional<Object> opt2 = Optional.ofNullable(
				metadata.get(DataPackage.OS));
		if(opt2.isPresent()) {
			String os = (String) opt2.get();
			dataPackage.setOs(os);
		}

		// architercture
		Optional<Object> opt3 = Optional.ofNullable(
				metadata.get(DataPackage.ARCH));
		if(opt2.isPresent()) {
			String arch = (String) opt3.get();
			dataPackage.setArch(arch);
		}
		
		// version
		Optional<Object> opt4 = Optional.ofNullable(
				metadata.get(DataPackage.VERSION));
		if(opt2.isPresent()) {
			String version = (String) opt4.get();
			dataPackage.setVersion(version);
		}
	}

	
	/**
	 * 
	 * @param jsonData
	 * @param dataPackage
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setData(Map<String, Object> jsonData, 
			DataPackage dataPackage) throws IOException {
			
		String key = (String) jsonData.keySet().toArray()[0];
		Map<String, Object> data = (HashMap) jsonData.get(key);
		
		if (data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
			throw new IllegalArgumentException("JSONObject data empty");
		}

		else {
			Log.print(LogMessage.C_DATA_FOUND, "");
			dataPackage.setData(data);
		}
		
		dataPackage.setName(key);
		
	}

}
