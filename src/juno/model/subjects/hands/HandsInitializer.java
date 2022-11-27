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

package juno.model.subjects.hands;

import juno.model.card.InterfaceUnoCard;
import juno.model.subjects.factory.InterfaceSubject;

public class HandsInitializer {

    private HandsInitializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        // OBSERVERS
        ItemAdder<InterfaceSubject, InterfaceUnoCard> itemAdder =
                (ItemAdder<InterfaceSubject, InterfaceUnoCard>) ItemAdder.getInstance();

        ItemRemover<InterfaceSubject, InterfaceUnoCard> itemRemover =
                (ItemRemover<InterfaceSubject, InterfaceUnoCard>) ItemRemover.getInstance();

        HandsManager<InterfaceSubject, InterfaceUnoCard> handsManager =
                (HandsManager<InterfaceSubject, InterfaceUnoCard>) HandsManager.getInstance();

        // SUBJECT
        HandsProvider<InterfaceSubject, InterfaceUnoCard> handsProvider =
                (HandsProvider<InterfaceSubject, InterfaceUnoCard>) HandsProvider.getInstance();

        // ADDING OBSERVERS
        handsProvider.addObserver(itemAdder);
        handsProvider.addObserver(itemRemover);
        handsProvider.addObserver(handsManager);
    }
}