package juno.model.util;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArgumentsFilter {
	
	public static Map<String, Optional<Object>> filter(@NotNull Collection<String> from,
													   @NotNull Map<String, Optional<Object>> source) {
		return source.keySet()
					.stream()
					.filter(from::contains)
					.collect(Collectors.toMap(
							k -> k,
							source::get));
	}
	
	public static <T> Map<String, Optional<Object>> filter(@NotNull Map<String, T> from,
														   @NotNull Map<String, Optional<Object>> source) {
		return source.keySet()
					.stream()
					.filter(from::containsKey)
					.collect(Collectors.toMap(
							k -> k,
							source::get));
	}
}