package main.log.file;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogWriterActivationManager {
	
	//
	private boolean status;
		
	//
	private static LogWriterActivationManager instance;
	
	
	//
	private LogWriterActivationManager() {
		init();
	}
	
	
	/**
	 * 
	 * @return The instance
	 */
	public static LogWriterActivationManager getInstance() {
		if(instance == null) {
			instance = new LogWriterActivationManager();
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
