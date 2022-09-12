package main.log;

/**
 * This class contains all the codes necessary to
 * distinguish the types of prints.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum LogCodes {
	

	/** Main code (All printouts are active) */
	MAIN_LOG_CODE(-1),
	
	/** Loading process code */
	LOAD_PROC_CODE(0),
	
	/** Configuration process code */
	CONF_PROC_CODE(1),
	
	/** Supply process code */
	SUPP_PROC_CODE(2),
	
	/** Loading sub-process code */
	LOAD_SUBPROC_CODE(3),
	
	/**  Configuration sub-process code */
	CONF_SUBPROC_CODE(4),
	
	/** Supply sub-process code */
	SUPP_SUBPROC_CODE(5),
	
	/** Loading instruction code */
	LOAD_INST_CODE(6),
	
	/** Configuration instruction code */
	CONF_INST_CODE(7),
	
	/** Supply instruction code */
	SUPP_INST_CODE(8),
	
	/** Communication code */
	COMM_CODE(9);
	
	/* The code */
	private int code;
	
	/* Builds a code object. */
	private LogCodes(int code) {
		this.code = code;
	}
	
	/**
	 * Returns the code 
	 * @return The code
	 */
	int getCode() {
		return this.code;
	}
}
