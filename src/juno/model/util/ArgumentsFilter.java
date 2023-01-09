/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.model.util;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class defines an arguments filter.
 * @author Simone Gentili
 */
public class ArgumentsFilter {

	/**
	 * Filter the specified Collection.
	 * @param from A Collection object.
	 * @param source A Map object.
	 * @return A Map object.
	 */
	public static Map<String, Optional<Object>> filter(@NotNull Collection<String> from,
													   @NotNull Map<String, Optional<Object>> source) {
		return source.keySet()
					.stream()
					.filter(from::contains)
					.collect(Collectors.toMap(
							k -> k,
							source::get));
	}

	/**
	 * Returns a Map object.
	 * @param from A Map object.
	 * @param source A Map object.
	 * @return A Map object.
	 * @param <T> The type of the values.
	 */
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