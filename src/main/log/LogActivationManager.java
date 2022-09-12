package main.log;

import java.io.IOException;
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
public class LogActivationManager implements Configurable, Exportable{

	/* Data name */
	final String DATA_NAME = "Log_service_status";
	
	/* Enabled services */
	Map<Integer, Boolean> enabled;

	/* The instance */
	static LogActivationManager instance = new LogActivationManager();

	
	/* Singleton pattern */
	private LogActivationManager() {
		init();
	}

	
	/**
	 * @param logMessage
	 * @return A boolean
	 */
	boolean isActive(LogMessage logMessage) {
		int code = logMessage.getCode();
		
		// Activation controll
		if(enabled.containsKey(code)) {
				return enabled.get(code);
		}
		
		else {
			throw new IllegalArgumentException("Unreconized"
					+ " code message:" + code);
		}
	}
	

	@Override
	public DataPackage provideData() throws IOException {

		Log.print(LogMessage.SSUPPLY_PROC, DATA_NAME);
		Log.print(LogMessage.SSUPPLY_SUBPROC, "");

		Map<String, Object> data = enabled.entrySet()
				.stream()
				.collect(Collectors
						.toMap(e -> e.getKey().toString(), 
							   e -> e.getValue()));
		
		Log.print(LogMessage.ISUPP_DATA, enabled);

		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);

		return new DataPackage(DATA_NAME, data);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) throws IOException {

		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");

		// 
		if(!(source.getName().equals(DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data."
					+",no "+ DATA_NAME +" key found");
		}
		

		if(source.getData().isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}

		else {
			try {
				enabled = (HashMap)source.getData()
						.entrySet()
						.stream()
						.collect(Collectors
								.toMap(
										e -> Integer.parseInt(e.getKey()), 
										e -> LogUtil.toBoolean(e)));
			}
			catch(Exception e) {
				e.printStackTrace();
				init();
			}
		}

		Log.print(LogMessage.ILOAD_DATA, enabled);
		Log.print(LogMessage.ECONF_SUBPROC, "");
		Log.print(LogMessage.ECONF_PROC, DATA_NAME);
	}

	
	/* Initialize the status */
	private void init() {
		enabled = new TreeMap<>();

		enabled.put(Log.MAIN_LOG_CODE, false);
		
		/** processes */
		enabled.put(Log.LOAD_PROC_CODE, false);
		enabled.put(Log.CONF_PROC_CODE, false);
		enabled.put(Log.SUPP_PROC_CODE, false);

		/** sub-processes */
		enabled.put(Log.LOAD_SUBPROC_CODE, false);
		enabled.put(Log.CONF_SUBPROC_CODE, false);
		enabled.put(Log.SUPP_SUBPROC_CODE, false);

		/** instructions */
		enabled.put(Log.LOAD_INST_CODE, false);
		enabled.put(Log.CONF_INST_CODE, false);
		enabled.put(Log.SUPP_INST_CODE, false);

		/** communications */
		enabled.put(Log.COMM_CODE, false);
	}
}