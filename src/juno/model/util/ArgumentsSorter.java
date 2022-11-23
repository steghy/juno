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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ArgumentsSorter {
	
	public static final String EXTENDED_OPT = "--";
	public static final String CONTRACTED_OPT = "-";

	private ArgumentsSorter() {}

	public static Map<String, Optional<Object>> getArguments(@NotNull String[] args) {
		Map<String, Optional<Object>> optionArguments = new HashMap<>();
		for(int i = 0; i < args.length; i++) {
			String temp = args[i];
			if(temp.startsWith(EXTENDED_OPT) ||
					temp.startsWith(CONTRACTED_OPT)) {
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
				} if(arguments.size() != 0) {
					optionArguments.put(temp, Optional.of(arguments));
				} else {
					optionArguments.put(temp, Optional.empty());
				}
			}
		} return optionArguments;
	}
}