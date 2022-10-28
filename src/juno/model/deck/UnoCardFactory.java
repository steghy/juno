package juno.model.deck;

import juno.model.card.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author steghy
 */
public class UnoCardFactory implements AbstractCardFactory<AbstractUnoCard> {

    /* The FactoryUnoCard instance */
    private static UnoCardFactory instance;

    /* Builds the FactoryUnoCard instance */
    private UnoCardFactory() {}

    /**
     * Returns the FactoryUnoCard instance
     * @return The FactoryUnoCard instance
     */
    public static UnoCardFactory getInstance(){
        if(instance == null){
            instance = new UnoCardFactory();
        } return instance;
    }

    @Override
    public Collection<AbstractUnoCard> getCards() {
        List<AbstractUnoCard> cards = new ArrayList<>();

        // COLORED CARDS
        Arrays.asList(UnoCardColor.values()).forEach(color -> {
            Arrays.asList(UnoCardValue.values()).forEach(value -> cards.add(new UnoCard(value, color, null)));

            Arrays.asList(UnoCardAction.values()).forEach(action -> {
                if(action != null) {
                    if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                        cards.add(new UnoCard(null, color, action));
                    }
                }
            });
        });

        // JOLLY CARDS
        cards.add(new UnoCard(null, null, UnoCardAction.WILD));
        cards.add(new UnoCard(null, null, UnoCardAction.WILD_DRAW_FOUR));
        return cards;
    }

}
