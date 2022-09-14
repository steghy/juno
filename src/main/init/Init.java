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
	
	
	/** Initialize the program 
	 * @throws Exception */
	public static void init() throws Exception {
		if(getRequiredDirectoryCheck()
		.entrySet()
		.stream()
		.filter(e -> e.getValue().isFatal()).count() > 0) {
			throw new Exception();
		}
		Log.print(LogMessage.ISUPP_DATA, getRequiredDirectoryCheck());
	}

	
	/* Checks the required directory and return the esit */
	private static Map<String, ErrorCode> getRequiredDirectoryCheck(){
		return PrgPaths.getPaths()
				.entrySet()
				.stream()
				.collect(Collectors.toMap(
						k -> k.getValue(),  // The folder path
						k -> {
							if(Os.isDir(k.getValue())) {
								return ErrorCode.ERROR_0;
							}
							else {
								return ErrorCode.ERROR_2;
							}}));
	}
}