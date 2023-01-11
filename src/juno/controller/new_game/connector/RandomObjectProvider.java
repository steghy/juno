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

package juno.controller.new_game.connector;

import juno.model.util.Provider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class defines a random object provider.
 * @author Simone Gentili
 * @param <T> The type of the object to provide.
 */
public class RandomObjectProvider<T>
        implements Provider<T> {

    // The original list.
    private final List<T> original;

    // The copy list.
    private final List<T> copy;

    /**
     * Builds a RandomObjectProvider with the
     * specified List object.
     * @param original A List object.
     */
    public RandomObjectProvider(@NotNull List<T> original) {
        this.original = original;
        copy = new ArrayList<>();
        copy.addAll(original);
    }

    /** Reset the random object provider. */
    public void reset() {
        copy.clear();
        copy.addAll(original);
    }

    @Override
    public T provide() {
        Random r = new Random();
        int index = r.nextInt(copy.size());
        T o = copy.get(index);
        copy.remove(o);
        return o;
    }

}