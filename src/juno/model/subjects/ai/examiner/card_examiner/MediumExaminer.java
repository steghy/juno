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

import juno.model.subjects.ai.examiner.color_examiner.InterfaceExaminer;
import juno.model.subjects.ai.examiner.filter.AbstractFilterUser;
import juno.model.subjects.ai.examiner.filter.InterfaceFilter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This class defines a medium examiner.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class MediumExaminer<T>
        extends AbstractFilterUser<T>
        implements InterfaceExaminer<T> {

    // The MediumExaminer instance.
    private static MediumExaminer<?> instance;

    // Builds the MediumExaminer instance.
    private MediumExaminer() {}

    /**
     * Returns the MediumExaminer instance.
     * @return The MediumExaminer instance.
     */
    public static MediumExaminer<?> getInstance() {
        if(instance == null) instance = new MediumExaminer<>();
        return instance;
    }

    @Override
    public T response(@NotNull List<T> cards) {
        Random r = new Random();
        InterfaceFilter<T> filter = getFilter();

        // Action cards case.
        List<T> temp = Objects.requireNonNull(filter).action(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // Jolly cards case.
        temp = filter.jolly(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // Number cards case.
        temp = filter.number(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // It can't happen.
        else
            throw new IllegalArgumentException("Unavailable cards to play");
    }

}