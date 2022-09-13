package main.config;

/**
 * This class defines DataPackage. 
 * A DataPackage is composed by:
 * 		- Metadata
 * 		- Data
 * The Metadata are composed by:
 * 		- Local, date & time
 * 		- OS (Operative System type)
 * 		- Architecture (System architecture)
 * 		- Version (System version)
 * The data consist in a Map<String, Object>
 * where the keys are the labels for the concreted
 * data (Object).
 * 
 * @author steghy
 * @email <steghy.github@proton.me> 
 */
public class DataPackage {

	/* Metadata */
	private Metadata metadata;
	
	/* Data */
	private Data data;
	
	
	/**
	 * Builds an empty DataPackage
	 */
	public DataPackage() {
		this.metadata = new Metadata();
	}


	/**
	 * Builds a data package
	 * @param data The data
	 */
	public DataPackage(Data data) {
		this.data = data;
		this.metadata = new Metadata();
	}

	
	/**
	 * Returns the data
	 * @return The data
	 */
	public Data getDataObj() {
		return this.data;
	}

	
	/**
	 * Returns the metadata 
	 * @return The metadata
	 */
	public Metadata getMetadataObj(){
		return metadata;
	}
	

	
	/**
	 * Sets the data
	 * @param data The data
	 */
	public void setData(Data data) {
		this.data = data;
	}
	
	
	/**
	 * Sets the metadata 
	 * @param metadata The metadata
	 */
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
}