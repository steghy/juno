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
import juno.model.card.colors.Color;
import juno.model.card.colors.InterfaceColor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author Simone Gentili
 */
public class ColorExaminer
        extends AbstractFilterUser<InterfaceCard>
        implements InterfaceColorExaminer<InterfaceColor, InterfaceCard>{

    // The ColorExaminer instance.
    private static ColorExaminer instance;

    // Builds the ColorExaminer instance.
    private ColorExaminer() {}

    /**
     * Returns the ColorExaminer instance.
     * @return The ColorExaminer instance.
     */
    public static ColorExaminer getInstance() {
        if(instance == null) instance = new ColorExaminer();
        return instance;
    }

    @Override
    public InterfaceColor responseRelativeTo(@NotNull List<InterfaceCard> cards) {
        return Color.RED;
    }

}
