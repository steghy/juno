package main.log;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogFileEnabler {
	
	/** Status */
	boolean status;
		
	//
	private static LogFileEnabler instance;
	
	
	//
	private LogFileEnabler() {
		init();
	}
	
	
	/**
	 * 
	 * @return The instance
	 */
	public static LogFileEnabler getInstance() {
		if(instance == null) {
			instance = new LogFileEnabler();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @return A boolean
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	
	/**
	 * Sets the status 
	 * @param value A boolean
	 */
	public void setStatus(boolean value) {
		this.status = value;
	}

	
	//
	private void init() {
		this.status = false;
	}
}
