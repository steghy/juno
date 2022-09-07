package main.model;
/**
 * Classe enumerativa per i valori fissi delle carte
 * da gioco "Uno".
 * @author steghy
 *
 */
public enum Card {
	
	//carte di 'uno'.
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
	SIX(6) , SEVEN(7), EIGHT(8), NINE(9), PLUS(10), 
	STOP(11), CHANGE(12), JOLLY_PLUS(13), JOLLY_CHANGE(14);
	
	//valore carte
	private int value;
	
	//costruttore
	private Card(int value) {
		this.value = value;
	}
	
	//ritorna il valore della carta
	public int getValue() {
		return this.value;
	}
}
