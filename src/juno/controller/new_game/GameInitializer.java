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

import juno.controller.new_game.game_settings.GameData;
import juno.controller.util.InterfaceInitializer;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.factory.InterfaceAiGenerator;
import juno.model.util.AbstractObservable;
import juno.model.util.Generator;
import org.jetbrains.annotations.NotNull;

/**
 * This class defines an initializer.
 * @author Simone Gentili
 */
public class GameInitializer
        extends AbstractObservable
        implements InterfaceInitializer {

    // The ai players generator.
    private InterfaceAiGenerator<InterfaceDifficulty> aiGenerator;

    // The deck generator.
    private Generator deckGenerator;

    // The StartGameAction instance.
    private static GameInitializer instance;

    /**
     * Sets the ai player generator of this object.
     * @param aiGenerator An InterfaceAiPlayerGenerator object.
     */
    public void setAiGenerator(@NotNull InterfaceAiGenerator<InterfaceDifficulty> aiGenerator) {
        this.aiGenerator = aiGenerator;
    }

    /**
     * Sets the deck generator of this object.
     * @param deckGenerator An InterfaceGenerator object.
     */
    public void setDeckGenerator(@NotNull Generator deckGenerator) {
        this.deckGenerator = deckGenerator;
    }

    /**
     * Returns the StartGameAction instance.
     * @return The StartGameAction instance.
     */
    public static GameInitializer getInstance() {
        if(instance == null) instance = new GameInitializer();
        return instance;
    }

    @Override
    public void initialize() {
        aiGenerator.generate(GameData.getPlayers() - 1,
                GameData.getDifficulty());
        deckGenerator.generate();
        updateAll();
    }

}