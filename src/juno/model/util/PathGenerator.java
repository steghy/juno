package juno.model.util;

import org.jetbrains.annotations.NotNull;

public class PathGenerator {

	private PathGenerator() {}

	public static String generate(@NotNull String parent,
								  @NotNull String fileName) {
		return parent.concat(System.getProperty("file.separator")).concat(fileName);
	}

	public static String generate(@NotNull String fileName) {
		return System.getProperty("user.dir")
				.concat(System.getProperty("file.separator")
						.concat(fileName));
	}
}