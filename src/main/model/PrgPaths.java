package main.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import main.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class PrgPaths {
	
	//
	private Map<String, String> paths;
	
	//
	private static PrgPaths instance;

	
	//
	private PrgPaths() {
		init();
	}

	
	/**
	 * 
	 * @return The instance
	 */
	public static PrgPaths getInstance() {
		if(instance == null) {
			instance = new PrgPaths();
		} return instance;
	}

	/**
	 * 
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