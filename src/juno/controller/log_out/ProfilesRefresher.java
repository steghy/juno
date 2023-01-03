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

package juno.controller.log_out;

import juno.model.util.AbstractObservable;
import juno.model.util.Generator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class ProfilesRefresher
        extends AbstractObservable
        implements Refresher {

    // The generator.
    @Nullable
    private Generator generator;

    // The ProfilesRefresher instance.
    private static ProfilesRefresher instance;

    // Builds the ProfilesRefresher instance.
    private ProfilesRefresher() {}

    /**
     * Returns the ProfilesRefresher instance.
     * @return The ProfilesRefresher instance.
     */
    public static ProfilesRefresher getInstance() {
        if(instance == null) instance = new ProfilesRefresher();
        return instance;
    }

    /**
     * Sets the generator of this object.
     * @param generator A Generator object.
     */
    public void setGenerator(@NotNull Generator generator) {
        this.generator = generator;
    }

    @Override
    public void refresh() {
        updateAll();
        Objects.requireNonNull(generator).generate();
    }

}