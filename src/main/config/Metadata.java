package main.config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import main.util.Os;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Metadata {
	
	/** Local, date & time */
	public static final String LOCAL_DATE_TIME = "local-date-time";
	
	/** Operative system */
	public static final String OS = "os";
	
	/** Architecture */
	public static final String ARCH = "arch";
	
	/** The system version */
	public static final String VERSION = "version";
	
	private String localDateTime; /* Local, date & time */
	private String os;            /* OS type */
	private String arch;          /* Srchitecture */
	private String version;       /* System version */
	
	/**
	 * Builds a Metadata 
	 */
	public Metadata() {
		init();
	}

	
	/**
	 * Sets the local, data & time
	 * @param localDateTime The local, data & time.
	 */
	public void setLocalDateTime(String localDateTime) {
		this.localDateTime = localDateTime;
	}

	
	/**
	 * Sets the Operative system
	 * @param os Operative system
	 */
	public void setOs(String os) {
		this.os = os;
	}

	
	/**
	 * Sets the architecture
	 * @param arch The architecture
	 */
	public void setArch(String arch) {
		this.arch = arch;
	}

	
	/**
	 * Sets the system version
	 * @param version The system version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	/**
	 * Returns the local, date & time 
	 * @return The local, data & time
	 */
	public String getLocalDateTime() {
		return this.localDateTime;
	}
	
	
	/**
	 * 
	 * @return The entire metadata
	 */
	public Map<String, Object> getAllMetadata(){
		Map<String, Object> metadata = new HashMap<>();
		metadata.put(LOCAL_DATE_TIME, this.localDateTime);
		metadata.put(OS, this.os);
		metadata.put(ARCH,this.arch);
		metadata.put(VERSION, this.version);
		return metadata;
	}
	
	
	/**
	 * Returns the OS type
	 * @return The OS type
	 */
	public String getOs() {
		return this.os;
	}

	
	/**
	 * Returns the system architecture
	 * @return The system architecture
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
	
	
	/* Initialize the metadata */
	private void init() {
		this.localDateTime = LocalDateTime.now().toString();
		this.os = Os.getName();
		this.arch = Os.getArch();
		this.version = Os.getVersion();
	}
}
