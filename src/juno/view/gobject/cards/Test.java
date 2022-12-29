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

package juno.view.gobject.cards;

import juno.model.card.Card;
import juno.model.card.InterfaceCard;
import juno.model.card.colors.Color;
import juno.model.requester.*;
import juno.model.requester.Initializer;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        Initializer.initialize();
        ImageComponentInitializer initializer = ImageComponentInitializer.getInstance();
        initializer.setRequester(Requester.getInstance());
        GCardCreator gCardCreator = GCardCreator.getInstance();
        gCardCreator.setInitializer(ImageComponentInitializer.getInstance());
        gCardCreator.setProvider(CardPathProvider.getInstance());
        gCardCreator.setAssembler(PathProviderAssembler.getInstance());
        GCard<InterfaceCard> gCard = (GCard<InterfaceCard>)
                gCardCreator.create(new Card(Color.BLUE, 9, null), RotatedIcon.Rotate.DOWN);
        ImageResizer.resize(gCard, 1.5);
        JFrame frame = new JFrame();
        frame.add(gCard);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
