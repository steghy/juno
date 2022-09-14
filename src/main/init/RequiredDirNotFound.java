package main.init;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class RequiredDirNotFound extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Builds a RequiredDirNotFound exception
	 */
	public RequiredDirNotFound() {}
	
	
	/**
	 * Builds a RequiredDirNotFound exception
	 * @param message The message
	 */
	public RequiredDirNotFound(String message) {
		super(message);
	}

}
