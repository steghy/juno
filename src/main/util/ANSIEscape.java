package main.util;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum ANSIEscape {
	
	/** Black text */
	TX_BLACK("\u001B[30m"),
	
	/** Red text */
	TX_RED("\u001B[31m"),
	
	/** Green text */
	TX_GREEN("\u001B[32m"),
	
	/** Yellow text */
	TX_YELLOW("\u001B[33m"),
	
	/** Blue text */
	TX_BLUE("\u001B[34m"),
	
	/** Purple text */
	TX_PURPLE("\u001B[35m"),
	
	/** Cyan text */
	TX_CYAN("\u001B[36m"),
	
	/** White text */
	TX_WHITE("\u001B[37m"),
	
	/** Black background */
	BG_BLACK("\u001B[40m"),
	
	/** Red background */
	BG_RED("\u001B[41m"),
	
	/** Green background */
	BG_GREEN("\u001B[42m"),
	
	/** Yellow Background */
	BG_YELLOW("\u001B[43m"),
	
	/** Blue Background */
	BG_BLUE("\u001B[44m"),
	
	/** Background purple */
	BG_PURPLE("\u001B[45m"),
	
	/** Cyan background */
	BG_CYAN("\u001B[46m"),
	
	/** White background */
	BG_WHITE("\u001B[47m"),
	
	/** Reset sequence */
	RESET("\u001B[0m");
	
	/* The sequence */
	private String sequence;
	
	/* Builds an ANSI escape sequence */
	private ANSIEscape(String sequence) {
		this.sequence = sequence;
	}
	
	
	/**
	 * Returns the ANSI escape sequence
	 * @return The ANSI escape sequence
	 */
	public String getSequence() {
		return this.sequence;
	}
}