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

package juno.controller.pre_access.log_in.name_builder;

import org.jetbrains.annotations.NotNull;


/**
 * @author Simone Gentili
 */
public class GamesWonFileNameBuilder
        implements InterfaceFileNameBuilder {

    /** The ending String object. */
    public static final String ending = "-games-won.json";

    // The GamesWonFileNameBuilder instance.
    public static GamesWonFileNameBuilder instance;

    // Builds a GamesWonFileNameBuilder object.
    private GamesWonFileNameBuilder() {}

    /**
     * Returns the GamesWonFileNameBuilder instance.
     * @return The GamesWonFileNameBuilder instance.
     */
    public static GamesWonFileNameBuilder getInstance() {
        if(instance == null) instance = new GamesWonFileNameBuilder();
        return instance;
    }

    /**
     * Builds the games won file name.
     * @param profileName A String object.
     * @return A String object.
     */
    @Override
    public String build(@NotNull String profileName) {
        if(profileName.length() == 0) throw new IllegalArgumentException(
                "Invalid profile name length.");
        return profileName.toLowerCase() + ending;
    }

}