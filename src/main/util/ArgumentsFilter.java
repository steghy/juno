package main.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class ArgumentsFilter {
	
	/**
	 * 
	 * @param list
	 * @param source
	 * @return A Map
	 */
	public static Map<String, Optional<Object>> filter(List<String> list, 
			Map<String, Optional<Object>> source) {
		Map<String, Optional<Object>> output = new HashMap<>();
		source.keySet()
			.stream()
			.filter(k->list.contains(k))
			.forEach(k->addOptional(k, source, output));
		
		return output;
	}

	
	//
	private static void addOptional(String k, Map<String, 
			Optional<Object>> source, Map<String, Optional<Object>> output) {
		output.put(k, source.get(k));
	}
}
