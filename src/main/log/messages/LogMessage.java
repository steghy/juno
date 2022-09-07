package main.log.messages;

import main.log.main.Log;

public enum LogMessage {
	
	/***************PROCESSES***************************************/
	
	//loading processes
	SLOAD_PROC("<<loading process started>> ", Log.LOAD_PROC_CODE),
	ELOAD_PROC("<<loading process finished>> ", Log.LOAD_PROC_CODE),
	
	//configuration processes
	SCONF_PROC("<<configuration process started>> ", Log.CONF_PROC_CODE),
	ECONF_PROC("<<configuration process finished>> ", Log.CONF_PROC_CODE),
		
	//loading processes
	SSUPPLY_PROC("<<supply process started>> ", Log.SUPP_PROC_CODE),
	ESUPPLY_PROC("<<supply process finished>> ", Log.SUPP_PROC_CODE),
		
	/***********SUB-PROCESSES****************************************/
	
	//loading sub-processes
	SLOAD_SUBPROC("--data loading process started ", Log.LOAD_SUBPROC_CODE),
	ELOAD_SUBPROC("--data loading process finished ", Log.LOAD_SUBPROC_CODE),
	
	//setting sub-processes
	SCONF_SUBPROC("--data setting process started ", Log.CONF_SUBPROC_CODE),
	ECONF_SUBPROC("--data setting process finished ", Log.CONF_SUBPROC_CODE),
	
    //supply sub-processes
	SSUPPLY_SUBPROC("--data supply process started ", Log.SUPP_SUBPROC_CODE),
	ESUPPLY_SUBPROC("--data supply process finished ", Log.SUPP_SUBPROC_CODE),
	
	/************INSTRUCTIONS*****************************************/
	
	//specific instructions
	ILOAD_DATA("----loading the data ",Log.LOAD_INST_CODE),
	ICONF_DATA("----setting the data ", Log.CONF_INST_CODE),
	ISUPP_DATA("----providing the data ", Log.SUPP_INST_CODE),
	
	/***********COMMUNICATINS******************************************/
	
	//communications
	C_NO_DATA_FOUND("****NO DATA FOUND****", Log.COMM_CODE),
	C_DATA_FOUND("****DATA FOUND******", Log.COMM_CODE),
	
	/***********TEST-COMMUNICATION**************************************/
	
	//test communications
	TC_START("********START OF THE TEST********", Log.COMM_CODE),
	TC_END("********END OF THE TEST********", Log.COMM_CODE);
	
	/** il messaggio */
	private String message;
	
	/** il codice */
	private int code;
	
	/**
	 * Costruisce un messaggio per il debug
	 * @param message Il messaggio
	 * @code code Il codice
	 */
	private LogMessage(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	/**
	 * Ritorna il codice del messaggio
	 * @return Il codice
	 */
	public int getCode() {
		return this.code;
	}
	
	public String toString() {
		return this.message;
	}
}
