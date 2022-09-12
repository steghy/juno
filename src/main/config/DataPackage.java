package main.config;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import main.util.Os;


/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me> 
 */
public class DataPackage {

	/* Local, date, time data name */
	static final String LOCAL_DATE_TIME = "local-date-time";
	static final String OS = "os-name";
	static final String ARCH = "arch";
	static final String VERSION = "version";

	
	private String name;          /* data name */
	private String localDateTime; /* local date and time */
	private String os;            /* os */
	private String arch;          /* arch */
	private String version;       /* version */
	
	/* Data */
	private Map<String, Object> data;

	
	/**
	 * Builds a data package
	 * @param name Data package's name
	 */
	public DataPackage(String name) {
		this.name = name;
		this.init();
	}


	/**
	 * Builds a data package
	 * @param name Data package's name
	 * @param data Data
	 */
	public DataPackage(String name, Map<String, Object> data) {
		this.name = name;
		this.data = data;
		this.init();
	}

	
	/**
	 * Returns the name
	 * @return The name
	 */
	public String getName() {
		return this.name;
	}

	
	/**
	 * Returns the local date & time 
	 * @return Local data & time
	 */
	public String getLocalDateTime() {
		return this.localDateTime;
	}
	
	
	/**
	 * Returns the os type
	 * @return The os type
	 */
	public String getOs() {
		return this.os;
	}

	
	/**
	 * Returns the architecture
	 * @return The architecture
	 */
	public String getArch() {
		return this.arch;
	}

	
	/**
	 * Returns the system version 
	 * @return The system version
	 */
	public String getVersion() {
		return this.version;
	}

	
	/**
	 * Returns the data
	 * @return The data
	 */
	public Map<String, Object> getData() {
		return this.data;
	}

	
	/**
	 * 
	 * @return A Map
	 */
	public Map<Object, Object> getMetadata(){

		Map<Object, Object> metadata = new HashMap<>();

		metadata.put(LOCAL_DATE_TIME, this.localDateTime);
		metadata.put(OS, this.os);
		metadata.put(ARCH, this.arch);
		metadata.put(VERSION, this.version);

		return metadata;
	}
	
	/**
	 * 
	 * @param localDateTime
	 */
	public void setLocalDateTime(String localDateTime) {
		this.localDateTime = localDateTime;
	}

	
	/**
	 * 
	 * @param os
	 */
	public void setOs(String os) {
		this.os = os;
	}

	
	/**
	 * 
	 * @param arch
	 */
	public void setArch(String arch) {
		this.arch = arch;
	}

	
	/**
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	
	/**
	 * 
	 * @param data
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * 
	 */
	private void init() {
		localDateTime = LocalDateTime.now().toString();
		this.os = Os.getName();
		this.arch = Os.getArch();
		this.version = Os.getVersion();
	}
}
