package main.log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogColorsActivationManager implements Exportable, Configurable {

	/* Data name */
	static final String DATA_NAME = "log-colors-service-status";

	/* Enabled services */
	Map<Integer, Boolean> enabled;
	
	/* The instance */
	private static LogColorsActivationManager instance;

	/* Builds and initialize the LCAM object */
	private LogColorsActivationManager() {
		init();
	}

	
	/* Returns the instance */
	static LogColorsActivationManager getInstance() {
		if(instance == null) {
			instance = new LogColorsActivationManager();
		}
		return instance;
	}

	
	/**
	 * Returns true if the specified LogMessage 
	 * is active, otherwise returns false.
	 * @param logMessage A LogMessage instance
	 * @return A boolean
	 */
	public boolean isActive(LogMessage logMessage) {
		int code = logMessage.getCode();
		if(enabled.containsKey(code)) {
			return enabled.get(code);
		}
		else {
			throw new IllegalArgumentException("Unreconized "
					+ "code message:" + code);
		}
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void configure(DataPackage source) {

		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");

		if (!(source.getName().equals(DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data." 
					+ ",no " + DATA_NAME + " key found");
		}

		Map<String, Object> data = source.getData();
		if (data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		else {
			try {
				// Map<String, Object> => Map<Integer, Boolean>
				enabled = (HashMap)source.getData()
						.entrySet()
						.stream()
						.collect(Collectors
								.toMap(
										e -> Integer.parseInt(e.getKey()), 
										e -> LogUtil.toBoolean(e)));
			} 
			catch (IllegalArgumentException e) {
				e.printStackTrace();
				init();
			}
		}
	}

	@Override
	public DataPackage provideData() {
		Log.print(LogMessage.SSUPPLY_PROC, DATA_NAME);
		Log.print(LogMessage.SSUPPLY_SUBPROC, "");

		// Map<Integer, Boolean> => Map<String, Object>
		Map<String, Object> data = enabled.entrySet()
				.stream()
				.collect(Collectors
						.toMap(e -> e.getKey().toString(), 
							   e -> e.getValue()));

		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);

		return new DataPackage(DATA_NAME, data);
	}

	
	/* Initialize the status */
	private void init() {
		enabled = new TreeMap<>();
		Arrays.asList(LogCodes.values())
		.stream()
		.map(c -> c.getCode()) // Integer mapping
		.forEach(c -> enabled
				.put(c, false));
	}
}
