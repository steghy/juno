package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public interface AbstractUnoCardController {

    boolean areCompatible(AbstractUnoCard card, AbstractUnoCard otherCard);
}
