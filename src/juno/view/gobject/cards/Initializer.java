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

import juno.model.deck.DeckFactory;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.model.requester.PathProviderAssembler;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the juno.view.card package. */
    public static void initialize() {
        // Components.
        // GCardCreator.
        GCardCreator gCardCreator = GCardCreator.getInstance();

        // GCardFactory.
        GCardFactory gCardFactory = GCardFactory.getInstance();

        // GCardMapFactory.
        GCardMapFactory gCardMapFactory = GCardMapFactory.getInstance();

        // PathObjectAssembler.
        PathProviderAssembler pathObjectAssembler = PathProviderAssembler.getInstance();

        // ImageComponentInitializer.
        ImageComponentInitializer imageComponentInitializer = ImageComponentInitializer.getInstance();

        // CardPathProvider.
        CardPathProvider cardPathProvider = CardPathProvider.getInstance();

        ///////////////////////////////////////////////////////////////////////////////

        // Connections.
        // GCardCreator.
        gCardCreator.setProvider(cardPathProvider);
        gCardCreator.setInitializer(imageComponentInitializer);
        gCardCreator.setAssembler(pathObjectAssembler);

        // GCardFactory..
        gCardFactory.setCreator(gCardCreator);

        // GCardMapFactory.
        gCardMapFactory.setFactory(gCardFactory);

        // Observer / Observable.
        gCardFactory.addObserver(gCardMapFactory);
        DeckFactory.getInstance().addObserver(gCardFactory);
    }

}