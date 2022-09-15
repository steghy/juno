package main.log;

/**
 * This class defines the log file path
 * @author steghy
 * @email steghy.github@proton.me
 */
public class LogFilePath {
	
	/* The path */
	private String path;

	/* The file path */
	private String fileName;

	/* The instance */
	private static LogFilePath instance;
	
	
	/* Builds a LogFilePath instance */
	private LogFilePath() {}
	
	
	static LogFilePath getInstance() {
		if(instance == null) {
			instance = new LogFilePath();
		}
		return instance;
	}
	
	/**
	 * Sets the path
	 * @param path The path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Sets the file name
	 * @param fileName The file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	/**
	 * Returns the path
	 * @return The path
	 */
	public String getPath() {
		return this.path;
	}
	
	
	/**
	 * Returns the file name
	 * @return The file name
	 */
	public String getFileName() {
		return this.fileName;
	}
	
}
