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

package juno.view.card.factory.test;

import juno.init.Repository;
import juno.model.card.Card;
import juno.model.card.InterfaceCard;
import juno.model.card.actions.Action;
import juno.view.card.GCard;
import juno.view.card.Initializer;
import juno.view.card.factory.*;
import juno.view.util.ImageResizer;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class GCardCreatorTester {

    public static void main(String[] args) {
        Repository.setRepository();
        Initializer.initialize();
        InterfaceGCardCreator<InterfaceCard> gCardCreator = GCardCreator.getInstance();
        GCard<InterfaceCard> gCard = (GCard<InterfaceCard>) gCardCreator.create(new Card(null, null, Action.DRAW_FOUR));
        ImageResizer.resize(gCard, 1.0);
        JFrame frame = new JFrame();
        frame.setBackground(java.awt.Color.BLUE);
        frame.add(gCard);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}