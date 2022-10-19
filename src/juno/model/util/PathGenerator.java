package juno.model.util;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PathGenerator {

	static String currentPath = Os.getCurrentPath();
	static String div = System.getProperty("file.separator");
	
	private PathGenerator() {}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String generate(String[] names) {
		for(String name : names) {
			currentPath += div.concat(name);
		} return currentPath;
	}
	
	/**
	 * 
	 * @param parent
	 * @param names
	 * @return
	 */
	public static String generate(String parent, String[] names) {
		for(String name : names) {
			parent += div.concat(name);
		} return parent;
	}

	/**
	 * 
	 * @param parent
	 * @param names
	 * @return
	 */
	public static String generate(String parent, String name) {
		return parent.concat(div).concat(name);
	}
}