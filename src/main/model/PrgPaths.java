package main.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import main.util.PathGenerator;

/**
 * This class defines the paths of all
 * the necessary data for the program.
 * @author steghy
 *
 */
public class PrgPaths {
	
	// directory name -> full PATH
	Map<String, String> paths;
	
	// one instance only
	private static PrgPaths instance;
	
	/**
	 * Singleton pattern
	 */
	private PrgPaths() {
		init();
	}

	
	/**
	 * Returns the instance
	 * @return The instance
	 */
	public static PrgPaths getInstance() {
		if(instance == null) {
			instance = new PrgPaths();
		} return instance;
	}

	
	/**
	 * It generates the data map which contains
	 * the association between "directory name",
	 * "PATH".
	 */
	private void init() {
		this.paths = new HashMap<>();
		Arrays.asList(DirNames.values())
		.forEach(dn->this.paths
				.put(dn.getName(), 
						PathGenerator.generate(dn.getName())));
	}

	
	/**
	 * Returns the path
	 * @return The path
	 */
	public Map<String, String> getPaths(){
		return this.paths;
	}
	
	

}
