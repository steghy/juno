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

package juno.controller.new_game.penalty;

import juno.model.deck.InterfaceDiscardedPile;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.InterfaceRemover;
import juno.model.subjects.ai.AI;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class UnoCardController
        implements Observer {

    // The current player provider.
    @Nullable
    private InterfaceProvider<InterfacePlayer<?>> provider;

    // The penalty executor.
    @Nullable
    private InterfacePenaltyExecutor<InterfacePlayer<?>> penaltyExecutor;

    // The UnoCardController instance.
    private static UnoCardController instance;

    // Builds the UnoCardController instance.
    private UnoCardController() {}

    /**
     * Returns the UnoCardController instance.
     * @return The UnoCardController instance.
     */
    public static UnoCardController UnoCardController() {
        if(instance == null) instance = new UnoCardController();
        return instance;
    }

    /**
     * Sets the current player provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<InterfacePlayer<?>> provider) {
        this.provider = provider;
    }

    /**
     * Sets the penalty executor of this objet.
     * @param penaltyExecutor An InterfacePenaltyExecutor object.
     */
    public void setPenaltyExecutor(@NotNull InterfacePenaltyExecutor<InterfacePlayer<?>> penaltyExecutor) {
        this.penaltyExecutor = penaltyExecutor;
    }

    @Override
    public void update(Object object) {
        // Viene notificato dai player ai.
        if(object instanceof InterfacePlayer<?> player) {
            if (player.cards().size() == 1) {
                if (player instanceof InterfaceAi<?, ?> ai) {
                    if (!ai.uno()) {
                        Objects.requireNonNull(penaltyExecutor).execute(player);
                    }
                } else {
                    // è human player.
                }
            }
        }
    }

}