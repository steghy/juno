package juno.model.deck;

import juno.model.card.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

 class CardFactory implements AbstractCardFactory<AbstractUnoCard> {

    private static CardFactory instance;

    private CardFactory() {}

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
            Arrays.asList(UnoCardValue.values()).forEach(value ->
                    cards.add(new UnoCard(null, new UnoCardColor<>(color), value)));

            Arrays.asList(UnoCardAction.values()).forEach(action -> {
                if(action != null) {
                    if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                        cards.add(new UnoCard(action, new UnoCardColor<>(color), null));
                    }
                }
            });
        });

        // JOLLY CARDS
        cards.add(new UnoCard(UnoCardAction.WILD, null, null));
        cards.add(new UnoCard(UnoCardAction.WILD_DRAW_FOUR, null, null));
        return cards;
    }

}
