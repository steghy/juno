package juno.model.game;

public interface AbstractUnoTurnController {


    void reverseTurn();

    void skipTurn();

    AbstractPlayer getNextPlayer();

    AbstractPlayer getPreviousPlayer();

    AbstractPlayer getActualPlayer();

}
