package main.log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.messages.LogMessage;
import main.log.utils.LogUtil;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogActivationManager implements Configurable, Exportable{

	// data name
	static final String DATA_NAME = "log-service-status";
	
	// main service status
	static final String LOG_MAIN_STAT_DATA_NAME = "log-main-service-status";
	
	// processes service status
	static final String LOAD_PROC_STAT_DATA_NAME = "load-proc-service-status";
	static final String CONF_PROC_STAT_DATA_NAME = "conf-proc-service-status";
	static final String SUPP_PROC_STAT_DATA_NAME = "supp-proc-service-status";
	
	// sub-processes service status
	static final String LOAD_SUBPROC_STAT_DATA_NAME = "load-subproc-service-status";
	static final String CONF_SUBPROC_STAT_DATA_NAME = "conf-subproc-service-status";
	static final String SUPP_SUBPROC_STAT_DATA_NAME = "supp-subproc-service-status";
	
	// instructions service status
	static final String LOAD_INST_STAT_DATA_NAME = "load-ins-service-status";
	static final String CONF_INST_STAT_DATA_NAME = "conf-ins-service-status";
	static final String SUPP_INST_STAT_DATA_NAME = "supp-ins-service-status";
	
	// communications service status
	static final String COMM_STAT_DATA_NAME = "com-service-status";

	// Main status 
	private boolean mainLogStat;

	// Process status 
	private boolean loadProcStat;
	private boolean confProcStat;
	private boolean suppProcStat;

	// Sub-process status 
	private boolean loadSubprocStat;
	private boolean confSubprocStat;
	private boolean suppSubprocStat;

	// Instructions statsu
	private boolean loadInstStat;
	private boolean confInstStat;
	private boolean suppInstStat;

	// Communications status
	private boolean commStat;

	// enabled services
	private Map<Integer, Boolean> enabled;

	// The instance
	private static LogActivationManager instance;

	// Singleton pattern
	private LogActivationManager() {
		init();
	}

	
	/**
	 * 
	 * @return The instance
	 */
	public static LogActivationManager getInstance() {
		if(instance == null) {
			instance = new LogActivationManager();
		}
		return instance;
	}

	/**
	 * @param logMessage
	 * @return A boolean
	 */
	public boolean isActive(LogMessage logMessage) {
		int code = logMessage.getCode();
		if(enabled.containsKey(code)) {

			if(mainLogStat) {
				return true;
			}
			else {
				return enabled.get(code);
			}
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

		Map<String, Object> data = new HashMap<>();

		//main log
		data.put(LOG_MAIN_STAT_DATA_NAME, mainLogStat);

		//processes
		data.put(LOAD_PROC_STAT_DATA_NAME, loadProcStat);
		data.put(CONF_PROC_STAT_DATA_NAME, confProcStat);
		data.put(SUPP_PROC_STAT_DATA_NAME, suppProcStat);

		//sub-processes
		data.put(LOAD_SUBPROC_STAT_DATA_NAME, loadSubprocStat);
		data.put(CONF_SUBPROC_STAT_DATA_NAME, confSubprocStat);
		data.put(SUPP_SUBPROC_STAT_DATA_NAME, suppSubprocStat);

		//instructions
		data.put(LOAD_INST_STAT_DATA_NAME, loadInstStat);
		data.put(CONF_INST_STAT_DATA_NAME, confInstStat);
		data.put(SUPP_INST_STAT_DATA_NAME, suppInstStat);

		//communications
		data.put(COMM_STAT_DATA_NAME, commStat);

		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);

		return new DataPackage(DATA_NAME, data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void configure(DataPackage source) throws IOException {

		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");

		if(!(source.getName().equals(DATA_NAME))) {

			throw new IllegalArgumentException("Wrong data."
					+",no "+ DATA_NAME +" key found");
		}
		Map<String, Object> data = (HashMap) source.getData();
		if(data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		else {
			try {
				// main
				mainLogStat = LogUtil
						.toBoolean(data
								.get(LOG_MAIN_STAT_DATA_NAME));
				// processes
				loadProcStat = LogUtil
						.toBoolean(data
								.get(LOAD_PROC_STAT_DATA_NAME));

				confProcStat = LogUtil
						.toBoolean(data
								.get(CONF_PROC_STAT_DATA_NAME));

				suppProcStat = LogUtil
						.toBoolean(data
								.get(SUPP_PROC_STAT_DATA_NAME));

				// sub-processes
				loadSubprocStat = LogUtil
						.toBoolean(data
								.get(LOAD_SUBPROC_STAT_DATA_NAME));

				confSubprocStat = LogUtil
						.toBoolean(data
								.get(CONF_SUBPROC_STAT_DATA_NAME));

				suppSubprocStat = LogUtil
						.toBoolean(data
								.get(SUPP_SUBPROC_STAT_DATA_NAME));

				// instructions
				loadInstStat = LogUtil
						.toBoolean(data
								.get(LOAD_INST_STAT_DATA_NAME));

				confInstStat = LogUtil
						.toBoolean(data
								.get(CONF_INST_STAT_DATA_NAME));

				suppInstStat = LogUtil
						.toBoolean(data
								.get(SUPP_INST_STAT_DATA_NAME));

				// communications
				commStat = LogUtil
						.toBoolean(data
								.get(COMM_STAT_DATA_NAME));
				update();
			}
			catch(IllegalArgumentException e) {
				e.printStackTrace();
				init();
			}
		}
		Log.print(LogMessage.ILOAD_DATA, data);
		Log.print(LogMessage.ECONF_SUBPROC, "");
		Log.print(LogMessage.ECONF_PROC, DATA_NAME);
	}

	
	// Initialize the service status
	private void init() {

		// main default status
		mainLogStat = false;

		// process default status
		loadProcStat = false;
		confProcStat = false;
		suppProcStat = false;

		// sub-process default status
		loadSubprocStat = false;
		confSubprocStat = false;
		suppSubprocStat = false;

		// instructions default status
		loadInstStat = false;
		confInstStat = false;
		suppInstStat = false;

		// communications default status
		commStat = false;

		update();
	}

	
	/**
	 * 
	 */
	public void update() {
		enabled = new TreeMap<>();

		/** processes */
		enabled.put(Log.LOAD_PROC_CODE, loadProcStat);
		enabled.put(Log.CONF_PROC_CODE, confProcStat);
		enabled.put(Log.SUPP_PROC_CODE, suppProcStat);

		/** sub-processes */
		enabled.put(Log.LOAD_SUBPROC_CODE, loadSubprocStat);
		enabled.put(Log.CONF_SUBPROC_CODE, confSubprocStat);
		enabled.put(Log.SUPP_SUBPROC_CODE, suppSubprocStat);

		/** instructions */
		enabled.put(Log.LOAD_INST_CODE, loadInstStat);
		enabled.put(Log.CONF_INST_CODE, confInstStat);
		enabled.put(Log.SUPP_INST_CODE, suppInstStat);

		/** communications */
		enabled.put(Log.COMM_CODE, commStat);
	}

	
	/**
	 * 
	 * @param value
	 */
	public void setLogMainStat(boolean value) {
		this.mainLogStat = value;
	}


	/**
	 * 
	 * @param value
	 */
	public void setLoadProStat(boolean value) {
		this.loadProcStat = value;
	}

	
	/**
	 * 
	 * @param value
	 */
	public void setConfProStat(boolean value) {
		this.confProcStat = value;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setSuppProStat(boolean value) {
		this.suppProcStat = value;
	}

	
	/**
	 * 
	 * @param value
	 */
	public void setLoadSUBProStat(boolean value) {
		this.loadSubprocStat = value;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setConfSUBProStat(boolean value) {
		this.confSubprocStat = value;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setSuppSUBProStat(boolean value) {
		this.suppSubprocStat = value;
	}


	/**
	 * 
	 * @param value
	 */
	public void setLoadInstStat(boolean value) {
		this.loadInstStat = value;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setConfInstStat(boolean value) {
		this.confInstStat = value;
	}

	
	/**
	 * 
	 * @param value
	 */
	public void setSuppInstStat(boolean value) {
		this.suppInstStat = value;
	}


	/**
	 * 
	 * @param value
	 */
	public void setCommStat(boolean value) {
		this.commStat = value;
	}




}
