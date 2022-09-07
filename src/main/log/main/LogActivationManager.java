package main.log.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.messages.LogMessage;
import main.log.utils.LogUtil;

public class LogActivationManager implements Configurable, Exportable{

	/** default values */
	public static final boolean DEF_MAIN_LOG_STAT = false;
	public static final boolean DEF_PROC_STAT = false;
	public static final boolean DEF_SUBPROC_STAT = false;
	public static final boolean DEF_INST_STAT = false;
	public static final boolean DEF_COMM_STAT = false;

	/** data name */
	public static final String DATA_NAME = "log-service-status";

	/** main data name */
	public static final String LOG_MAIN_STAT_DATA_NAME = "log-main-service-status";

	/** processes data names */
	public static final String 
	LOAD_PROC_STAT_DATA_NAME = "load-proc-service-status";
	
	public static final String 
	CONF_PROC_STAT_DATA_NAME = "conf-proc-service-status";

	public static final String 
	SUPP_PROC_STAT_DATA_NAME = "supp-proc-service-status";

	/** sub-processes data names */
	public static final String 
	LOAD_SUBPROC_STAT_DATA_NAME = "load-subproc-service-status";

	public static final String 
	CONF_SUBPROC_STAT_DATA_NAME = "conf-subproc-service-status";

	public static final String 
	SUPP_SUBPROC_STAT_DATA_NAME = "supp-subproc-service-status";

	/** instructions data names */
	public static final String LOAD_INST_STAT_DATA_NAME = "load-ins-service-status";
	public static final String CONF_INST_STAT_DATA_NAME = "conf-ins-service-status";
	public static final String SUPP_INST_STAT_DATA_NAME = "supp-ins-service-status";

	/** communicatons data names */
	public static final String COMM_STAT_DATA_NAME = "com-service-status";

	/** main activation */
	private boolean mainLogStat;

	/** processes activation */
	private boolean loadProcStat;
	private boolean confProcStat;
	private boolean suppProcStat;

	/** sub-processes activation */
	private boolean loadSubprocStat;
	private boolean confSubprocStat;
	private boolean suppSubprocStat;

	/** instructions activaton */
	private boolean loadInstStat;
	private boolean confInstStat;
	private boolean suppInstStat;

	/** communications activation */
	private boolean commStat;

	/** contiene le associazioni codice-abilitazione stampa*/
	private Map<Integer, Boolean> enabled;

	private static LogActivationManager instance;

	/**
	 * Singleton
	 */
	private LogActivationManager() {
		init();
	}

	/**
	 * Ritorna l'unica istanza di questa classe
	 * @return Un DebugEnabler
	 */
	public static LogActivationManager getInstance() {
		if(instance == null) {
			instance = new LogActivationManager();
		}
		return instance;
	}

	/**
	 * Restituisce true se il main-log è attivo, altrimenti
	 * restituisce il booleano associato al codice messaggio
	 * fornito in input
	 * @param logMessage Il log message
	 * @return Un booleano
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
	
	public static void main(){
		System.out.println();
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

				//main
				mainLogStat = LogUtil
						.toBoolean(data
								.get(LOG_MAIN_STAT_DATA_NAME));
				//processes
				loadProcStat = LogUtil
						.toBoolean(data
								.get(LOAD_PROC_STAT_DATA_NAME));

				confProcStat = LogUtil
						.toBoolean(data
								.get(CONF_PROC_STAT_DATA_NAME));

				suppProcStat = LogUtil
						.toBoolean(data
								.get(SUPP_PROC_STAT_DATA_NAME));

				//sub-processes
				loadSubprocStat = LogUtil
						.toBoolean(data
								.get(LOAD_SUBPROC_STAT_DATA_NAME));

				confSubprocStat = LogUtil
						.toBoolean(data
								.get(CONF_SUBPROC_STAT_DATA_NAME));

				suppSubprocStat = LogUtil
						.toBoolean(data
								.get(SUPP_SUBPROC_STAT_DATA_NAME));

				//instructions
				loadInstStat = LogUtil
						.toBoolean(data
								.get(LOAD_INST_STAT_DATA_NAME));

				confInstStat = LogUtil
						.toBoolean(data
								.get(CONF_INST_STAT_DATA_NAME));

				suppInstStat = LogUtil
						.toBoolean(data
								.get(SUPP_INST_STAT_DATA_NAME));

				//communications
				commStat = LogUtil
						.toBoolean(data
								.get(COMM_STAT_DATA_NAME));

				//aggiornamento valori nella mappa
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

	/**
	 * Reimposta l'abilitatore ai valori di default
	 */
	private void init() {

		/** main activation */
		mainLogStat = DEF_MAIN_LOG_STAT;

		/** processes activation */
		loadProcStat = DEF_PROC_STAT;
		confProcStat = DEF_PROC_STAT;
		suppProcStat = DEF_PROC_STAT;

		/** sub-processes activation */
		loadSubprocStat = DEF_SUBPROC_STAT;
		confSubprocStat = DEF_SUBPROC_STAT;
		suppSubprocStat = DEF_SUBPROC_STAT;

		/** instructions activaton */
		loadInstStat = DEF_INST_STAT;
		confInstStat = DEF_INST_STAT;
		suppInstStat = DEF_INST_STAT;

		/** communications activation */
		commStat = DEF_COMM_STAT;

		update();
	}

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

	public void setLogMainStat(boolean value) {
		this.mainLogStat = value;
	}


	public void setLoadProStat(boolean value) {
		this.loadProcStat = value;
	}
	public void setConfProStat(boolean value) {
		this.confProcStat = value;
	}
	public void setSuppProStat(boolean value) {
		this.suppProcStat = value;
	}


	public void setLoadSUBProStat(boolean value) {
		this.loadSubprocStat = value;
	}
	public void setConfSUBProStat(boolean value) {
		this.confSubprocStat = value;
	}
	public void setSuppSUBProStat(boolean value) {
		this.suppSubprocStat = value;
	}


	public void setLoadInstStat(boolean value) {
		this.loadInstStat = value;
	}
	public void setConfInstStat(boolean value) {
		this.confInstStat = value;
	}
	public void setSuppInstStat(boolean value) {
		this.suppInstStat = value;
	}


	public void setCommStat(boolean value) {
		this.commStat = value;
	}




}
