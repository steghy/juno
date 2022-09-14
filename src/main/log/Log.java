package main.log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import main.util.ANSIEscape;


/**
 * This class allows you to print messages to the console that 
 * can be selectively disabled using the LogActivationManager 
 * class via a JSON configuration file or via the command 
 * line (for more information on command line options see 
 * the file path-to-log-package/log-info/cmd-options).
 * It is also possible to save everything printed on the
 * console directly in a file. The printouts can be colored 
 * and the colors can be changed externally through the use 
 * of JSON files (Many color schemes are already available in 
 * the path: path-to-log-package/log-colors/schemes/).
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Log {
	
	/* Activator component */
	private static LogActivationManager activator = LogActivationManager.instance;	

	/* Color component */
	private static LogColors colors = LogColors.getInstance();

	/* Writer component */
	private static LogWriter writer = LogWriter.getInstance();

	
	/* static class */
	private Log() {}

	
	/**
	 * Print the specified LogMessage and message.
	 * @param logMessage The standard message to print
	 * @param message The message to print
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void print(LogMessage logMessage, Object message) {
		String string = build(logMessage, message);
		if(activator.isActive(logMessage)) {
					
			// It can be a Map
			if(message instanceof Map || message instanceof Collection) {
				message = stringFrom(logMessage, (Map) message);
			}
			System.out.println(string);
			writer.write(buildForWriter(logMessage, message));
		}
	}
		
	
	/*
	 * Prints the specified LogMessage with the specified Map.
	 */
	@SuppressWarnings("unchecked")
	private static String stringFrom(LogMessage logMessage, Object object) {
		String message = logMessage.toString();
		if(object instanceof Map) {
			message.concat(stringFromRecursive((Map<Object, Object>) object));
		}
		else if(object instanceof Collection) {
			message.concat(stringFromRecursive((Collection<Object>) object));
		}
		return message;
	}
	
	/* */
	@SuppressWarnings("unchecked")
	private static String stringFromRecursive(Map<Object, Object> data) {
		String message = "{";
		for(Entry<Object, Object> entrySet : data.entrySet()) {
			Object key = entrySet.getKey();
			Object value = entrySet.getValue();
			
			if(key instanceof Map) {
				message.concat(stringFromRecursive((Map<Object, Object>) key));
			}
			else if(key instanceof Collection) {
				message.concat(stringFromRecursive((Collection<Object>) key));
			}
			else if(key.getClass().isArray()) {
				message.concat(stringFromRecursive(Arrays.asList(key)));
			}
			else {
				message.concat(key.toString());
			}
			
			if(value instanceof Map) {
				message.concat(stringFromRecursive((Map<Object, Object>) value));
			}
			else if(value instanceof Collection) {
				message.concat(stringFromRecursive((Collection<Object>) value));
			}
			else if(value.getClass().isArray()) {
				message.concat(stringFromRecursive(Arrays.asList(value)));
			}

			else {
				message.concat(value.toString());
			}
		}
		return message.concat("}");
	}
	
	
	/* */
	@SuppressWarnings("unchecked")
	private static String stringFromRecursive(Collection<Object> data) {
		String message = "{";
			
		for(Object value : data) {
			if(value instanceof Map) {
				message.concat(stringFromRecursive((Map<Object, Object>) value));
			}
			else if(value instanceof Collection) {
				message.concat(stringFromRecursive((Collection<Object>) value));
			}
			else if(value.getClass().isArray()) {
				System.out.println(Arrays.asList(value));
				message.concat(stringFromRecursive(Arrays.asList(value)));
			}
			else {
				message.concat(value.toString());
			}
		}
		return message.concat("}");
	}
	
	
	/* 
	 * Builds and return the string from the specified LogMessage
	 * and message (with ANSIEscape sequence).
	 */
	private static String build(LogMessage logMessage, Object message) {
		
		// maybe it is a blank string 
		String color = colors.getColor(logMessage);
		
		// the final string 
		return color.concat(logMessage.toString())
				.concat(color.equals("") ? "" : ANSIEscape.RESET)
				.concat(" " + message.toString());
	}

	
	/*
	 * Builds and return the string from the specified LogMessage
	 * and message (without ANSIEscape sequence).
	 */
	private static String buildForWriter(LogMessage logMessage, Object message) {
		
		// the final string
		return logMessage.toString()
				.concat((message.toString().length() > 0 ? " " : "") + message.toString());
	}
}