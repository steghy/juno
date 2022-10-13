package main.log;

import java.io.IOException;
import java.util.Map;

import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;

/**
 * 
 * @author steghy
 * @email * @email steghy.github@proton.me
 */
public class LogFileEnabler implements Configurable, Exportable, Activable{
		
	/* The status */
	private boolean status;
	
	/* The instance */
	private static LogFileEnabler instance;
	
	
	/* Builds the LogFileEnabler instance */
	private LogFileEnabler() {
		init();
	}
	
	
	/**
	 * Returns the instance 
	 * @return The instance
	 */
	static LogFileEnabler getInstance() {
		if(instance == null) {
			instance = new LogFileEnabler();
		}
		return instance;
	}
	
	
	/**
	 * Returns the status
	 * @return The status
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	
	/**
	 * Sets the status 
	 * @param status The status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	/* Initialize the instance */
	private void init() {
		this.status = false;
	}


	@Override
	public Map<Integer, Boolean> getActive() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataPackage provideData() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void configure(DataPackage data) throws IOException {
		// TODO Auto-generated method stub
		
	}
}