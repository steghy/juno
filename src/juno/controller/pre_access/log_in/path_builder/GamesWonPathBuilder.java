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

package juno.controller.pre_access.log_in.path_builder;

import juno.model.util.PathGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GamesWonPathBuilder
        extends AbstractPathBuilder {

    // The GamesWonPathBuilder instance.
    private static GamesWonPathBuilder instance;
    
    // Builds the GamesWonPath instance.
    private GamesWonPathBuilder() {}

    /**
     * Returns the GamesWonPathBuilder instance.
     * @return The GamesWonPathBuilder instance.
     */
    public static GamesWonPathBuilder getInstance() {
        if(instance == null) instance = new GamesWonPathBuilder();
        return instance;
    }

    @Override
    public String build(@NotNull String name) {
        return PathGenerator.generate(
                Objects.requireNonNull(getDirectory()),
                Objects.requireNonNull(getBuilder()).build(name));
    }

}