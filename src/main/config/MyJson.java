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
 * Classe per la creazione e il caricamento di file di tipo json
 * 
 * @author steghy
 */
 public class MyJson {

	/** costanti da utilizzare per la creazione dei file */
	public static final String METADATA = "metadata";
	public static final String DATA = "data";
	public static final String JSON_EXTENSION = ".json";
	public static final String JSON_PROCESS = "{JSON}";

	/**
	 * Crea un file json contenente i dati specificati all'interno del percorso
	 * specificato
	 * 
	 * @param path   Il percorso
	 * @param source Le informazioni
	 * @throws IOException
	 */
	public static void create(String path, DataPackage source) throws IOException {

		Log.print(LogMessage.SCONF_PROC, JSON_PROCESS);

		// metadati
		Log.print(LogMessage.SSUPPLY_SUBPROC, METADATA);
		JSONObject jsonMetadata = new JSONObject();
		jsonMetadata.put(METADATA, source.getMetadata());
		Log.print(LogMessage.ISUPP_DATA, source.getMetadata());
		Log.print(LogMessage.ESUPPLY_SUBPROC, METADATA);
		
		// data
		Log.print(LogMessage.SSUPPLY_SUBPROC, DATA);
		JSONObject jsonData = new JSONObject();
		jsonData.put(source.getName(), source.getData());	
		Log.print(LogMessage.ISUPP_DATA, source.getData());
		Log.print(LogMessage.ESUPPLY_SUBPROC, DATA);	

		// finalizzazione
		Log.print(LogMessage.ICONF_DATA, "JSONArray");
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonMetadata);
		jsonArray.put(jsonData);

		// scrittura
		FileWriter file = new FileWriter(path);
		file.write(jsonArray.toString());
		file.flush();
		file.close();

		Log.print(LogMessage.ECONF_PROC, JSON_PROCESS 
				+ " json file writing completed");

	}
              
	/**
	 * carica i dati dal percorso specificato e ritorna un Data contenente i dati
	 * raccolti
	 * 
	 * @param path il percorso
	 * @return Un Data
	 * @throws IOException
	 */
	public static DataPackage loadData(String path) throws IOException, NoSuchFileException {
		
		// load process (start)
		Log.print(LogMessage.SLOAD_PROC, JSON_PROCESS);

		// source file
		String source = new String(Files.readAllBytes(Paths.get(path)));

		// data
		DataPackage dataPackage = new DataPackage("");
		JSONArray jsonArray = new JSONArray(source);
	
		// prepare data package
		confDataPackage(jsonArray, dataPackage);
	
		// load process (end)
		Log.print(LogMessage.ELOAD_PROC, JSON_PROCESS);
		
		return dataPackage;
	}
		

	
	/**
	 * Estrae i dati da un JSONObject
	 * @throws IOException 
	 */
	@SuppressWarnings({ })
	private static void confDataPackage(JSONArray jsonArray, DataPackage dataPackage) throws IOException {
		
		// getting metadata from json array
		Map<String, Object> metadata = jsonArray.getJSONObject(0).toMap();
		
		// getting data from json array
		Map<String, Object> data = jsonArray.getJSONObject(1).toMap();
			
		// prepare metadata
		setMetadata(metadata, dataPackage);
		
		// prepare data
		setData(data, dataPackage);
	
		// inst loading 
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getMetadata());
		Log.print(LogMessage.ILOAD_DATA, dataPackage.getData());
	}
	
		
	/**
	 * Inserisce i metadati all'interno del pacchetto dati
	 * specificato in input.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void setMetadata(Map<String, Object> jsonMetadata, DataPackage dataPackage) {
		
		/*
		 * Piuttosto che effettuare i get direttamente dall'oggetto JSONObject
		 * utilizzo una mappa ritornata dal medesimo per prelevare i valori delle
		 * chiavi. In questo modo evito le eccezioni JSONObjectException.
		 * Le implementazioni concrete di Map ritornano null quando la key non
		 * è presente all' interno della mappa. I null vengono impostati
		 * e si ha l'equivalenza dell'assenza di informazioni sui metadati.
		 */
		String key = (String) jsonMetadata.keySet().toArray()[0];
		Map<String, Object> metadata = (HashMap) jsonMetadata.get(key);
		
		// local-date-time
		Optional<Object> opt1 = Optional.ofNullable(metadata.get(DataPackage.LOCAL_DATE_TIME));
		if(opt1.isPresent()) {
			String localDateTime = (String) opt1.get();
			dataPackage.setLocalDateTime(localDateTime);
		}

		// os type
		Optional<Object> opt2 = Optional.ofNullable(metadata.get(DataPackage.OS));
		if(opt2.isPresent()) {
			String os = (String) opt2.get();
			dataPackage.setOs(os);
		}

		// architercture
		Optional<Object> opt3 = Optional.ofNullable(metadata.get(DataPackage.ARCH));
		if(opt2.isPresent()) {
			String arch = (String) opt3.get();
			dataPackage.setArch(arch);
		}
		
		// version
		Optional<Object> opt4 = Optional.ofNullable(metadata.get(DataPackage.VERSION));
		if(opt2.isPresent()) {
			String version = (String) opt4.get();
			dataPackage.setVersion(version);
		}
	}
	
	/**
	 * @param jsonData
	 * @param dataPackage
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setData(Map<String, Object> jsonData, DataPackage dataPackage) throws IOException {
			
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
