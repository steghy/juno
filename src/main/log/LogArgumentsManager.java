
package main.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.util.ArgumentsFilter;
import main.util.ArgumentsSorter;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogArgumentsManager {
	
	/* Main activator | Options name */
	static final String LOG_FOPT = "--log";
	static final String LOG_SOPT = "-l";
	
	/* Loading process | Options name */
	static final String LOG_LOAD_PRC_FOPT = "--log-loadprc";
	static final String LOG_LOAD_PRC_SOPT = "-llp";
	
	/* Configuration process | Options name */
	static final String LOG_CONF_PRC_FOPT = "--log-confprc";
	static final String LOG_CONF_PRC_SOPT = "-lcp";
	
	/* Supply process | Options name */
	static final String LOG_SUPP_PRC_FOPT = "--log-supplyprc";
	static final String LOG_SUPP_PRC_SOPT = "-lsp";
	
	/* Loading sub-process | Options name */
	static final String LOG_SUBPRC_LOAD_FOPT = "--log-load-subprc";
	static final String LOG_SUBPRC_LOAD_SOPT = "-llsp";
	
	/* Configuration sub-process | Options name */
	static final String LOG_SUBPRC_CONF_FOPT = "--log-conf-subprc";
	static final String LOG_SUBPRC_CONF_SOPT = "-lcsp"; 
	
	/* Supply sub-process | Options name */
	static final String LOG_SUBPRC_SUPP_FOPT = "--log-supp-subprc";
	static final String LOG_SUBPRC_SUPP_SOPT = "-lssp";
	
	/* Loading instructions | Options name */
	static final String LOG_INSTR_LOAD_FOPT = "--log-loadinst";
	static final String LOG_INSTR_LOAD_SOPT = "-lli";
	
	/* Configuration instructions | Options name */
	static final String LOG_INSTR_CONF_FOPT = "--log-confinst";
	static final String LOG_INSTR_CONF_SOPT = "-lci";
	
	/* Supply instructions | Options name */
	static final String LOG_INSTR_SUPP_FOPT = "--log-supplyinst";
	static final String LOG_INSTR_SUPP_SOPT = "-lsi";
	
	/* Communications | Options name */
	static final String LOG_COM_FOPT = "--log-com";
	static final String LOG_COM_SOPT = "-lc";
	
	/* List of all options */
	private static List<String> options;

	
	/* No instance */
	private LogArgumentsManager() {}

	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void active(String[] args) {
	
		// Initializes all options
		if(options == null) {
			init();
		}
		
		// It only takes the recognized options
		Map<String, Optional<Object>> filteredArgs = ArgumentsFilter
				.filter(options, ArgumentsSorter.getArguments(args));
		
		for(String key: filteredArgs.keySet()) {

			Optional<Object> optional = filteredArgs.get(key);
			boolean argument;
			
			// Check argument presence
			if(optional.isEmpty()) {
				throw new IllegalArgumentException("The argument "
						+ "for the option is missing, option (" + key + ")");
			}

			// Check for multiple arguments for a single option
			ArrayList<Object> temp = (ArrayList<Object>) optional.get();
			if(temp.size() > 1) {
				throw new IllegalArgumentException("Too many arguments "
						+ "for the option:" + key);
			}
			
			// true or false ?
			String strArg = temp.get(0).toString();
			if(strArg.equals("true")) {
				argument = true;
			}
			else if(strArg.equals("false")) {
				argument = false;
			}
			
			// The argument can only be true or false
			else {
				throw new IllegalArgumentException("wrong argument: "
						+strArg+" for the option: "+key);
			}
			LogArgumentsManager.addressing(key, argument);
		}
	}

	
	private static void addressing(String key, boolean argument) {
		LogActivationManager instance = LogActivationManager.instance;
		if(key.equals(LOG_FOPT) || key.equals(LOG_SOPT)) {
			instance.enabled.put(LogCodes.MAIN_LOG_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_LOAD_PRC_FOPT) || key.equals(LOG_LOAD_PRC_SOPT)) {
			instance.enabled.put(LogCodes.LOAD_PROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_CONF_PRC_FOPT) || key.equals(LOG_CONF_PRC_SOPT)) {
			instance.enabled.put(LogCodes.CONF_PROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_SUPP_PRC_FOPT) || key.equals(LOG_SUPP_PRC_SOPT)) {
			instance.enabled.put(LogCodes.SUPP_PROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_SUBPRC_LOAD_FOPT) || key.equals(LOG_SUBPRC_LOAD_SOPT)) {
			instance.enabled.put(LogCodes.LOAD_SUBPROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_SUBPRC_CONF_FOPT) || key.equals(LOG_SUBPRC_CONF_SOPT)) {
			instance.enabled.put(LogCodes.CONF_SUBPROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_SUBPRC_SUPP_FOPT) || key.equals(LOG_SUBPRC_SUPP_SOPT)) {
			instance.enabled.put(LogCodes.SUPP_SUBPROC_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_INSTR_LOAD_FOPT) || key.equals(LOG_INSTR_LOAD_SOPT)) {
			instance.enabled.put(LogCodes.LOAD_INST_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_INSTR_CONF_FOPT) || key.equals(LOG_INSTR_CONF_SOPT)) {
			instance.enabled.put(LogCodes.CONF_INST_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_INSTR_SUPP_FOPT) || key.equals(LOG_INSTR_SUPP_SOPT)) {
			instance.enabled.put(LogCodes.SUPP_INST_CODE.getCode(), argument);
		}
		else if(key.equals(LOG_COM_FOPT) || key.equals(LOG_COM_FOPT)) {
			instance.enabled.put(LogCodes.COMM_CODE.getCode(), argument);
		}			
	}
	

	/** Initialize the status */
	private static void init() {
		options = new ArrayList<>();
		
		// Main options
		options.add(LOG_FOPT);     options.add(LOG_SOPT);
		
		// Process
		options.add(LOG_LOAD_PRC_FOPT); options.add(LOG_LOAD_PRC_SOPT);
		options.add(LOG_CONF_PRC_FOPT); options.add(LOG_CONF_PRC_SOPT);
		options.add(LOG_SUPP_PRC_FOPT); options.add(LOG_SUPP_PRC_SOPT);
		
		// Sub-processes
		options.add(LOG_SUBPRC_LOAD_FOPT); options.add(LOG_SUBPRC_LOAD_SOPT);
		options.add(LOG_SUBPRC_CONF_FOPT); options.add(LOG_SUBPRC_CONF_SOPT);
		options.add(LOG_SUBPRC_SUPP_FOPT); options.add(LOG_SUBPRC_SUPP_SOPT);
		
		// Instructions
		options.add(LOG_INSTR_LOAD_FOPT); options.add(LOG_INSTR_LOAD_SOPT);
		options.add(LOG_INSTR_CONF_FOPT); options.add(LOG_INSTR_CONF_SOPT);
		options.add(LOG_INSTR_SUPP_FOPT); options.add(LOG_INSTR_SUPP_SOPT);
		
		// Communications
		options.add(LOG_COM_FOPT); options.add(LOG_COM_SOPT);
	}
}
