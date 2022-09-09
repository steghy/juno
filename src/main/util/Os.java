package main.util;

/**
 * 
 * @author steghy
 *
 */
public class Os {
	
	/**
	 * 
	 * @return
	 */
	public static String getName() {
		return System.getProperty("os.name");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static String getVersion() {
		return System.getProperty("os.version");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static String getArch() {
		return System.getProperty("os.arch");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean isWindows() {
		return getName().startsWith("Linux");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean isUnix() {
		return getName().startsWith("Linux") ||
				getName().startsWith("Mac Os X");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}
}
