package juno.model.deck;

import juno.model.card.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author steghy
 */
 class CardFactory implements AbstractCardFactory<AbstractUnoCard> {

    /* The FactoryUnoCard instance */
    private static CardFactory instance;

    /* Builds the FactoryUnoCard instance */
    private CardFactory() {}

    /**
     * Returns the FactoryUnoCard instance
     * @return The FactoryUnoCard instance
     */
    static CardFactory getInstance(){
        if(instance == null){
            instance = new CardFactory();
        } return instance;
    }

    @Override
    public Collection<AbstractUnoCard> getCards() {

        List<AbstractUnoCard> cards = new ArrayList<>();

        // COLORED CARDS
        Arrays.asList(UnoColor.values()).forEach(color -> {
            Arrays.asList(UnoCardValue.values()).forEach(value -> cards.add(new UnoCard(value, new UnoCardColor(color), null)));

            Arrays.asList(UnoCardAction.values()).forEach(action -> {
                if(action != null) {
                    if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                        cards.add(new UnoCard(null, new UnoCardColor(color), action));
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