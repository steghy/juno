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

import juno.controller.util.InterfaceInitializer;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.util.Donut;
import juno.model.util.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class StartGameAction
        implements ActionListener, Observer {

    // The StartGameAction instance.
    private static StartGameAction instance;

    // Builds the StartGameAction instance.
    private StartGameAction() {}

    /**
     * Builds the StartGameAction instance.
     * @return The StartGameAction instance.
     */
    public static StartGameAction getInstance() {
        if(instance == null) instance = new StartGameAction();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        CardDispenser.getInstance().getTimer().start();
        Donut<InterfacePlayer<?>> players = (Donut<InterfacePlayer<?>>) PlayersProvider.getInstance().provide();
        Objects.requireNonNull(players).initialize(0);
    }

    @Override
    public void update(Object object) {
        if(object instanceof InterfaceInitializer) {
            actionPerformed(null);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceInitializer type expected.");
    }

}