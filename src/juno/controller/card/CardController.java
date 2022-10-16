package juno.controller.card;

import java.util.ArrayList;

import juno.model.card.Card;

/**
 * Il CardController si occupa di stabilire
 * quali sono le carte giocabili nella mano
 * del giocatore di turno sulla base
 * della carta in cima alla pila degli scarti
 * durante la partita in corso.
 * Il campo 'playable' di una carta server
 * proprio a determinare se la carta è giocabile
 * oppure no. L'impostazione della giocabilità di 
 * ogni singola carta nella mano del giocatore di 
 * turno viene effetuata prima ancora che l'utente
 * abbia la possibilità di scegliere una qualsiasi 
 * carta da giocare ma non prima che abbia pescato
 * la carta di turno. Le carte di un giocatore
 * sono presenti all'interno di un ArrayList<Card>.
 * Questa classe, fatte le premesse precedenti,
 * non permette di istanziarne oggetti ma dispone
 * di un unico metodo publico statico per la modifica
 * degli oggetti Card presenti all'interno dell'ArrayList<Card>
 * passato in input.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardController {
	
	/**
	 * Imposta la giocabilità delle carte contenute all'interno
	 * dell'ArrayList passato in input sulla base della carta
	 * specificata
	 * @param cards L'ArrayList contenete gli oggetti Card
	 * @param topCard La carta per determinare la gicabilità delle altre
	 */
	public static void setPlayableOf(ArrayList<Card> cards, Card topCard) {
		for(Card card : cards) {
			if(card.isCompatible(topCard)) {
				card.setPlayable(true);
			} else {
				card.setPlayable(false);
			}
		}
	}
}