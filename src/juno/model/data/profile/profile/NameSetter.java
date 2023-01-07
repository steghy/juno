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

package juno.model.data.profile.profile;

import juno.model.data.profile.Characters;
import juno.model.util.AbstractObservable;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * This class defines a name setter.
 * @author Simone Gentili
 */
public class NameSetter
        extends AbstractObservable
        implements Setter<String> {

    // The NameSetter instance.
    private static NameSetter instance;

    // Builds the NameSetter instance.
    private NameSetter() {}

    /**
     * Returns the NameSetter instance.
     * @return The NameSetter instance.
     */
    public static NameSetter getInstance() {
        if(instance == null) instance = new NameSetter();
        return instance;
    }

    @Override
    public void set(@NotNull String name) {
        int length = name.length();
        if(length == 0) throw new IllegalArgumentException(
                "the length must be greater than zero");
        if(length > Profile.MAXIMUM_LENGTH) throw new IllegalArgumentException(
                "the length must be less than fifteen" + length);
        if(Characters.IsNotAlpha(name)) throw new IllegalArgumentException(
                "alphabetic characters only");
        Profile.getInstance().name = name;
        updateAll();
    }

}