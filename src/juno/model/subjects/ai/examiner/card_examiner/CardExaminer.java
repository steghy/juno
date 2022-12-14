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

package juno.model.subjects.ai.examiner.card_examiner;

import juno.model.subjects.ai.InterfaceDifficulty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

/**
 * This class defines a card examiner.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class CardExaminer<T>
        extends AbstractMultiExaminer<T> {

    // The Examiner instance.
    private static CardExaminer<?> instance;

    // Builds the Examiner instance.
    private CardExaminer() {}

    /**
     * Returns the Examiner instance.
     * @return The Examiner instance.
     */
    public static CardExaminer<?> getInstance() {
        if(instance == null) instance = new CardExaminer<>();
        return instance;
    }

    @Override @Nullable
    public T responseRelativeTo(@NotNull List<T> cards,
                                @NotNull InterfaceDifficulty difficulty) {
        // Compatible cards.
        List<T> compatibleCards = Objects.requireNonNull(getItemsProvider())
                .getCompatibleCards(cards);

        // Empty compatible cards case.
        if(compatibleCards.isEmpty()) return null;

        // Easy difficulty case.
        if(difficulty.isEasy()) return Objects.requireNonNull(getEasyExaminer())
                .response(compatibleCards);

        // Medium difficulty case.
        if(difficulty.isMedium()) return Objects.requireNonNull(getMediumExaminer())
                .response(compatibleCards);

        // Hard difficulty case.
        else return Objects.requireNonNull(getHardExaminer())
                .response(compatibleCards);
    }

}