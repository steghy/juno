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

package juno.model.deck;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class defines an abstract compatibility checker user.
 * @author Simone Gentili
 * @param <T> The type of the cards.
 */
public abstract class AbstractCompatibilityCheckerUser<T> {

    // The compatibility checker.
    private InterfaceCompatibilityChecker<T> compatibilityChecker;

    /**
     * Sets the compatibility checker of this object.
     * @param compatibilityChecker An InterfaceCompatibilityChecker object.
     */
    public void setCompatibilityChecker(@NotNull InterfaceCompatibilityChecker<T> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    /**
     * Returns the compatibility checker of this object.
     * @return An InterfaceCompatibilityChecker object.
     */
    @Nullable
    public InterfaceCompatibilityChecker<T> getCompatibilityChecker() {
        return compatibilityChecker;
    }

}