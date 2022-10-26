package juno.model.util;

/**
 * This class defines the utility method
 * 'generate(String, String)', that returns
 * a path.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PathGenerator {

	private PathGenerator() {}

	/**
	 * Returns the path generated with the specified
	 * parent path and the specified file name
	 * @param parent The parent path
	 * @param name The file name
	 * @return A String object represents the generated path
	 */
	public static String generate(String parent, String name) {
		return parent.concat(System.getProperty("file.separator")).concat(name);
	}
}