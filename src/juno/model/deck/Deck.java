package juno.model.deck;

import java.util.Random;
import java.util.Stack;
import juno.exception.DeckIsEmptyException;
import juno.exception.DeckIsNotEmptyException;
import juno.exception.IncompatibleCardException;
import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;

/**
 * Questa classe definisce l'oggetto Deck
 * utilizzato durante una partita al gioco Uno.
 * Un oggetto Deck è complesso e comprende, tra
 * i suoi campi, il mazzo pescate e il mazzo delle carte
 * scartate. L'oggetto Deck tiene inoltre contro delle
 * carte attualmente in mano (in totale) di tutti i giocatori.
 * Ci sono metodi per:
 * - Creare il mazzo.
 * - Mischiare il mazzo.
 * - Pescare una carta dal mazzo.
 * - Reciclare le carte scartate.
 * - Inserimento di una carta nella pila delle carte scartate.
 * - Vari metodi di get
 * Nota: La generazione del mazzo, che permette l'invocazione di
 * tutti i restanti metodi dell'istanza, dev'essere effettuata
 * separatamente rispetto al metodo di getInstance().
 * Quindi per invocare un qualsiasi metodo è necessario prima
 * invocare il metodo generateDeck(int playerNumber).
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Deck {
	
	/* The instance */
	private static Deck instance;
	
	/* Deck */
	private Stack<Card> deck;
	
	/* Discarded cards */
	private Stack<Card> discarded;
	
	/* Il numero totale di carte in mano */
	private int cardsInHand;
	
	/* Singleton Pattern */
	private Deck() {}
	
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static Deck getInstance() {
		if(instance == null) {
			instance = new Deck();
		} return instance;
	}
	
	
	/**
	 * Restituisce la carta in cima al mazzo pescate
	 * @return La carta pescata
	 * @throws DeckIsEmptyException Se il mezzo non ha più
	 * 		   carte a disposizione.
	 * @throws DeckNotInitializedException Se il deck
	 * 		   non è stato preventivamente inizializzato
	 */
	public Card draw() throws DeckIsEmptyException {
		if(this.deck.isEmpty()) {
			throw new DeckIsEmptyException();
		}
		Card card = this.deck.pop();
		this.cardsInHand++;
		return card;
	}
	
	
	/**
	 * Inserisce la carta passata in input
	 * nella pila degli scarti
	 * @param card La carta da inserire nella pila
	 * 		  degli scarti
	 * @throws DeckNotInitializedException Se il deck
	 *         non è stato preventivamente inizializzato
	 * @throws IncompatibleCardException  Se la carta
	 * 		   specificata in input non è compatibile con
	 *         la carta in cima alla pila delle carte scartate.
	 */
	public void putCard(Card card) throws IncompatibleCardException {
		if(this.discarded.peek().isCompatible(card)) {
			this.cardsInHand--;
			this.discarded.push(card);
		} else {
			throw new IncompatibleCardException("THe specified Card object"
					+ "cannot be puts into the discarded cards");
		}
	}
	
	
	/**
	 * Aggiunge tutte le carte nella pila degli scarti 
	 * nel mazzo delle carte da pescare.
	 * Il mezzo delle carte non viene mescolato durante
	 * l'esecuzione di questo metodo
	 * @return Ritorna l'oggetto invocante
	 * @throws DeckIsNotEmptyException Se il mazzo delle pescate non è 
	 * 	       vuoto.
	 */
	public Deck addDiscardedToDeck() throws DeckIsNotEmptyException {
		if(this.deck.isEmpty()) {
			this.deck.addAll(this.discarded);
			this.discarded.clear();
		} else {
			throw new DeckIsNotEmptyException("Deck is not empty,"
					+ "first consume this deck.");
		} return this;
	}

	
	/**
	 * Mescola il mazzo delle pescate.
	 */
	public Deck shuffle() {
		Random random = new Random();
		for(int i = 0; i < 250; i++) {

			Card card_1 = this.deck.pop();
			Card card_2 = this.deck.pop();
			Card card_3 = this.deck.pop();

			int index_1 = random.nextInt(this.deck.size());
			int index_2 = random.nextInt(this.deck.size());
			int index_3 = random.nextInt(this.deck.size());

			this.deck.add(index_1, card_1);
			this.deck.add(index_2, card_2);
			this.deck.add(index_3, card_3);
		} return this;
	}
	
	
	/**
	 * Ritorna il mazzo delle pescate
	 * @return Il mazzo delle pescate
	 */
	public Stack<Card> getDeck() {
		return this.deck;
	}
	
	
	/**
	 * Ritorna il mazzo delle carte scartate
	 * @return Il mazzo delle carte scartate
	 */
	public Stack<Card> getDiscarded() {
		return this.discarded;
	}
	
	
	/**
	 * Ritorna il numero totale di carte in mano in tutti i giocatori
	 * @return Il numero totale di carte in mano in tutti i giocatori
	 */
	public int getCardsInHand() {
		return this.cardsInHand;
	}

	
	/**
	 * Genera il mezzo delle pescate sulla base del 
	 * numero dei giocatori fornito in input.
	 * Se il numero dei giocatori è 3 o 4, il numero
	 * di carte totali è uguale a 108.
	 * Se il numero dei giocatori è uguale a 2, il 
	 * numero delle carte del mazzo pescate è uguale
	 * a 59
	 * @param playersNumber Il numero di giocatori
	 * @return L'oggetto invocante
	 */
	public Deck generateDeck(int playersNumber) {
		
		this.deck = new Stack<>();
		this.discarded = new Stack<>();

		if(playersNumber < 2 || playersNumber > 4) {
			throw new IllegalArgumentException("Invalid "
					+ "numeber of players");
		}

		int factor;
		if(playersNumber > 2) {
			factor = 2;
		} else {
			factor = 1;
		}
		
		for(int i = 0; i < factor; i++) {
			
			// Numberic cards
			for(int j = 1; j < 10; j++) {
				this.deck.add(new Card(j, Color.BLUE, null));
				this.deck.add(new Card(j, Color.GREEN, null));
				this.deck.add(new Card(j, Color.RED, null));
				this.deck.add(new Card(j, Color.YELLOW, null));
			}
			
			// Action cards
			for(Color color : Color.values()) {
				for(Action action : Action.values()) {
					if(!action.isJolly()) {
						this.deck.add(new Card(-1, color, action));
					}
				}
			}
		
			// Jolly cards
			for(Action action : Action.values()) {
				if(action.isJolly()) {
					this.deck.add(new Card(-1, null, action));
					this.deck.add(new Card(-1, null, action));
				}
			}
		}
			
		// Zeros
		for(Color color : Color.values()) {
			this.deck.add(new Card(0, color, null));
		}
		return this;	
	}
}