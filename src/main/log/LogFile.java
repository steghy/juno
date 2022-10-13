package main.log;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * LogFile class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class LogFile {
	
	/* Enabler component */
	private LogFileEnabler activator;
	
	/* Configurator component */
	private LogFilePath configurator;
	
	/* writer component */
	private PrintWriter writer;
	
	/* the instance */
	private static LogFile instance;
	

	/* Builds the LogFile instance */
	private LogFile() {
		init();
	}

	
	/**
	 * Returns the instance
	 * @return The instance
	 */
	public static LogFile getInstance() {
		if(instance == null) {
			instance = new LogFile();
		}
		return instance;
	}

	
	/**
	 * Write the specified String object in the file
	 * @param string A String object
	 */
	public void write(String string) {
		if(instance.activator.getStatus()) {
			if(configurator.getPath() == null) {
				throw new NullPointerException("First set the path "
						+ "where save the log file");
			}
			if(writer == null) {
				try {
					writer = new PrintWriter(configurator.getPath());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			writer.println(string);			
			writer.flush();
		}
	}

	
	/**
	 * Sets the path where save the Log file
	 * @param path A path
	 */
	public void setPath(String path) {
		this.configurator.setPath(path);
	}
	
	
	/**
	 * Returns the path where save the log file
	 * @return The path where save the log file
	 */
	public String getPath() {
		return this.configurator.getPath();
	}

	
	/* Initialize the instance */
	private void init() {
		activator = LogFileEnabler.getInstance();
		configurator = LogFilePath.getInstance();
	}
}