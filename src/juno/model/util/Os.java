package juno.model.util;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Os {
	
	public static String getOSName() {
		return System.getProperty("os.name");
	}
	
	public static String getOSVersion() {
		return System.getProperty("os.version");
	}

	public static String getOSArchitecture() {
		return System.getProperty("os.arch");
	}
	
	public static boolean isWindows() {
		return getOSName().startsWith("Windows");
	}

	public static boolean isGnuLinux() {
		return getOSName().startsWith("Linux");
	}

	public static boolean isMacOs() {
		return getOSName().startsWith("Mac Os");
	}

	public static boolean parentExists(String path) {
		File file = new File(path);
		return file.getParentFile().exists();
	}

	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}
	
	public static boolean exists(@NotNull String path) {
			return new File(path).exists();
	}

	public static boolean exists(@NotNull File file) {
		return file.exists();
	}

	public static boolean isDirectory(@NotNull String path) {
		return new File(path).isDirectory();
	}

	public static boolean isDirectory(@NotNull File file) {
		return file.isDirectory();
	}

	public static boolean isFile(@NotNull String path) {
		return new File(path).isFile();
	}

	public static boolean isFile(@NotNull File file) {
		return file.isFile();
	}
}