package main.log;

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
	private static LogEnabler activator = LogEnabler.instance;	

	/* Color component */
	private static LogColor colors = LogColor.getInstance();

	/* Writer component */
	private static LogFile writer = LogFile.getInstance();

	
	/* static class */
	private Log() {}

	
	/**
	 * Print the specified LogMessage and message.
	 * @param logMessage The standard message to print
	 * @param message The message to print
	 */
	public static void print(LogMessage logMessage, Object message) {
		String string = build(logMessage);  // Colored string
		if(activator.isActive(logMessage)) {
					
			if(message instanceof Map || 
			   message instanceof Collection || 
			   message.getClass().isArray()) {
				string += stringFrom(message);
			}
			else {
				string += message.toString();
			}
			System.out.println(string);
			writer.write(buildForWriter(logMessage));
		}
	}
		
	
	/*
	 * Prints the specified LogMessage with the specified Map.
	 */
	@SuppressWarnings("unchecked")
	private static String stringFrom(Object object) {
		String message = "";
		if(object instanceof Map) {
			message += stringFromRecursive((Map<Object, Object>) object);
		}
		else if(object instanceof Collection) {
			message += stringFromRecursive((Collection<Object>) object);
		}
		else if(object.getClass().isArray()) {
			message += stringFromRecursive((Object[]) object);
		}
		return message;
	}
	
	/* */
	@SuppressWarnings("unchecked")
	private static String stringFromRecursive(Map<Object, Object> data) {
		String message = "\n{\n";
		int count = 1;
		for(Entry<Object, Object> entrySet : data.entrySet()) {
			Object key = entrySet.getKey();
			Object value = entrySet.getValue();
			
			if(key instanceof Map) {
				message += stringFromRecursive((Map<Object, Object>) key);
			}
			else if(key instanceof Collection) {
				message += stringFromRecursive((Collection<Object>) key);
			}
			else if(key.getClass().isArray()) {
				message += stringFromRecursive((Object[]) key);
			}
			else {
				message += key.toString().concat(" = ");
			}
			
			if(value instanceof Map) {
				message += stringFromRecursive((Map<Object, Object>) value);
			}
			else if(value instanceof Collection) {
				message += stringFromRecursive((Collection<Object>) value);
			}
			else if(value.getClass().isArray()) {
				message += stringFromRecursive((Object[]) value);
			}
			else {
				message += value.toString();
			}
			message += (count == data.size() ? "" : ", ");
			message += "\n";
			count ++;
		};
		return message.concat("}");
	};
	
	
	/* */
	@SuppressWarnings("unchecked")
	private static String stringFromRecursive(Collection<Object> data) {
		String message = "[";
		int count = 1;
		for(Object value : data) {
			if(value instanceof Map) {
				message += stringFromRecursive((Map<Object, Object>) value);
			}
			else if(value instanceof Collection) {
				message += (stringFromRecursive((Collection<Object>) value));
			}
			else if(value.getClass().isArray()) {
				message += stringFromRecursive((Object[]) value);
			}
			else {
				message += value.toString();
			}
			message += (count == data.size() ? "" : ", ");
		}
		return message.concat("]");
	}
	
	
	@SuppressWarnings("unchecked")
	private static String stringFromRecursive(Object[] array) {
		String message = "(";
		for(int i = 0; i < array.length; i++) {
			Object value = array[i];
			if(value instanceof Map) {
				message += stringFromRecursive((Map<Object, Object>) value);
			}
			else if(value instanceof Collection) {
				message += stringFromRecursive((Collection<Object>) value);
			}
			else if(value.getClass().isArray()) {
				message += stringFromRecursive((Object[]) value);
			}
			else {
				message += value.toString();
			}
			message += (i == array.length - 1 ? "" : ", ");
		}
		message += ")";
		return message;
		
	}
	
	
	/* 
	 * Builds and return the string from the specified LogMessage
	 * and message (with ANSIEscape sequence).
	 */
	private static String build(LogMessage logMessage) {
		
		// The ANSI escape sequence 
		String color = colors.getColor(logMessage);

		return color
				.concat(logMessage.toString())
				.concat(color.equals("") ? "" : ANSIEscape.RESET.getSequence());
	}

	
	/*
	 * Builds and return the string from the specified LogMessage
	 * and message (without ANSIEscape sequence).
	 */
	private static String buildForWriter(LogMessage logMessage) {
		return logMessage.toString();
	}
}