
package main.log;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	static Map<String, Integer> options;
	
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
			LogActivationManager.instance
			.enabled.put(options.get(key), argument);
		}
	}


	/** Initialize the status */
	private static void init() {
		options = new HashMap<>();
		
	options.put("--log", LogMessage.MAIN_LOG_CODE.getCode());
	options.put("-l", LogMessage.MAIN_LOG_CODE.getCode());

	options.put("--load-prc", LogMessage.SLOAD_PROC.getCode());
	options.put("-lp", LogMessage.SLOAD_PROC.getCode());

	options.put("--conf-prc", LogMessage.SCONF_PROC.getCode());
	options.put("-cp", LogMessage.SCONF_PROC.getCode());

	options.put("--supply-prc", LogMessage.SSUPPLY_PROC.getCode());
	options.put("-sp", LogMessage.SSUPPLY_PROC.getCode());

	options.put("--load-subprc", LogMessage.SLOAD_SUBPROC.getCode());
	options.put("-lsp", LogMessage.SLOAD_SUBPROC.getCode());

	options.put("--conf-subprc", LogMessage.SCONF_SUBPROC.getCode());
	options.put("-csp", LogMessage.SCONF_SUBPROC.getCode());

	options.put("--supp-subprc", LogMessage.SSUPPLY_SUBPROC.getCode());
	options.put("-ssp", LogMessage.SSUPPLY_SUBPROC.getCode());

	options.put("--load-inst", LogMessage.ILOAD_DATA.getCode());
	options.put("-li", LogMessage.ILOAD_DATA.getCode());

	options.put("--conf-inst", LogMessage.ICONF_DATA.getCode());
	options.put("-ci", LogMessage.ICONF_DATA.getCode());

	options.put("--supply-inst", LogMessage.ISUPP_DATA.getCode());
	options.put("-si", LogMessage.ISUPP_DATA.getCode());
	
	options.put("--com", LogMessage.C_DATA_FOUND.getCode());
	options.put("-c", LogMessage.C_DATA_FOUND.getCode());
	}
}
