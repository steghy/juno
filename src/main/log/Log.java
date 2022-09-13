package main.log;
import java.util.Map;

import main.util.*;


/**
 * 
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void print(LogMessage logMessage, Object message) {
		String string = build(logMessage, message);
		if(activator.isActive(logMessage)) {
					
			// It can be a Map
			if(message instanceof Map) {
				printMap(logMessage, (Map) message);
			}
			else {
				System.out.println(string);
				writer.write(buildForWriter(logMessage, message));
			}
		}
	}
		
	
	/*
	 * Prints the specified LogMessage with the specified Map.
	 */
	private static void printMap(LogMessage logMessage, Map<String, Object> data) {
		data
		.keySet()
		.stream()
		.forEach(e -> Log   
				.print(logMessage,  "[" + e + "=" + data.get(e) +"]"));
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