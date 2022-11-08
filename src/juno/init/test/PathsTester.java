package juno.init.test;

import java.io.File;
import java.util.Arrays;
import static java.lang.System.out;
import juno.init.Directories;

public class PathsTester {

	public static void main(String[] args) {
		Arrays.asList(Directories.values()).stream()
			.forEach(pathObject -> {
				File file = new File(pathObject.path());
				out.println((file.exists() ? 
						file.getAbsolutePath() + " | EXISTS" : 
						file.getAbsolutePath() + " | NOT EXISTS"));
			});
	}

}
