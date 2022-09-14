package main.init;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PrgPaths {
	
	/* Priority list. This list contains all the
	 * necessary program folders */
	static private List<String> priority = Arrays
			.asList(DirNames.VIDEOS.getName(),       // Videos folder
			        DirNames.THEMES.getName(),		 // Themes folder
  	   	  		    DirNames.SOUNDTRACKS.getName()); // Soundtracks folder

	/* No instances */
	private PrgPaths() {}


	/**
	 * Returns the paths
	 * @return The paths
	 */
	public static Map<String, Object[]> getPaths(){
		return Arrays.asList(DirNames.values())
			.stream()
			.collect(Collectors
			.toMap(k -> k.getName(), 
				   k -> {
						Object[] array = new Object[2];
						array[0] = PathGenerator.generate(k.getName());
						array[1] = (priority.contains(k.getName()) ? Integer.valueOf(1) : Integer.valueOf(0));
						return array;}
					));
	}
}