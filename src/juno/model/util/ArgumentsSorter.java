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