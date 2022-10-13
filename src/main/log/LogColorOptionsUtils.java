package main.log;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author steghy
 * @email steghy.github@proton.me
 */
public class LogColorOptionsUtils {

	/**
	 * Returns the code associated with the specified option
	 * or null, if the specified option does not exist.
	 * @param option The option
	 * @return The code
	 */
	public static int getCodeFrom(String option) {
		Integer temp = null;
		for(LogColorOptions obj : LogColorOptions.values()) {
			if(obj.getExtendedOption().equals(option) ||
					obj.getContractedOption().equals(option)) {
				temp = obj.getCode();
				break;
			}
		}
		return temp;
	}


	/**
	 * Returns the options
	 * @return The options
	 */
	public static Collection<String> getOptions() {
		List<String> temp = Arrays.asList(LogColorOptions.values())
						.stream()
						.map(o -> o.getExtendedOption())
						.collect(Collectors.toList());

					 temp.addAll(Arrays.asList(LogColorOptions.values())
						.stream()
						.map(o -> o.getContractedOption())
						.collect(Collectors.toList()));
		return temp;
	}
}
