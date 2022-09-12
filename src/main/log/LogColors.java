package main.log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.util.ANSIEscape;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogColors implements Exportable, Configurable{
	
	// Data name
	static final String DATA_NAME = "log-colors";

	// Activator component
	private LogColorsActivationManager activator;
	
	// CodeMessage => ANSIEscape sequence
	private Map<Integer, String> colors;
		
	// The instance
	private static LogColors instance;
	
	// Singleton pattern
	private LogColors() {	
		init();
	}
	
	/**
	 * Returns the LogColors instance
	 * @return The instance
	 */
	static LogColors getInstance() {
		
		if(LogColors.instance == null) {
			LogColors.instance = new LogColors();
		}
		return LogColors.instance;
	}
	
	/**
	 * 
	 * @param logMessage
	 * @return ANSI Escape sequence
	 */
	String getColor(LogMessage logMessage) {
		
		int code = logMessage.getCode();
		
		if(colors.containsKey(code))
		{
			String temp = (activator.isActive(logMessage) ? colors.get(code) : "");	
			return temp;
		}
		else {
			throw new IllegalArgumentException("");
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) {
		
		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");
		
		if(!(source.getName().equals(LogColors.DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data."
					+",no "+DATA_NAME+" key found");
		}
		
		Map<String, Object> data = (HashMap) source.getData();
		
		if(data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		
		else {
			try {
				// Map<String, Object> => Map<Integer, String>
				colors = (HashMap)source.getData()
						.entrySet()
						.stream()
						.collect(Collectors
								.toMap(
										e -> Integer.parseInt(e.getKey()), 
										e -> e.toString()));
			}
			catch(ClassCastException e) {
				e.printStackTrace();
				init();
			}
		}
		
		Log.print(LogMessage.ICONF_DATA, data);
		Log.print(LogMessage.ECONF_SUBPROC, "");
		Log.print(LogMessage.ECONF_PROC, DATA_NAME);
	}

	@Override
	public DataPackage provideData() {
		
		Log.print(LogMessage.SSUPPLY_PROC, DATA_NAME);
		Log.print(LogMessage.SSUPPLY_SUBPROC, "");

		// Map<Integer, Boolean> => Map<String, Object>
		Map<String, Object> data = colors.entrySet()
				.stream()
				.collect(Collectors
						.toMap(e -> e.getKey().toString(), 
							   e -> e.getValue()));
		
		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		
		return new DataPackage(DATA_NAME, data);
	}
	

	// initialize the colors with default values
	private void init() {	
		colors = new TreeMap<>();
		Arrays.asList(LogCodes.values())
		.stream()
		.map(c -> c.getCode()) // Integer mapping
		.forEach(c -> colors   
				.put(c, ANSIEscape.TX_WHITE));
	}
}