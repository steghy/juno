package main.init;

import java.util.Map;
import java.util.stream.Collectors;

import main.log.Log;
import main.log.LogMessage;
import main.util.Os;


/**
 * This class defines the method to inizialize the program.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Init {

	
	/* No instances */
	private Init() {}
	
	
	/** Initialize the program */
	public static void init() {
		Log.print(LogMessage.ISUPP_DATA, getRequiredDirectoryCheck());
	}

	
	/* Checks the required directory and return the esit */
	private static Map<String, ErrorCode> getRequiredDirectoryCheck(){

		Map<String, String> paths = PrgPaths.getPaths();

		return paths.entrySet().stream().collect(Collectors.toMap(
				k -> k.getValue(),
				k -> {
					if(Os.isDir(k.getValue())) {
						return ErrorCode.ERROR_0;
					}
					else {
						return ErrorCode.ERROR_2;
					}
				}));
	}
}