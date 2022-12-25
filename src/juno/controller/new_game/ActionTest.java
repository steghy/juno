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

import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.AI;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.players.PlayersProvider;
import juno.model.subjects.shift.Inverter;
import juno.model.util.Donut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTest
        implements ActionListener {

    public ActionTest() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Donut<InterfacePlayer<?>> pl = (Donut<InterfacePlayer<?>>) PlayersProvider.getInstance().getPlayers();
        AI<InterfaceCard> ai1 = (AI<InterfaceCard>) pl.get(0);
        HumanPlayer<InterfaceCard> humanPlayer = (HumanPlayer<InterfaceCard>) pl.get(1);

        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();

        ai1.add(deck.draw());
        humanPlayer.add(deck.draw());
        Inverter.getInstance().invert();
    }

}