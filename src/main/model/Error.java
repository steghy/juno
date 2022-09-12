package main.model;

/**
 * This class defines errors in the programs.
 * An error is defined by:
 * 		- Name
 * 		- Type
 * 		- Code
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Error {
	
	/* The error name */
	private String name;

	/* The error type */
	private String type;

	/* The error code */
	private int code;

	
	/**
	 * Builds an error
	 * @param name The name
	 * @param type The type
	 * @param code The code
	 */
	public Error(String name, String type,
			int code) {
		this.name = name;
		this.type = type;
		this.code = code;
	}
	
	
	/**
	 * Builds an empty Error
	 */
	public Error() {
		
	}

	
	/**
	 * Sets the error name
	 * @param name The error name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Sets the error type
	 * @param type The error type
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	/**
	 * Sets the error code
	 * @param code The error code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	
	/**
	 * Returns the name
	 * @return The name
	 */
	public String getName() {
		return this.name;
	}

	
	/**
	 * returns the type
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	
	/**
	 * Returns the code
	 * @return The code
	 */
	public int getCode() {
		return this.code;
	}
}
