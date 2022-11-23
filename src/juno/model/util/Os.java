/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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