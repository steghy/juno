package main.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class contains a static method for organizing the arguments 
 * entered at the command prompt.
 * @author Simone Gentili
 *
 */
public class ArgumentsSorter 
{
	
	public static final String EXTENDED_OPT = "--";
	public static final String CONTRACTED_OPT = "-";
	/**
	 * Arranges arguments within vectors so that in each vector there 
	 * is the option and its arguments. Vectors are added inside a vector 
	 * that is returned.
	 * @param args The array of arguments.
	 * @return	A vector (ArrayList) that contains vectors.
	 */
	public static Map<String, Optional<Object>> getArguments(String[] args) {
		
		Map<String, Optional<Object>> optionArguments = new HashMap<>();
		
		int length = args.length;
		
		for(int i = 0; i < length; i++) {
			String temp = args[i];
			if(temp.startsWith(EXTENDED_OPT) ||
					temp.startsWith(CONTRACTED_OPT)) {
				
				//options
				ArrayList<String> arguments = new ArrayList<>();
				
				for(int j = i+1; j < length; j++) {
					
					String arg = args[j];
					
					if(!(arg.startsWith(EXTENDED_OPT) ||
							arg.startsWith(CONTRACTED_OPT))) {
						

					//argumnet
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
