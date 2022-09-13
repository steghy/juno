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

	/*========== MAIN CODE ===================*/
	
	/** Main activation */
	MAIN_LOG_CODE("", -1),
	
	/*================== PROCESSES ====================================*/
	
	/** Loading process start. Code: 0 */
	SLOAD_PROC("=> Loading process started", 0),
	/** Loading process end. Code: 0 */
	ELOAD_PROC("=> Loading process finished", 0),
	
	/** Configuration process start. Code: 1 */
	SCONF_PROC("=> Configuration process started", 1),
	
	/** Configuration process end. Code: 1 */
	ECONF_PROC("=> Configuration process finished", 1),
		
	/** Supply process start. Code: 2 */
	SSUPPLY_PROC("=> Supply process started",  2),
	
	/** Supply process end. Code: 2 */
	ESUPPLY_PROC("=> Supply process finished",  2),
	
	
	/*=============== SUB-PROCESSES =======================================*/
	
	/** Loading sub-process start. Code: 3 */
	SLOAD_SUBPROC("==> Data loading process started", 3),
	
	/** Loading sub-process end. Code: 3 */
	ELOAD_SUBPROC("==> Data loading process finished", 3),
	
	/** Configuration sub-process start. Code: 4 */
	SCONF_SUBPROC("==> Data setting process started", 4),
	
	/** Configuration sub-process end. Code: 4 */
	ECONF_SUBPROC("==> Data setting process finished", 4),
	
	/** Supply sub-process start. Code: 5 */
	SSUPPLY_SUBPROC("==> Data supply process started", 5),
	
	/** Supply sub-process end. Code: 5 */
	ESUPPLY_SUBPROC("==> Data supply process finished", 5),

	
	/*============== INSTRUCTIONS ===========================================*/
	
	/** Loading instruction. Code: 6 */
	ILOAD_DATA("===> Loading the data ", 6),
	
	/** Configuration instruction. Code: 7 */ 
	ICONF_DATA("===> Setting the data ", 7),
	
	/** Supply instruction. Code: 8 */ 
	ISUPP_DATA("===> Providing the data ", 8),

	
	/*============= COMMUNICATINS ==========================*/
	
	/** Communication 'Data not found'. Code: 9 */
	C_NO_DATA_FOUND("Data not found", 9),
	
	/** Communication 'Data found'. Code: 9 */
	C_DATA_FOUND("Data found", 9),
	
	/** Communication 'Test start'. Code: 9 */
	TC_START("Test start",  9),
	
	/** Communication 'Test end'. Code: 9 */
	TC_END("Test end", 9); 

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
