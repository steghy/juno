package juno.model.card;

public interface AbstractUnoCard {

    AbstractUnoCardAction action();

    AbstractUnoCardColor<AbstractUnoColor> color();

    AbstractUnoCardValue value();

}