package main.log;

import java.io.IOException;
import java.time.LocalDateTime;

import main.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogWriterConfigurator {
	
	static final String LOGS_DIR_NAME = "logs";
	static final String DEF_LOGS_PATH = PathGenerator.generate(LOGS_DIR_NAME);
	static final String DEF_BASE_FILE_NAME = "juno-log";
	
	//
	private String localDateTime;
	
	//
	private String path;
	
	// The instance
	private static LogWriterConfigurator instance;
	
	// Builds the instance end initialize it 
	private LogWriterConfigurator() {
		init();
	}
	
	/**
	 * 
	 * @return The instance
	 */
	public static LogWriterConfigurator getInstance() {
		if(instance == null) {
			instance = new LogWriterConfigurator();
		}
		return instance;
	}

	
	/**
	 * 
	 * @return A String
	 * @throws IOException
	 */
	public String getPath() throws IOException {
		this.localDateTime = LocalDateTime.now().toString();
		return PathGenerator.generate(path, DEF_BASE_FILE_NAME.concat(localDateTime).concat(".log"));
	}

	
	/**
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	//
	private void init() {
		path = DEF_LOGS_PATH;
	}
}
