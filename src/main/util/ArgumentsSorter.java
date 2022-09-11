package main.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class ArgumentsSorter 
{
	
	/**
	 * 
	 */
	public static final String EXTENDED_OPT = "--";
	
	/**
	 * 
	 */
	public static final String CONTRACTED_OPT = "-";
	
	
	/**
	 * 
	 * @param args
	 * @return A Map
	 */
	public static Map<String, Optional<Object>> getArguments(String[] args) {
		Map<String, Optional<Object>> optionArguments = new HashMap<>();
		int length = args.length;
		for(int i = 0; i < length; i++) {
			String temp = args[i];
			if(temp.startsWith(EXTENDED_OPT) ||
					temp.startsWith(CONTRACTED_OPT)) {
				ArrayList<String> arguments = new ArrayList<>();
				
				for(int j = i+1; j < length; j++) {
					
					String arg = args[j];
					
					if(!(arg.startsWith(EXTENDED_OPT) ||
							arg.startsWith(CONTRACTED_OPT))) {
						arguments.add(arg);
					}
					else {
						break;
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
