package main.util;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ArgumentsFilter {
	
	/**
	 * 
	 * @param from A Collection
	 * @param source The source Map
	 * @return A Map 
	 */
	public static Map<String, Optional<Object>> filter(Collection<String> from, 
			Map<String, Optional<Object>> source) {

		return source.keySet()
					.stream()
					.filter(k -> from.contains(k))
					.collect(Collectors.toMap(
							k -> k, 
							k -> source.get(k)));
	}
	
	
	/**
	 * 
	 * @param <T> The values type 
	 * @param from A Map
	 * @param source The source Map
	 * @return A Map
	 */
	public static <T> Map<String, Optional<Object>> filter(Map<String, T> from,
			Map<String, Optional<Object>> source) {

		return source.keySet()
					.stream()
					.filter(k -> from.containsKey(k))
					.collect(Collectors.toMap(
							k -> k,
							k -> source.get(k)));
	}
}