package main.log;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum LogColorOptions {

	/** Main switch */
	MAIN_COLOR_LOG("--log-color", "-lc", LogMessage.MAIN_LOG_CODE.getCode()),
	
	/** Loading process color switch */
	LOAD_PROC_CLR("--load-prc-clr", "-lpc", LogMessage.SLOAD_PROC.getCode()),

	/** Configuration process color switch */
	CONF_PROC_CLR("--conf-prc-clr", "-cpc", LogMessage.SCONF_PROC.getCode()),

	/** Supply process color switch */
	SUPP_PROC_CLR("--supply-prc-clr", "-spc", LogMessage.SSUPPLY_PROC.getCode()),

	/** Loading sub-process color switch */
	LOAD_SUBPRC_CLR("--load-subprc-clr", "-lspc", LogMessage.SLOAD_SUBPROC.getCode()),

	/** Configuration sub-process color switch */
	CONF_SUBPRC_CLR("--conf-subprc-clr", "-cspc", LogMessage.SCONF_SUBPROC.getCode()),

	/** Supply sub-process color switch */
	SUPP_SUBPRC_CLR("--supp-subprc-clr", "-ssbc", LogMessage.SSUPPLY_SUBPROC.getCode()),

	/** Loading instruction color switch */
	LOAD_INST_CLR("--load-inst-clr", "-lic", LogMessage.ILOAD_DATA.getCode()),

	/** Configuration instruction color switch */
	CONF_INST_CLR("--conf-inst-clr", "-cic", LogMessage.ICONF_DATA.getCode()),

	/** Supply instruction color switch */
	SUPP_INST_CLR("--supply-inst-clr", "-sic", LogMessage.ISUPP_DATA.getCode()),

	/** Communication color switch */
	COMM_CLR("--com-clr", "-cc", LogMessage.C_DATA_FOUND.getCode());

	/* The extended option */
	private String extenderOption;
	
	/* The contracted option */
	private String contractedOption;
	
	/* The code */
	private int code;

	
	/* Builds an option */
	private LogColorOptions(String extendedOption,
			String contractedOption, int code) {
		this.extenderOption = extendedOption;
		this.contractedOption = contractedOption;
		this.code = code;
	}
	
	
	/**
	 * Returns the extended option
	 * @return The extended option
	 */
	public String getExtendedOption() {
		return this.extenderOption;
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