package juno.exception;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NotADirectoryException extends Exception {
	
	/* Serail Version UID */
	private static final long serialVersionUID = 1L;

	String[] paths;
	
	/* */
	private NotADirectoryException() {}
	
	/**
	 * 
	 * @param paths
	 */
	public NotADirectoryException(String... paths) {
		this.paths = paths;
	}
	
	
	/**
	 * Returns the paths
	 * @return The paths
	 */
	public String[] getPaths() {
		return this.paths;
	}
}
