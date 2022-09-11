package main.log.file;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * @author steghy
 *
 */
public class LogWriter {
	
	// comment
	private LogWriterActivationManager activator;
	
	// comment
	private LogWriterConfigurator configurator;
	
	// comment
	private PrintWriter writer;
	
	// comment
	private static LogWriter instance;
	

	/**
	 * 
	 */
	private LogWriter() {
		init();
	}

	
	/**
	 * 
	 * @return
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

	private void init() {
		activator = LogWriterActivationManager.getInstance();
		configurator = LogWriterConfigurator.getInstance();
	}
}
