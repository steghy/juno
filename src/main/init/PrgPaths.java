package main.init;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import main.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PrgPaths {
	
	/* No instances */
	private PrgPaths() {}


	/**
	 * Returns the paths
	 * @return The paths
	 */
	public static Map<DirNames, String> getPaths(){
		return Arrays.asList(DirNames.values())
				.stream()
				.collect(Collectors
						.toMap( k -> k, 
								k -> PathGenerator.generate(k.getName())));
	}
}