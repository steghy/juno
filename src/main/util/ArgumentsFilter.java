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
			.filter(k -> list.contains(k))
			.forEach(k -> output.put(k, source.get(k)));

		return output;
	}
	
	
	/**
	 * 
	 * @param map
	 * @param source
	 * @return A Map
	 */
	public static Map<String, Optional<Object>> filter(Map<String, Integer> map,
			Map<String, Optional<Object>> source) {

		Map<String, Optional<Object>> output = new HashMap<>();
		source.keySet()
			.stream()
			.filter(k -> map.containsKey(k))
			.forEach(k -> output.put(k, source.get(k)));
		return output;
	}
}
