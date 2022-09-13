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
public class LogWriterArgumentsManager {
	
	/**
	 * extended option name
	 */
	public static final String LOG_WRITER_FOPT = "--log-file";

	/**
	 * contracted option name
	 */
	public static final String LOG_WRITER_SOPT = "-lf";
	
	// command-line options
	private static List<String> options;
	
	// singleton pattern
	private LogWriterArgumentsManager() {}
	
	/**
	 * Configure the activation status (command-line)
	 * @param args An array
	 */
	public static void active(String[] args) {
		
		if(options == null) {
			init();
		}
		
		Map<String, Optional<Object>> filteredArgs = ArgumentsFilter
				.filter(options, ArgumentsSorter.getArguments(args));
		for(String key: filteredArgs.keySet()) {	
			Optional<Object> optional = filteredArgs.get(key);
			boolean argument;
				if(optional.isEmpty()) {
						
					throw new IllegalArgumentException("the argument "
							+ "for the option is missing, option ("+key+")");
				}
				@SuppressWarnings("unchecked")
				ArrayList<Object> temp = ((ArrayList<Object>) optional.get());
				if(temp.size() > 1) {
					throw new IllegalArgumentException("too many arguments "
							+ "for the option:"+key);
				}
				String strArg = temp.get(0).toString();
				if(strArg.equals("true")) {
					argument = true;
				}
				else if(strArg.equals("false")) {
					argument = false;
				}
				else {
					throw new IllegalArgumentException("wrong argument: "
								+strArg+" for the option: "+key
								+". It needs to be a boolean.");
				}
				addressing(key, argument);
		}
	}

	
	/**
	 * 
	 * @param key The option name
	 * @param argument The argument of the option
	 */
	private static void addressing(String key, boolean argument) {
		LogWriterActivationManager instance = LogWriterActivationManager.getInstance();
		if(key.equals(LOG_WRITER_FOPT) || key.equals(LOG_WRITER_SOPT)) {
			instance.setStatus(argument);
		}
	}
	
	
	// initialize the options
	private static void init() {
		options = new ArrayList<>();
		options.add(LOG_WRITER_FOPT); // Extended
		options.add(LOG_WRITER_SOPT); // Contracted
	}

}
