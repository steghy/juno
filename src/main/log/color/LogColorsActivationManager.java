package main.log.color;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.main.Log;
import main.log.messages.LogMessage;
import main.log.utils.LogUtil;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogColorsActivationManager implements Exportable, Configurable {

	static final String DATA_NAME = "log-colors-service-status";
	static final String LOG_MAIN_COL_STAT_DATA_NAME = "log-main-color-service-status";
	static final String LOAD_PROC_COL_DATA_NAME = "load-proc-color-service-status";
	static final String CONF_PROC_COL_DATA_NAME = "conf-proc-color-service-status";
	static final String SUPP_PROC_COL_DATA_NAME = "supp-proc-color-service-status";
	static final String LOAD_SUBPROC_COL_DATA_NAME = "load-subproc-color-service-status";
	static final String CONF_SUBPROC_COL_DATA_NAME = "conf-subproc-color-service-status";
	static final String SUPP_SUBPROC_COL_DATA_NAME = "supp-subproc-color-service-status";
	static final String LOAD_INST_COL_DATA_NAME = "load-inst-color-service-status";
	static final String CONF_INST_COL_DATA_NAME = "conf-inst-color-service-status";
	static final String SUPP_INST_COL_DATA_NAME = "supp-inst-color-service-status";
	static final String COMM_COL_DATA_NAME = "comm-color-service-status";

	//
	private boolean mainlogStat;
	
	//
	private boolean loadProcColStat;
	private boolean confProcColStat;
	private boolean suppProcColStat;

	//
	private boolean loadSubprocColStat;
	private boolean confSubprocColStat;
	private boolean suppSubprocColStat;

	//
	private boolean loadInstColStat;
	private boolean confInstColStat;
	private boolean suppInstColStat;

	//
	private boolean commColStat;

	//
	private Map<Integer, Boolean> enabled;
	
	//
	private static LogColorsActivationManager instance;

	// Builds a LCAM for the LogColors class
	private LogColorsActivationManager() {
		init();
	}
	
	/**
	 * 
	 * @return
	 */
	public static LogColorsActivationManager getInstance() {
		if(instance == null) {
			instance = new LogColorsActivationManager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param message
	 * @return A boolean
	 */
	public boolean isActive(LogMessage message) {
		int code = message.getCode();
		if(enabled.containsKey(code)) {
			if(mainlogStat) {
				return true;
			}
			else {
				return enabled.get(code);
			}
		} 
		else {
			throw new IllegalArgumentException("Unreconized "
					+ "code message:" + code);
		}
	}
	
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
				//main log
				mainlogStat = LogUtil
						.toBoolean(data.get(LOG_MAIN_COL_STAT_DATA_NAME));
				
				// processes
				loadProcColStat = LogUtil
						.toBoolean(data.get(LOAD_PROC_COL_DATA_NAME));

				confProcColStat = LogUtil
						.toBoolean(data.get(CONF_PROC_COL_DATA_NAME));

				suppProcColStat = LogUtil
						.toBoolean(data.get(SUPP_PROC_COL_DATA_NAME));

				// sub-processes
				loadSubprocColStat = LogUtil
						.toBoolean(data.get(LOAD_SUBPROC_COL_DATA_NAME));

				confSubprocColStat = LogUtil
						.toBoolean(data.get(CONF_SUBPROC_COL_DATA_NAME));

				suppSubprocColStat = LogUtil
						.toBoolean(data.get(SUPP_SUBPROC_COL_DATA_NAME));

				// instructions
				loadInstColStat = LogUtil
						.toBoolean(data.get(LOAD_INST_COL_DATA_NAME));

				confInstColStat = LogUtil
						.toBoolean(data.get(CONF_INST_COL_DATA_NAME));

				suppInstColStat = LogUtil
						.toBoolean(data.get(SUPP_INST_COL_DATA_NAME));

				// communications
				commColStat = LogUtil.toBoolean(data.get(COMM_COL_DATA_NAME));
				
				//aggiornamento dei valori nella mappa
				update();
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
		Map<String, Object> data = new HashMap<>();
		//main
		data.put(LOG_MAIN_COL_STAT_DATA_NAME, mainlogStat);
		
		// processes
		data.put(LOAD_PROC_COL_DATA_NAME, loadProcColStat);
		data.put(CONF_PROC_COL_DATA_NAME, confProcColStat);
		data.put(SUPP_PROC_COL_DATA_NAME, suppProcColStat);

		// sub-processes
		data.put(LOAD_SUBPROC_COL_DATA_NAME, loadSubprocColStat);
		data.put(CONF_SUBPROC_COL_DATA_NAME, confSubprocColStat);
		data.put(SUPP_SUBPROC_COL_DATA_NAME, suppSubprocColStat);

		// instructions
		data.put(LOAD_INST_COL_DATA_NAME, loadInstColStat);
		data.put(CONF_INST_COL_DATA_NAME, confInstColStat);
		data.put(SUPP_INST_COL_DATA_NAME, suppInstColStat);

		// communications
		data.put(COMM_COL_DATA_NAME, commColStat);

		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		return new DataPackage(DATA_NAME, data);
	}
	
	public void setMainLogColStat(boolean value) {
		mainlogStat = value;
	}
	
	public void setLoadProcColStat(boolean value) {
		loadProcColStat = value;
	}
	public void setConfProcColStat(boolean value) {
		confProcColStat = value;
	}
	public void setSuppProcColStat(boolean value) {
		suppProcColStat = value;
	}
	
	
	public void setLoadSUBProcColStat(boolean value) {
		loadSubprocColStat = value;
	}
	public void setConfSUBProcColStat(boolean value) {
		confSubprocColStat = value;
	}
	public void setSuppSUBProcColStat(boolean value) {
		suppSubprocColStat = value;
	}
	
	public void setLoadInstColStat(boolean value) {
		loadInstColStat = value;
	}
	public void setConfInstColStat(boolean value) {
		confInstColStat = value;
	}
	public void setSuppSInstColStat(boolean value) {
		suppInstColStat = value;
	}
	public void setCommColStat(boolean value) {
		commColStat = value;
	}
	
	
	/**
	 * Inizializza l'obj LogColorsActivationManager.
	 */
	private void init() {
	
		/** main **/
		mainlogStat = false;
		
		/** processes */
		loadProcColStat = false;
		confProcColStat = false;
		suppProcColStat = false;
	
		/** sub-processes */
		loadSubprocColStat = false;
		confSubprocColStat = false;
		suppSubprocColStat = false;

		/** instructions */
		loadInstColStat = false;
		confInstColStat = false;
		suppInstColStat = false;

		/** communications */
		commColStat = false;
		
		update();
	}
	
	/**
	 * 
	 */
	private void update() {
		
		enabled = new TreeMap<>();
					
		/** processes */
		enabled.put(Log.LOAD_PROC_CODE, loadProcColStat);
		enabled.put(Log.CONF_PROC_CODE, confProcColStat);
		enabled.put(Log.SUPP_PROC_CODE, suppProcColStat);
		
		/** sub-processes */
		enabled.put(Log.LOAD_SUBPROC_CODE, loadSubprocColStat);
		enabled.put(Log.CONF_SUBPROC_CODE, confSubprocColStat);
		enabled.put(Log.SUPP_SUBPROC_CODE, suppSubprocColStat);

		/** instructions */
		enabled.put(Log.LOAD_INST_CODE, loadInstColStat);
		enabled.put(Log.CONF_INST_CODE, confInstColStat);
		enabled.put(Log.SUPP_INST_CODE, suppInstColStat);

		/** communications */
		enabled.put(Log.COMM_CODE, commColStat);

	}

}
