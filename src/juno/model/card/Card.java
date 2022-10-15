package juno.model.card;

public class Card {
	
	private int value;
	private Color color;
	private Action action;
	
	public Card(int value, Color color, Action action) {
		this.value = value;
		this.color = color;
		this.action = action;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Action getAction() {
		return this.action;
	}
	
	public String toString() {
		return "Card[" + this.value + ", " 
				+ (this.color == null ? "NO_COLOR" : this.color.name()) 
				+ ", " 
				+ (this.action == null ? "NO_ACTION" : this.action.name()) + "]";
	}
}