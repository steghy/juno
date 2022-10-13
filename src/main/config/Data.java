package main.config;

import java.util.Map;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Data{
	
	/* Data name */
	private String name;
	
	/* Data */
	private Map<String, Object> data;
	
	
	/**
	 * Builds a Data with the specified nane
	 * @param name The data name
	 */
	public Data(String name) {
		this.name = name;
	}

	
	/**
	 * Builds a Data with the specified data and name 
	 * @param data The data
	 * @param name The name
	 */
	public Data(Map<String, Object> data, String name) {
		this.data = data;
		this.name = name;
	}
	
	
	/**
	 * Sets the data
	 * @param data The data
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	/**
	 * Sets the data name
	 * @param name The data name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * Returna the data 
	 * @return The data
	 */
	public Map<String, Object> getData(){
		return this.data;
	}
	
	
	/**
	 * Returns the data name
	 * @return The data name
	 */
	public String getName() {
		return this.name;
	}

}
