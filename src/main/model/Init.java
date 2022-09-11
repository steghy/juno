package main.model;

import java.util.HashMap;
import java.util.Map;

import main.util.Os;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Init {

	private static Map<String, String> paths = PrgPaths
											.getInstance()
											.getPaths();
	
	private Init() {}

	/**
	 * 
	 */
	public static void init() {
		Map<String, Error> dir = requiredDirChecks();
		dir.keySet()
		.forEach(k ->
				System.out.println(
						k + "\n{\n" + "name:" + dir.get(k).getName() + "\n" +
							          "type:" + dir.get(k).getType() + "\n" + 
								      "code:" + dir.get(k).getCode() + "\n" + 
							"}\n"));
	}
	
	// checks the dirs
	private static Map<String, Error> requiredDirChecks(){
		Map<String, Error> esit =
				new HashMap<>();
		paths.keySet().forEach(k -> {
			System.out.println(paths.get(k));
			if(Os.isDir(paths.get(k))) {
				esit.put(paths.get(k),
						new Error("Directory found",
								"ReqDir",
								0));
			}
			else {
				esit
				.put(paths.get(k), 
						new Error("Directory not found",
								"ReqDir",
								100));
			}
		});
		return esit;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		init();
	}
}
