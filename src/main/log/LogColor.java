package main.log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.config.Configurable;
import main.config.Data;
import main.config.DataPackage;
import main.config.Exportable;
import main.util.ANSIEscape;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogColor implements Exportable, Configurable{
	
	// Data name
	static final String DATA_NAME = "log-colors";

	// Activator component
	private LogColorEnabler activator;
	
	// CodeMessage => ANSIEscape sequence
	private Map<Integer, String> colors;
		
	// The instance
	private static LogColor instance;
	
	// Singleton pattern
	private LogColor() {	
		init();
	}
	
	/**
	 * Returns the LogColors instance
	 * @return The instance
	 */
	static LogColor getInstance() {
		
		if(LogColor.instance == null) {
			LogColor.instance = new LogColor();
		}
		return LogColor.instance;
	}
	
	/**
	 * Returns the ANSI escape sequence associated 
	 * to the specified LogMessage object.
	 * @param logMessage A LogMessage object
	 * @return An ANSI Escape sequence
	 */
	String getColor(LogMessage logMessage) {
		return (activator.isActive(logMessage) ? 
				colors.get(logMessage.getCode()) : "");	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) {
		
		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");
		
		if(!(source.getDataObj().getName().equals(LogColor.DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data."
					+",no "+DATA_NAME+" key found");
		}
	
		// Gets data from the DataPackage
		Map<String, Object> data = (HashMap) source.getDataObj().getData();
		
		if(data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		
		else {
			try {
				// Map<String, Object> => Map<Integer, String>
				colors = (HashMap)source.getDataObj().getData()
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
		
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		
		return new DataPackage(new Data(data, DATA_NAME));
	}
	

	/* Intiialize the LogColors component*/
	private void init() {	
		
		// initialize the colors map
		colors = new TreeMap<>();
		Arrays.asList(LogMessage.values())
		.stream()
		.map(c -> c.getCode()) // Integer mapping
		.forEach(c -> colors   
				.put(c, ANSIEscape.TX_GREEN.getSequence()));
		
		// initialize the component
		activator = LogColorEnabler.getInstance();
	}
}