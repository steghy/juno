package juno.main.init;

import static java.lang.System.getProperty;
import static java.lang.System.out;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Property class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Property {

	/* System properties */
	static String FileSeparator = getProperty("file.separator");
	static String JClassPath =    getProperty("java.class.path");
	static String JClassVersion = getProperty("java.class.version");
	static String JCompiler =     getProperty("java.compiler");
	static String JSpecVersion =  getProperty("java.specification.version");
	static String JVMVersion =    getProperty("java.vm.version");
	static String JVendor =       getProperty("java.vendor");
	static String JVendorURL =    getProperty("java.vendor.url");
	static String JVersion =      getProperty("java.version");
	static String OSArch =        getProperty("os.arch");
	static String OSName =        getProperty("os.name");
	
	public static void main(String[] args) {

	 

		// First argument needs to be 'debug=true' or 'debug=false'
		// Second argument needs to be 'file=true' or 'file=false'
		// Third argument needs to be 'dest=destination_path'

		//Check arguments validity
		String[] debug =  args[0].split("=");
		String[] file = args[1].split("=");
		String[] path = args[2].split("=");
		if(debug.length != 2 || file.length != 2 || path.length != 2) {
			out.println("An error occurred while processing the "
					  + "arguments provided in input");
			System.exit(1);
		}

		String debugValue = debug[1].toLowerCase();
		String fileValue = file[1].toLowerCase();
		String pathValue = path[1];
		if(!debugValue.equals("true") && !debugValue.equals("false")
		 ||!fileValue.equals("true")  && !fileValue.equals("false")
		 ||!(new File(pathValue)).getParentFile().exists() &&
			(new File(pathValue).exists())){
			out.println("An error occurred while processing the "
					  + "arguments provided in input");
			System.exit(2);
		 }

		if(Boolean.parseBoolean(debugValue)) {
			out.println(FileSeparator);
			out.println(JClassPath);
			out.println(JClassVersion);
			out.println(JCompiler);
			out.println(JSpecVersion);
			out.println(JVMVersion);
			out.println(JVendor);
			out.println(JVendorURL);
			out.println(JVersion);
			out.println(OSArch);
			out.println(OSName);
		}

		if(Boolean.parseBoolean(fileValue)) {
			PrintWriter writer;
			try {
				writer = new PrintWriter(pathValue);
				writer.println("FileSeparator=" + FileSeparator);
				writer.println("JClassPath =" + JClassPath);
				writer.println("JClassVersion=" + JClassVersion);
				writer.println("JCompiler=" + JCompiler);
				writer.println("JSpecVersion=" + JSpecVersion);
				writer.println("JVMVersion=" + JVMVersion);
				writer.println("JVendor=" + JVendor);
				writer.println("JVendorURL=" + JVendorURL);
				writer.println("JVersion=" + JVersion);
				writer.println("OSArch=" + OSArch);
				writer.println("OSName=" + OSName);
				writer.flush();
				writer.close();
			} catch (FileNotFoundException e) {
				out.println("The file doesn't exist");
			} catch (Exception e) {
				out.println("An error occurred during the file creation");
			}
		}
	}
}
