package main.init;

import java.util.ArrayList;
import java.util.List;
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
		List<String> fatals = new ArrayList<>();
		List<String> notFatals = new ArrayList<>();
		
		getRequiredDirectoryCheck()
			.entrySet()
			.stream()
			.forEach(k -> {

						// FATAL
						if(k.getValue().isFatal()) {
							fatals.add(k.getKey());
						}
						
						// NOT FATAL
						else if(k.getValue().getErrorCode() > 0) {
							notFatals.add(k.getKey());
						}
					});

		if(fatals.size() > 0) {
			fatals.stream().forEach(System.out::println);
			throw new RequiredDirNotFound("");
		}
		
		if(notFatals.size() > 0) {
			notFatals.stream().forEach(System.out::println);
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
								if(k.getKey().getPriority() == 1){
									return ErrorCode.ERROR_128;
								}
								else {
									return ErrorCode.ERROR_2;
								}
							}}));
	}
}