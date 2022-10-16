package juno.exception;

/*
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class FileNotFoundException extends Exception {
	
	/* */
	private static final long serialVersionUID = 1L;

	/* The paths */
	private String[] paths;
	
	/**
	 * 
	 * @param paths
	 */
	public FileNotFoundException(String... paths) {
		this.paths = paths;
	}
	
	public String[] getPaths() {
		return this.paths;
	}

}