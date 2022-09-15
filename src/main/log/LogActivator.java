
package main.log;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import main.util.ArgumentsFilter;
import main.util.ArgumentsSorter;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogActivator {
	
	/* No instance */
	private LogActivator() {}
	
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void active(String[] args) {
	
		
		// It only takes the recognized options
		Map<String, Optional<Object>> filteredArgs = ArgumentsFilter
				.filter(LogOptionsUtils.getOptions(), 
						ArgumentsSorter.getArguments(args));
		
		for(String option: filteredArgs.keySet()) {

			Optional<Object> optional = filteredArgs.get(option);
			boolean value;
			
			// Check argument presence
			if(optional.isEmpty()) {
				throw new IllegalArgumentException("The argument "
						+ "for the option is missing, option (" + option + ")");
			}

			// Check for multiple arguments for a single option
			ArrayList<Object> temp = (ArrayList<Object>) optional.get();
			if(temp.size() > 1) {
				throw new IllegalArgumentException("Too many arguments "
						+ "for the option:" + option);
			}
			
			// true or false ?
			String arg = temp.get(0).toString();
			if(arg.equals("true")) {
				value = true;
			}
			else if(arg.equals("false")) {
				value = false;
			}
			
			// The argument can only be true or false
			else {
				throw new IllegalArgumentException("wrong argument: "
						+ arg + " for the option: " + option);
			}
			LogEnabler.instance
					.enabled
					.put(LogOptionsUtils
							.getCodeFrom(option), value);
		}
	}
	
}
