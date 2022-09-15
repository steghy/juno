package main.log;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class LogFile {
	
	/* Enabler component */
	private LogFileEnabler activator;
	
	private LogFilePath configurator;
	
	// writer component
	private PrintWriter writer;
	
	// the instance
	private static LogFile instance;
	

	//
	private LogFile() {
		init();
	}

	
	/**
	 * 
	 * @return The instance
	 */
	public static LogFile getInstance() {
		if(instance == null) {
			instance = new LogFile();
		}
		return instance;
	}

	
	/**
	 * 
	 * @param string
	 */
	public void write(String string) {
		if(instance.activator.getStatus()) {
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

	
	// initialize the components
	private void init() {
		activator = LogFileEnabler.getInstance();
		configurator = LogFilePath.getInstance();
	}
}
