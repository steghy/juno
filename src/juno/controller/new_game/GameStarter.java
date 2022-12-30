/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.controller.new_game;

import juno.controller.new_game.dispenser.CardController;
import juno.controller.new_game.dispenser.CardDispenser;
import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.util.AbstractObservable;
import juno.model.util.Donut;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GameStarter
        extends AbstractObservable
        implements Observer {

    // The GameStarter instance.
    private static GameStarter instance;

    // Builds the GameStarter instance.
    private GameStarter() {}

    /**
     * Builds the GameStarter instance.
     * @return The GameStarter instance.
     */
    public static GameStarter getInstance() {
        if(instance == null) instance = new GameStarter();
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void start(@NotNull InterfacePlayer<InterfaceCard> player) {
        updateAll();
        Donut<InterfacePlayer<InterfaceCard>> players =
                (Donut<InterfacePlayer<InterfaceCard>>) PlayersProvider.getInstance().provide();
        Objects.requireNonNull(players).initialize(player);
        CardDispenser.getInstance().dispense();
    }

    @Override
    public void update(Object object) {
        if(object instanceof CardController cardController) {
            List<InterfacePlayer<InterfaceCard>> players = cardController.provide();
            if(players.size() == 1)
                start(players.get(0));
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceInitializer type expected.");
    }

}