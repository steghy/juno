package main.log;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.config.Configurable;
import main.config.Data;
import main.config.DataPackage;
import main.config.Exportable;

/**
 * This class is respondible for enabling
 * the different types of printouts in the 
 * register (file) and on the terminal. The types
 * of printouts are code labels (see LogCodes for
 * informations about code labels).
 * @author steghy
 * @email steghy.github@proton.me
 */
public class LogEnabler implements Configurable, Exportable, Activable{

	/* Data name */
	final String DATA_NAME = "Log_service_status";
	
	/* Enabled services */
	Map<Integer, Boolean> enabled;

	/* The instance */
	static LogEnabler instance = new LogEnabler();

	
	/* Returns the instance */
	private LogEnabler() {
		init();
	}

	
	/**
	 * Returns true if the specified LogMessage
	 * is active, otherwise returns false.
	 * @param logMessage A LogMessage instance
	 * @return A boolean 
	 */
	boolean isActive(LogMessage logMessage) {
		if(enabled.get(LogMessage.MAIN_LOG_CODE.getCode())) {
			return true;
		}
		else {
			return enabled.get(logMessage.getCode());
		}
		
	}
	

	@Override
	public DataPackage provideData() throws IOException {

		Log.print(LogMessage.SSUPPLY_PROC, DATA_NAME);
		Log.print(LogMessage.SSUPPLY_SUBPROC, "");

		// Map<Integer, Boolean> => Map<String, Object>
		Map<String, Object> data = enabled.entrySet()
				.stream()
				.collect(Collectors
						.toMap(e -> e.getKey().toString(), 
							   e -> e.getValue()));
		
		Log.print(LogMessage.ISUPP_DATA, enabled);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);

		return new DataPackage(new Data(data, DATA_NAME));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) throws IOException {

		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");

		// It checks validity data 
		if(!(source.getDataObj().getName().equals(DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data."
					+",no "+ DATA_NAME +" key found");
		}
		
		// That is not gonna happen
		if(source.getDataObj().getData().isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}

		else {
			try {
				// Map<String, Object> => Map<Integer, Boolean>
				enabled = (HashMap)source.getDataObj().getData()
						.entrySet()
						.stream()
						.collect(Collectors
								.toMap(
										e -> Integer.parseInt(e.getKey()), 
										e -> LogUtil.toBoolean(e)));
			}
			catch(Exception e) {
				e.printStackTrace();
				init();  // Back to default values
			}
		}

		Log.print(LogMessage.ILOAD_DATA, enabled);
		Log.print(LogMessage.ECONF_SUBPROC, "");
		Log.print(LogMessage.ECONF_PROC, DATA_NAME);
	}

	
	/* Initialize the status */
	private void init() {
		enabled = new TreeMap<>();
		Arrays.asList(LogMessage.values())
		.stream()
		.map(c -> c.getCode()) // Integer mapping
		.forEach(c -> enabled
				.put(c, false));
	}


	@Override
	public Map<Integer, Boolean> getActive() {
		return this.enabled;
	}
}