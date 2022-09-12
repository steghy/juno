package main.log;
import java.util.Map;

import main.util.*;


/**
 * @author steghy
 *
 */
public class Log {
	
	
	static final int MAIN_LOG_CODE = -1;
	
	static final int LOAD_PROC_CODE = 0;
	
	static final int CONF_PROC_CODE = 1;
	
	static final int SUPP_PROC_CODE = 2;
	
	static final int LOAD_SUBPROC_CODE = 3;
	
	static final int CONF_SUBPROC_CODE = 4;
	
	static final int SUPP_SUBPROC_CODE = 5;
	
	static final int LOAD_INST_CODE = 6;
	
	static final int CONF_INST_CODE = 7;
	
	static final int SUPP_INST_CODE = 8;
	
	static final int COMM_CODE = 9;
	
	/* Activator component */
	private static LogActivationManager activator = LogActivationManager.instance;	

	/* Color component */
	private static LogColors colors = LogColors.getInstance();

	/* Writer component */
	private static LogWriter writer = LogWriter.getInstance();

	
	/* static class */
	private Log() {}

	
	/**
	 * @param logMessage The standard message to print
	 * @param message The message to print
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void print(LogMessage logMessage, Object message) {
	
		// build the final string
		String string = build(logMessage, message);
	
		// print the message if it is enabled
		if(activator.isActive(logMessage)) {
					
			// maybe is a map ( see printMap )
			if(message instanceof Map) {
				printMap(logMessage, (Map) message);
			}
			else {
				System.out.println(string);
				
				// if it is enabled, it writes the text in the log file
				writer.write(buildForWriter(logMessage, message));
			}
		}
	}
		
	
	//
	private static void printMap(LogMessage logMessage, Map<String, Object> data) {
		
		data
		.keySet()
		.stream()
		.forEach(e -> Log   
				.print(logMessage,  "[" + e + "=" + data.get(e) +"]"));
	}

	
	//
	private static String build(LogMessage logMessage, Object message) {
		
		// maybe it is a blank string 
		String color = colors.getColor(logMessage);
		
		// the final string 
		return color.concat(logMessage.toString())
				.concat(color.equals("") ? "" : ANSIEscape.RESET)
				.concat(message.toString());
	}

	
	//
	private static String buildForWriter(LogMessage logMessage, Object message) {
		
		// the final string
		return logMessage.toString().concat(message.toString());
	}
}
