package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import juno.model.card.Action;
import juno.model.card.Color;
import juno.model.card.UnoCard;

/**
 * This class defines the method
 * to generate the Uno cards deck.
 */
public class UnoDeckGenerator {

    /**
     * Generates the Uno deck
     * @param deck A Generable deck
     */
    public static void generate(Generable<AbstractUnoCard> deck, AbstractFactoryUnoCard factory) {

        for(Color color : Color.values()) {

            // NUMERIC CARDS
            for (int j = 1; j < 10; j++) deck.insert(new UnoCard(j, color, null));
            for (int j = 1; j < 10; j++) deck.insert(new UnoCard(j, color, null));


            for (Action action : Action.values()) {
                if(!action.isWildAction() && !action.isWildDrawFourAction()) {
                    deck.insert(new UnoCard(-1, color, action));
                    deck.insert(new UnoCard(-1, color, action));
                }
            }

            // JOLLY CARDS
            deck.insert(new UnoCard(-1, null, Action.WILD));
            deck.insert(new UnoCard(-1, null, Action.WILD_DRAW_FOUR));

            // ZERO CARDS
            deck.insert(new UnoCard(0, color, null));
        }
    }

}
