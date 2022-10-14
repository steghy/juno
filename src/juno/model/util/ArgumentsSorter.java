package juno.model.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class ArgumentsSorter {
	
	/** Extended option char */
	public static final String EXTENDED_OPT = "--";
	
	/** Contracted option char */
	public static final String CONTRACTED_OPT = "-";
	
	
	/**
	 * 
	 * @param args
	 * @return A Map
	 */
	public static Map<String, Optional<Object>> getArguments(String[] args) {

		Map<String, Optional<Object>> optionArguments = new HashMap<>();

		for(int i = 0; i < args.length; i++) {

			String temp = args[i];
			
			// It's an option
			if(temp.startsWith(EXTENDED_OPT) ||
					temp.startsWith(CONTRACTED_OPT)) {

				// Arguments are stored here
				ArrayList<String> arguments = new ArrayList<>();
				
				for(int j = i+1; j < args.length; j++) {
					
					String arg = args[j];
					
					if(arg.startsWith(EXTENDED_OPT) ||
							arg.startsWith(CONTRACTED_OPT)) {
						break;
					}
					else {
						arguments.add(arg);
					}
				}
				
				if(arguments.size() != 0) {
					optionArguments.put(temp, Optional.of(arguments));
				}
				
				else {
					optionArguments.put(temp, Optional.empty());
				}
			}
		}
		return optionArguments;
	}
}