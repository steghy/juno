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

public class LogColors implements Exportable, Configurable{
	
	/** default colors */
	public static final String DEF_PROC_COL = ANSIEscape.TX_BLUE;
	public static final String DEF_SUBPROC_COL = ANSIEscape.TX_RED;
	public static final String DEF_INST_COL = ANSIEscape.TX_CYAN;
	public static final String DEF_COMM_COL = ANSIEscape.TX_GREEN;
	
	/** data name */
	public static final String DATA_NAME = "log-colors";
	
	/** processes data names */
	public static final String LOAD_PROC_COL_DATA_NAME = "load-proc-color";
	public static final String CONF_PROC_COL_DATA_NAME = "conf-proc-color";
	public static final String SUPP_PROC_COL_DATA_NAME = "supp-proc-color";
	
	/** sub-processes data names */
	public static final String LOAD_SUBPROC_COL_DATA_NAME = "load-subproc-color";
	public static final String CONF_SUBPROC_COL_DATA_NAME = "conf-subproc-color";
	public static final String SUPP_SUBPROC_COL_DATA_NAME = "supp-subproc-color";
	
	/** instructions data names */
	public static final String LOAD_INST_COL_DATA_NAME = "load-ins-color";
	public static final String CONF_INST_COL_DATA_NAME = "conf-ins-color";
	public static final String SUPP_INST_COL_DATA_NAME = "supp-ins-color";
	
	/** communicatons data names */
	public static final String COMM_COL_DATA_NAME = "comm-color";
	
	/** processes color */
	private String loadProcCol;
	private String confProcCol;
	private String suppProcCol;
	
	/** sub-processes color */
	private String loadSubprocCol;
	private String confSubprocCol;
	private String suppSubprocCol;
	
	/** instructions color */
	private String loadInstCol;
	private String confInstCol;
	private String suppInstCol;
	
	/** communications color */
	private String commCol;
	
	private LogColorsActivationManager activator;
	
	/** associazioni codiceMessaggio-colore */
	private Map<Integer, String> colors;
		
	/** istanza unica */
	private static LogColors instance;
	
	/**
	 * Singleton.
	 */
	private LogColors() {	
		init();
	}
	
	/**
	 * Ritorna l'unica istanza di questa classe
	 * @return LogColors instance.
	 */
	public static LogColors getInstance() {
		
		if(LogColors.instance == null) {
			LogColors.instance = new LogColors();
		}
		return LogColors.instance;
	}
	
	/** 
	 * Restituisce la sequenza di escape ANSI associata
	 * al codice del messaggio di Debug
	 * @param logMessage Un DebugMessage
	 * @return Un ANSIEscape
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
	

	/**
	 * Inizializza i campi del LogColors
	 */
	private void init() {	
		
		activator = LogColorsActivationManager.getInstance();
		
		/** processes */
		loadProcCol = DEF_PROC_COL;
		confProcCol = DEF_PROC_COL;
		suppProcCol = DEF_PROC_COL;
		
		/** sub-processes */
		loadSubprocCol = DEF_SUBPROC_COL;
		confSubprocCol = DEF_SUBPROC_COL;
		suppSubprocCol = DEF_SUBPROC_COL;
	
		/** instructions */
		loadInstCol = DEF_INST_COL;
		confInstCol = DEF_INST_COL;
		suppInstCol = DEF_INST_COL;
		
		/** communications */
		commCol = DEF_COMM_COL;
		
		update();
	}
	
	/**
	 * Inizializza la mappa che associa al Debug code un colore
	 * @return Map<Integer, ANSIEscape>
	 */
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
