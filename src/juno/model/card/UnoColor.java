package juno.model.card;

/**
 * This class defines Color object.
 * The Color object are:
 * BLUE, GREEN, RED and YELLOW.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum UnoColor implements AbstractUnoColor {

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
	public static UnoColor getColorObject(String colorName) {
		return switch (colorName.toUpperCase()) {
			case ("BLUE") -> UnoColor.BLUE;
			case ("GREEN") -> UnoColor.GREEN;
			case ("RED") -> UnoColor.RED;
			case ("YELLOW") -> UnoColor.YELLOW;
			default -> null;
		};
	}
}