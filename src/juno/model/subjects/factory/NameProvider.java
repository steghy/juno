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

package juno.model.subjects.factory;

import juno.model.util.RelativeProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class defines a name provider.
 * @author Simone Gentili
 */
public class NameProvider
        implements RelativeProvider<String, Integer> {

    // The names.
    private final List<String> names;

    // The NameFactory instance.
    private static NameProvider instance;

    // Builds the NameFactory instance.
    private NameProvider() {
        names = new ArrayList<>();
        init();
    }

    /**
     * Returns the NameFactory instance.
     * @return The NameFactory instance.
     */
    public static NameProvider getInstance() {
        if(instance == null) instance = new NameProvider();
        return instance;
    }

    @Override
    public List<String> provide(Integer num) {
        if(num > names.size()) throw new IllegalArgumentException("Only up to twenty");
        List<String> outputNames = new ArrayList<>();
        List<String> namesClone = new ArrayList<>(names);
        Random random = new Random();
        for(int i = 0; i < num; i ++) {
            int index = random.nextInt(namesClone.size());
            String name = namesClone.get(index);
            outputNames.add(name);
            namesClone.remove(index);
        } return outputNames;
    }

    // Initialize the names.
    private void init() {
        names.addAll(Arrays.asList(
                "Wade",
                "Dave",
                "Seth",
                "Ivan",
                "Riley",
                "Jorge",
                "Joshua",
                "Glen",
                "Peter",
                "Carlos",
                "Shane",
                "Harvey",
                "Clark",
                "Stefan",
                "Robin",
                "Tommy",
                "Neil",
                "Ted",
                "Benjamin",
                "Fred"));
    }

}