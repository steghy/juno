package juno.model.card;

/**
 * This class defines Color object
 * for the Uno cards.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum Color {

	BLUE,
	GREEN,
	RED,
	YELLOW; 
	
	/**
	 * Returns the Color object from the specified 
	 * color name
	 * @param colorName The color name
	 * @return The appropriate Color object
	 */
	public static Color getColorObject(String colorName) {
		switch(colorName.toUpperCase()) {
		case("BLUE")  : return Color.BLUE;
		case("GREEN") : return Color.GREEN;
		case("RED")   : return Color.RED;
		case("YELLOW"): return Color.YELLOW;
		} return null;
	}
}
