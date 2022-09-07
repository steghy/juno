package main.log.main;
import java.util.Map;
import main.log.color.LogColors;
import main.log.file.LogWriter;
import main.log.messages.LogMessage;
import main.util.*;


/**
 * @author steghy
 *
 */
public class Log {
	
	/** processes code */
	public static final int LOAD_PROC_CODE = 0;
	public static final int CONF_PROC_CODE = 1;
	public static final int SUPP_PROC_CODE = 2;
	
	/** sub-processes code */
	public static final int LOAD_SUBPROC_CODE = 3;
	public static final int CONF_SUBPROC_CODE = 4;
	public static final int SUPP_SUBPROC_CODE = 5;
	
	/** instructions code */
	public static final int LOAD_INST_CODE = 6;
	public static final int CONF_INST_CODE = 7;
	public static final int SUPP_INST_CODE = 8;
	
	/** communications code */
	public static final int COMM_CODE = 9;
	
	/** component for the management of enabled prints */
	private static LogActivationManager activator = LogActivationManager
			.getInstance();
	
	/** component of colors */
	private static LogColors colors = LogColors.getInstance();

	/** component for creating the file */
	private static LogWriter writer = LogWriter.getInstance();

	
	/** no instance */
	private Log() {
		
	}

	
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
		
	
	/**
	 * @param logMessage The standard message to print
	 * @param data The Map
	 */
	private static void printMap(LogMessage logMessage, Map<String, Object> data) {
		
		data
		.keySet()
		.stream()
		.forEach(e -> Log   
				.print(logMessage,  "[" + e + "=" + data.get(e) +"]"));
	}

	
	/**
	 * @param logMessage The standard message to print
	 * @param message The message to print
	 * @return The final message (with color, if enabled)
	 */
	private static String build(LogMessage logMessage, Object message) {
		
		// maybe it is a blank string 
		String color = colors.getColor(logMessage);
		
		// the final string 
		return color.concat(logMessage.toString())
				.concat(color.equals("") ? "" : ANSIEscape.RESET)
				.concat(message.toString());
	}

	
	/**
	 * @param logMessage The standard message
	 * @param message the message to write
	 * @return The final message (without color)
	 */
	private static String buildForWriter(LogMessage logMessage, Object message) {
		
		// the final string
		return logMessage.toString().concat(message.toString());
	}
}
