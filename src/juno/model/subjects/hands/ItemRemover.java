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

package juno.model.subjects.hands;

import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRemover<T, E> implements
        InterfaceItemRemover<T, E>, Observable, Observer {

    private Map<?, ? extends List<?>> handsMap;
    private final List<Observer> observerList;
    private static ItemRemover<?, ?> instance;

    private ItemRemover() {
        observerList = new ArrayList<>();
    }

    public static ItemRemover<?, ?> getInstance() {
        if(instance == null) instance = new ItemRemover<>();
        return instance;
    }

    public void setHandsMap(@NotNull Map<T, List<E>> handsMap) {
        this.handsMap = handsMap;
    }

    @Override
    public void removeItemTo(@NotNull T subject,
                             @NotNull E item) {
        if(handsMap != null) {
            if(handsMap.containsKey(subject)) {
                // is index usage better ? maybe
                handsMap.get(subject).remove(item);
                updateAll();
            } else {
                throw new IllegalArgumentException("Invalid subject (" + subject + ")");
            }
        } else {
            throw new IllegalArgumentException("Hands map is null");
        }
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceHandsProvider<?,?> handsMaintainer) {
            handsMap = new HashMap<>();
            this.handsMap = handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ") " +
                    "InterfaceHandsProvider expected.");
        }
    }
}