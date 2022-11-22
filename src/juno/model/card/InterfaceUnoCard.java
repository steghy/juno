package juno.model.card;

public interface InterfaceUnoCard {

    InterfaceUnoCardAction action();

    InterfaceUnoCardColor<InterfaceUnoColor> color();

    InterfaceUnoCardValue value();

}