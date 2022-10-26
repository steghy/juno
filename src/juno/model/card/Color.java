package juno.model.card;

/**
 * This class defines Color object.
 * The Color object are:
 * BLUE, GREEN, RED and YELLOW.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum Color {

	/** The blue color */
	BLUE,

	/** The green color */
	GREEN,

	/** The red color */
	RED,

	/** The yellow color */
	YELLOW; 
	
	/**
	 * Returns the Color object associated with
	 * the specified color name
	 * @param colorName The name of the color
	 * @return The associated Color object
	 */
	public static Color getColorObject(String colorName) {
		return switch (colorName.toUpperCase()) {
			case ("BLUE") -> Color.BLUE;
			case ("GREEN") -> Color.GREEN;
			case ("RED") -> Color.RED;
			case ("YELLOW") -> Color.YELLOW;
			default -> null;
		};
	}
}
