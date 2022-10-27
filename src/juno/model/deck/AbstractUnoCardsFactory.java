package juno.model.deck;

import juno.model.card.AbstractUnoCard;

import java.util.List;

public interface AbstractUnoCardsFactory {

    List<AbstractUnoCard> getRedCards();

    List<AbstractUnoCard> getBlueCards();

    List<AbstractUnoCard> getGreenCards();

    List<AbstractUnoCard> getYellowCards();

    List<AbstractUnoCard> getJollyCards();
}
