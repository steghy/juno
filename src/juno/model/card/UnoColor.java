package juno.model.card;

public enum UnoColor implements AbstractUnoColor {

	BLUE,
	GREEN,
	RED,
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