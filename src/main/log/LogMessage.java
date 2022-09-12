package main.log;

/**
 * This enumerative class provides objects composed of a message and a code.
 * The message explicitly identifies the type of message to be displayed 
 * in the terminal and/or saved in the log. The code allows you to enable 
 * or disable each print individually (see: LogActivation *).
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum LogMessage {

	
	/*================== PROCESSES ====================================*/
	
	/** Loading process start. Code: 0 */
	SLOAD_PROC("=> Loading process started",        Log.LOAD_PROC_CODE),
	
	/** Loading process end. Code: 0 */
	ELOAD_PROC("=> Loading process finished",       Log.LOAD_PROC_CODE),
	
	/** Configuration process start. Code: 1 */
	SCONF_PROC("=> Configuration process started",  Log.CONF_PROC_CODE),
	
	/** Configuration process end. Code: 1 */
	ECONF_PROC("=> Configuration process finished", Log.CONF_PROC_CODE),
		
	/** Supply process start. Code: 2 */
	SSUPPLY_PROC("=> Supply process started",       Log.SUPP_PROC_CODE),
	
	/** Supply process end. Code: 2 */
	ESUPPLY_PROC("=> Supply process finished",      Log.SUPP_PROC_CODE),
	
	
	/*=============== SUB-PROCESSES =======================================*/
	
	/** Loading sub-process start. Code: 3 */
	SLOAD_SUBPROC("==> Data loading process started", Log.LOAD_SUBPROC_CODE),
	
	/** Loading sub-process end. Code: 3 */
	ELOAD_SUBPROC("==> Data loading process finished", Log.LOAD_SUBPROC_CODE),
	
	/** Configuration sub-process start. Code: 4 */
	SCONF_SUBPROC("==> Data setting process started", Log.CONF_SUBPROC_CODE),
	
	/** Configuration sub-process end. Code: 4 */
	ECONF_SUBPROC("==> Data setting process finished", Log.CONF_SUBPROC_CODE),
	
	/** Supply sub-process start. Code: 5 */
	SSUPPLY_SUBPROC("==> Data supply process started", Log.SUPP_SUBPROC_CODE),
	
	/** Supply sub-process end. Code: 5 */
	ESUPPLY_SUBPROC("==> Data supply process finished", Log.SUPP_SUBPROC_CODE),

	
	/*============== INSTRUCTIONS ===========================================*/
	
	/** Loading instruction. Code: 6 */
	ILOAD_DATA("===> Loading the data ", Log.LOAD_INST_CODE),
	
	/** Configuration instruction. Code: 7 */ 
	ICONF_DATA("----setting the data ", Log.CONF_INST_CODE),
	
	/** Supply instruction. Code: 8 */ 
	ISUPP_DATA("----providing the data ", Log.SUPP_INST_CODE),

	
	/*============= COMMUNICATINS ==========================*/
	
	/** Communication 'Data not found'. Code: 9 */
	C_NO_DATA_FOUND("Data not found", Log.COMM_CODE),
	
	/** Communication 'Data found'. Code: 9 */
	C_DATA_FOUND("Data found", Log.COMM_CODE),
	
	/** Communication 'Test start'. Code: 9 */
	TC_START("Test start", Log.COMM_CODE),
	
	/** Communication 'Test end'. Code: 9 */
	TC_END("Test end", Log.COMM_CODE);
	

	/* The message */
	private String message;
	
	/* The code message */
	private int code;
	
	
	/* Builds a new LogMessage with the specified values*/
	private LogMessage(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	
	/**
	 * Returns the code message
	 * @return The code message
	 */
	public int getCode() {
		return this.code;
	}
	

	@Override
	public String toString() {
		return this.message;
	}
}
