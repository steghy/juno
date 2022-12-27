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

package juno.model.subjects.ai.examiner;

import juno.model.card.InterfaceCard;
import juno.model.deck.CompatibleCardsProvider;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer instance.
    private Initializer() {}

    @SuppressWarnings("ALL")
    public static void initialize() {
        // Components.
        // EasyExaminer.
        EasyExaminer<InterfaceCard> easyExaminer = (EasyExaminer<InterfaceCard>) EasyExaminer.getInstance();

        // MediumExaminer.
        MediumExaminer<InterfaceCard> mediumExaminer = (MediumExaminer<InterfaceCard>) MediumExaminer.getInstance();

        // HardExaminer.
        HardExaminer<InterfaceCard> hardExaminer = (HardExaminer<InterfaceCard>) HardExaminer.getInstance();

        // CompatibleCardProvider.
        CompatibleCardsProvider compatibleCardsProvider = CompatibleCardsProvider.getInstance();

        // Examiner.
        CardExaminer<InterfaceCard> examiner = (CardExaminer<InterfaceCard>) CardExaminer.getInstance();

        // Filter.
        Filter filter = Filter.getInstance();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Connections.
        // Examiner.
        examiner.setEasy(easyExaminer);
        examiner.setMedium(mediumExaminer);
        examiner.setHard(hardExaminer);
        examiner.setItemsProvider(compatibleCardsProvider);

        // EasyExaminer.
        easyExaminer.setFilter(filter);
        mediumExaminer.setFilter(filter);
        hardExaminer.setFilter(filter);
    }

}