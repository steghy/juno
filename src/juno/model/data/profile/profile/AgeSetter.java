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

import juno.model.util.AbstractObservable;
import juno.model.util.Setter;

/**
 * This class defines an age setter.
 * @author Simone Gentili
 */
public class AgeSetter
        extends AbstractObservable
        implements Setter<Integer> {

    // The AgeSetter instance.
    private static AgeSetter instance;

    // Builds the AgeSetter instance.
    private AgeSetter() {}

    /**
     * Returns the AgeSetter instance.
     * @return The AgeSetter instance.
     */
    public static AgeSetter getInstance() {
        if(instance == null) instance = new AgeSetter();
        return instance;
    }

    @Override
    public void set(Integer age) {
        if(age < 1) throw new IllegalArgumentException(
                "must be greater than 0");
        if(age > Profile.MAXIMUM_AGE) throw new IllegalArgumentException(
                "must be less than 150");
        Profile.getInstance().age = age;
        updateAll();
    }

}
