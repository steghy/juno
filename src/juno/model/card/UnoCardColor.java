package juno.model.card;

/**
 * This class defines Color object.
 * The Color object are:
 * BLUE, GREEN, RED and YELLOW.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum UnoCardColor implements AbstractUnoCardColor {

	/** The blue color */
	BLUE,

	/** The green color */
	GREEN,

	/** The red color */
	RED,

	/** The yellow color */
	YELLOW;


	@Override
	public boolean isBlue() {
		return this.name().equals("BLUE");
	}


	@Override
	public boolean isRed(){
		return this.name().equals("RED");
	}


	@Override
	public boolean isYellow(){
		return this.name().equals("YELLOW");
	}


	@Override
	public boolean isGreen(){
		return this.name().equals("GREEN");
	}

	/**
	 * Returns the Color object associated with
	 * the specified color name
	 * @param colorName The name of the color
	 * @return The associated Color object
	 */
	public static UnoCardColor getColorObject(String colorName) {
		return switch (colorName.toUpperCase()) {
			case ("BLUE") -> UnoCardColor.BLUE;
			case ("GREEN") -> UnoCardColor.GREEN;
			case ("RED") -> UnoCardColor.RED;
			case ("YELLOW") -> UnoCardColor.YELLOW;
			default -> null;
		};
	}
}