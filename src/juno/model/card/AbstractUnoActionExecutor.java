package juno.model.card;

import juno.model.deck.AbstractUnoDeck;
import juno.model.game.AbstractUnoTurnController;
import juno.model.game.AbstractUnoGameData;

public interface AbstractUnoActionExecutor {

    void execute(AbstractUnoCardAction action,
                 AbstractUnoDeck<AbstractUnoCard> deck,
                 AbstractUnoGameData gameData,
                 AbstractUnoTurnController turnController);
}
