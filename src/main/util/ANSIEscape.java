package main.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steghy
 *
 */
public class ANSIEscape {
	
	/** ANSI color escape sequences */
	public static final String TX_BLACK  = "\u001B[30m";
	public static final String TX_RED    = "\u001B[31m";
	public static final String TX_GREEN  = "\u001B[32m";
	public static final String TX_YELLOW = "\u001B[33m";
	public static final String TX_BLUE   = "\u001B[34m";
	public static final String TX_PURPLE = "\u001B[35m";
	public static final String TX_CYAN   = "\u001B[36m";
	public static final String TX_WHITE  = "\u001B[37m";
	public static final String BG_BLACK  = "\u001B[40m";
	public static final String BG_RED    = "\u001B[41m";
	public static final String BG_GREEN  = "\u001B[42m";
	public static final String BG_YELLOW = "\u001B[43m";
	public static final String BG_BLUE   = "\u001B[44m";
	public static final String BG_PURPLE = "\u001B[45m";
	public static final String BG_CYAN   = "\u001B[46m";
	public static final String BG_WHITE  = "\u001B[47m";
	public static final String RESET     = "\u001B[0m";
	
	/** lista delle sequenze-colori */
	public static List<String> ANSI_ESCAPE_COLORS = init();
	
	/** la sequenza */
	private String sequence;
	
	/** 
	 * costruisce una sequenza ansi 
	 *@param sequence Una stringa 
	 */
	private ANSIEscape(String sequence) {
		this.sequence = sequence;
	}
	
	/**
	 * Ritorna la sequenza di escape ANSI
	 * @return Una stringa
	 */
	public String getValue() {
		return this.sequence;
	}
	
	/**
	 * Inizializza la lista delle sequenze ansi-colori
	 * @return Un ArrayList<String>
	 */
	private static List<String> init(){
			
		List<String> temp = new ArrayList<>();
		
		temp.add(TX_BLACK); temp.add(TX_RED);
		temp.add(TX_GREEN); temp.add(TX_YELLOW);
		temp.add(TX_BLUE);  temp.add(TX_PURPLE);
		temp.add(TX_CYAN);  temp.add(TX_WHITE);
		temp.add(BG_BLACK); temp.add(BG_RED);
		temp.add(BG_GREEN); temp.add(BG_YELLOW);
		temp.add(BG_BLUE);  temp.add(BG_PURPLE);
		temp.add(BG_CYAN);  temp.add(BG_WHITE);
		temp.add(RESET);
		
		return temp;
	}
}
