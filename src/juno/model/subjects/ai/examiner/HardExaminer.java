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

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public class HardExaminer<T>
        extends AbstractCardExaminer<T>
        implements InterfaceHardExaminer<T> {

    // The HardExaminer instance.
    private static HardExaminer<?> instance;

    // Builds the HardExaminer instance.
    private HardExaminer() {}

    /**
     * Returns the HardExaminer instance.
     * @return The HardExaminer instance.
     */
    public static HardExaminer<?> getInstance() {
        if(instance == null) instance = new HardExaminer<>();
        return instance;
    }

    @Override
    public T response(@NotNull List<T> cards) {
        Random r = new Random();
        InterfaceFilter<T> filter = getFilter();

        // Jolly cards case.
        List<T> temp = Objects.requireNonNull(filter).jolly(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // Action cards case.
        temp = filter.action(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // Number cards case.
        temp = filter.number(cards);
        if(temp.size() != 0) return temp.get(r.nextInt(temp.size()));

        // It can't happen.
        else
            throw new IllegalArgumentException("Unavailable cards to play");
    }

}