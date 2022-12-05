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

package juno.model.subjects.temp.human;

import juno.model.subjects.temp.AbstractPlayer;
import juno.model.subjects.temp.InterfacePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the card.
 */
public class HumanPlayer<T>
        extends AbstractPlayer<T>
        implements InterfacePlayer<T> {

    // The name.
    private String name;

    // HumanPlayer instance.
    private static HumanPlayer<?> instance;

    // Builds the HumanPlayer instance.
    private HumanPlayer() {}

    /**
     * Returns the HumanPlayer instance.
     * @return The HumanPlayer instance.
     */
    public static HumanPlayer<?> getInstance() {
        if(instance == null) instance = new HumanPlayer<>();
        return instance;
    }

    @Override
    public T move() {
        return null;
    }

    @Override
    public String name() {
        return name;
    }

    /**
     * Sets the name of this object.
     * @param name A String object
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

}