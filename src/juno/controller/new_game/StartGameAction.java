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

import juno.controller.util.AbstractChangePanelUser;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.factory.InterfaceAiPlayerGenerator;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Simone Gentili
 */
public class StartGameAction
        extends AbstractChangePanelUser
        implements ActionListener {

    // The ai players generator.
    private InterfaceAiPlayerGenerator<InterfaceDifficulty> generator;

    // The StartGameAction instance.
    private static StartGameAction instance;

    /**
     * Returns the StartGameAction instance.
     * @return The StartGameAction instance.
     */
    public static StartGameAction getInstance() {
        if(instance == null) instance = new StartGameAction();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generator.generate(GameData.players - 1, GameData.difficulty);
    }

    /**
     * Sets the ai player generator of this object.
     * @param generator An InterfaceAiPlayerGenerator object.
     */
    public void setGenerator(@NotNull InterfaceAiPlayerGenerator<InterfaceDifficulty> generator) {
        this.generator = generator;
    }

}