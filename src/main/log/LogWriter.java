package main.log;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogWriter {
	
	// activator component
	private LogWriterActivationManager activator;
	
	// configurator component
	private LogWriterConfigurator configurator;
	
	// writer component
	private PrintWriter writer;
	
	// the instance
	private static LogWriter instance;
	

	//
	private LogWriter() {
		init();
	}

	
	/**
	 * 
	 * @return The instance
	 */
	public static LogWriter getInstance() {
		if(instance == null) {
			instance = new LogWriter();
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
		activator = LogWriterActivationManager.getInstance();
		configurator = LogWriterConfigurator.getInstance();
	}
}
