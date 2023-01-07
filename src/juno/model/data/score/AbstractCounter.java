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

package juno.model.data.score;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.controller.log_out.Restorable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class defines an abstract counter.
 * @author Simone Gentili
 */
public abstract class AbstractCounter
        implements Counter<Integer>, Observable, Configurable, Exportable, Restorable {

    /** The count key. */
    public static final String COUNT_KEY = "count";

    // The count.
    int count;

    // The Observers List.
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void increase() {
        count++;
        updateAll();
    }

    @Override
    public Integer provide() {
        return count;
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        if(map.containsKey(COUNT_KEY)) {
            Object object = map.get(COUNT_KEY);
            if(object instanceof Integer value) {
                setCount(value);
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". Integer type expected.");
        } else throw new IllegalArgumentException(
                COUNT_KEY + " is missing.");
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        map.put(COUNT_KEY, count);
        return map;
    }

    @Override
    public void restore() {
        count = 0;
        updateAll();
    }

    /**
     * Sets the value of the counter.
     * @param count An integer value.
     */
    void setCount(int count) {
        if(count < 0) throw new IllegalArgumentException(
                "Invalid count: " + count);
        this.count = 0;
        for(int i = 1; i < count + 1; i++) increase();
    }

}