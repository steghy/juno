package main.log.color;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.main.Log;
import main.log.messages.LogMessage;
import main.util.ANSIEscape;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogColors implements Exportable, Configurable{
	
	//
	static final String DATA_NAME = "log-colors";

	//
	final String LOAD_PROC_COL_DATA_NAME = "load-proc-color";
	final String CONF_PROC_COL_DATA_NAME = "conf-proc-color";
	final String SUPP_PROC_COL_DATA_NAME = "supp-proc-color";

	//
	final String LOAD_SUBPROC_COL_DATA_NAME = "load-subproc-color";
	final String CONF_SUBPROC_COL_DATA_NAME = "conf-subproc-color";
	final String SUPP_SUBPROC_COL_DATA_NAME = "supp-subproc-color";

	//
	final String LOAD_INST_COL_DATA_NAME = "load-ins-color";
	final String CONF_INST_COL_DATA_NAME = "conf-ins-color";
	final String SUPP_INST_COL_DATA_NAME = "supp-ins-color";

	//
	final String COMM_COL_DATA_NAME = "comm-color";
	
	//
	private String loadProcCol;
	private String confProcCol;
	private String suppProcCol;
	
	//
	private String loadSubprocCol;
	private String confSubprocCol;
	private String suppSubprocCol;
	
	//
	private String loadInstCol;
	private String confInstCol;
	private String suppInstCol;
	
	//
	private String commCol;
	
	//
	private LogColorsActivationManager activator;
	
	//
	private Map<Integer, String> colors;
		
	// The instance
	private static LogColors instance;
	
	// Singleton pattern
	private LogColors() {	
		init();
	}
	
	/**
	 * 
	 * @return The instance
	 */
	public static LogColors getInstance() {
		
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
	public String getColor(LogMessage logMessage) {
		
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
				
				//processes
				loadProcCol = (String) data.get(LOAD_PROC_COL_DATA_NAME);
				confProcCol = (String) data.get(CONF_PROC_COL_DATA_NAME);
				suppProcCol = (String) data.get(SUPP_PROC_COL_DATA_NAME);
				
				//sub-processes
				loadSubprocCol = (String) data.get(LOAD_SUBPROC_COL_DATA_NAME);
				confSubprocCol = (String) data.get(CONF_SUBPROC_COL_DATA_NAME);
				suppSubprocCol = (String) data.get(SUPP_SUBPROC_COL_DATA_NAME);
				
				//instructions
				loadInstCol = (String) data.get(LOAD_INST_COL_DATA_NAME);
				confInstCol = (String) data.get(CONF_INST_COL_DATA_NAME);
				suppInstCol = (String) data.get(SUPP_INST_COL_DATA_NAME);
				
				//communications
				commCol = (String) data.get(COMM_COL_DATA_NAME);
				
				//aggiornamento della mappa
				update();
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
		
		Map<String, Object> data = new HashMap<>();
		
		//processes
		data.put(LOAD_PROC_COL_DATA_NAME, loadProcCol);
		data.put(CONF_PROC_COL_DATA_NAME, confProcCol);
		data.put(SUPP_PROC_COL_DATA_NAME, suppProcCol);
		
		//sub-processes
		data.put(LOAD_SUBPROC_COL_DATA_NAME, loadSubprocCol);
		data.put(CONF_SUBPROC_COL_DATA_NAME, confSubprocCol);
		data.put(SUPP_SUBPROC_COL_DATA_NAME, suppSubprocCol);
		
		//instructions
		data.put(LOAD_INST_COL_DATA_NAME, loadInstCol);
		data.put(CONF_INST_COL_DATA_NAME, confInstCol);
		data.put(SUPP_INST_COL_DATA_NAME, suppInstCol);
		
		//communications
		data.put(COMM_COL_DATA_NAME, commCol);
		
		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		
		return new DataPackage(DATA_NAME, data);
	}
	

	// initialize the colors with default values
	private void init() {	
		activator = LogColorsActivationManager.getInstance();
		
		/** processes */
		loadProcCol = ANSIEscape.TX_BLUE;
		confProcCol = ANSIEscape.TX_BLUE;
		suppProcCol = ANSIEscape.TX_BLUE;
		
		/** sub-processes */
		loadSubprocCol = ANSIEscape.TX_GREEN;
		confSubprocCol = ANSIEscape.TX_GREEN;
		suppSubprocCol = ANSIEscape.TX_GREEN;
	
		/** instructions */
		loadInstCol = ANSIEscape.TX_YELLOW;
		confInstCol = ANSIEscape.TX_YELLOW;
		suppInstCol = ANSIEscape.TX_YELLOW;
		
		/** communications */
		commCol = ANSIEscape.TX_RED;
		
		update();
	}
	
	// refresh the colors with the dynamic values
	private void update() {
		colors = new TreeMap<>();
		
		/** processes */
		colors.put(Log.LOAD_PROC_CODE, loadProcCol);
		colors.put(Log.CONF_PROC_CODE, confProcCol);
		colors.put(Log.SUPP_PROC_CODE, suppProcCol);
		
		/** sub-processes */
		colors.put(Log.LOAD_SUBPROC_CODE, loadSubprocCol);
		colors.put(Log.CONF_SUBPROC_CODE, confSubprocCol);
		colors.put(Log.SUPP_SUBPROC_CODE, suppSubprocCol);

		/** instructions */
		colors.put(Log.LOAD_INST_CODE, loadInstCol);
		colors.put(Log.CONF_INST_CODE, confInstCol);
		colors.put(Log.SUPP_INST_CODE, suppInstCol);

		/** communications */
		colors.put(Log.COMM_CODE, commCol);
	}
}
