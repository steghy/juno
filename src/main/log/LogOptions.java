package main.log;

/**
 * This class defines the options for the LogActivation
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum LogOptions {

	/** Main switch */
	MAIN_LOG("--log", "-l", LogMessage.MAIN_LOG_CODE.getCode()),
	
	/** Loading process switch */
	LOAD_PRC("--load-prc", "-lp", LogMessage.SLOAD_PROC.getCode()),

	/** Configuration process switch */
	CONF_PROC("--conf-prc", "-cp", LogMessage.SCONF_PROC.getCode()),

	/** Supply process switch */
	SUPP_PRC("--supply-prc", "-sp", LogMessage.SSUPPLY_PROC.getCode()),

	/** Loading sub-process switch */
	LOAD_SUBPRC("--load-subprc", "-lsp", LogMessage.SLOAD_SUBPROC.getCode()),

	/** Configuration sub-process switch */
	CONF_SUBPRC("--conf-subprc", "-csp", LogMessage.SCONF_SUBPROC.getCode()),

	/** Supply sub-process switch */
	SUPP_SUBPRC("--supp-subprc", "-ssp", LogMessage.SSUPPLY_SUBPROC.getCode()),

	/** Loading instruction switch */
	LOAD_INST("--load-inst", "-li", LogMessage.ILOAD_DATA.getCode()),

	/** Configuration instruction switch */
	CONF_INST("--conf-inst", "-ci", LogMessage.ICONF_DATA.getCode()),

	/** Supply instruction switch */
	SUPP_INST("--supply-inst", "-si", LogMessage.ISUPP_DATA.getCode()),
	
	/** Communication switch */
	COMM("--com", "-c", LogMessage.C_DATA_FOUND.getCode());
	
	/* The extended pption */
	private String extendedOption;
	
	/* The contracted option */
	private String contractedOption;
	
	/* The code */
	private int code;
	
	
	/* Builds an Option */
	private LogOptions(String extendedOption, 
			String contractedOption, int code) {

		this.extendedOption = extendedOption;
		this.contractedOption = contractedOption;
		this.code = code;
	}
	
	
	/**
	 * Returns the extended option
	 * @return The extended option
	 */
	public String getExtendedOption() {
		return this.extendedOption;
	}
	
	
	/**
	 * Returns the contracted option
	 * @return The contracted option
	 */
	public String getContractedOption() { 
		return this.contractedOption;
	}
	
	
	/**
	 * Returns the code
	 * @return The code
	 */
	public int getCode() {
		return this.code;
	}
}