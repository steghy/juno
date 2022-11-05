package juno.model.card;

public interface AbstractUnoCardAction {

    boolean isWildAction();

    boolean isWildDrawFourAction();

    boolean isSkipAction();

    boolean isReverseAction();

    boolean isDrawTwoAction();
}
