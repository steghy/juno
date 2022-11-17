package juno.model.util;

public class PathGenerator {

	private PathGenerator() {}

	public static String generate(String parent, String fileName) {
		return parent.concat(System.getProperty("file.separator")).concat(fileName);
	}

	public static String generate(String fileName) {
		return System.getProperty("user.dir").concat(System.getProperty("file.separator").concat(fileName));
	}
}