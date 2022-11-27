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

import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandsManager<T, E>
        implements InterfaceHandsManager<T, E>, Observer{

    private Map<?, ? extends List<?>> handsMap;
    private static HandsManager<?, ?> instance;

    private HandsManager() {}

    public static HandsManager<?, ?> getInstance() {
        if(instance == null) instance = new HandsManager<>();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getItemsOf(@NotNull T subject) {
        if(handsMap != null) {
            if(handsMap.containsKey(subject)) {
                return (List<E>) handsMap.get(subject);
            } else {
                throw new IllegalArgumentException("Invalid subject (" + subject + ")");
            }
        } else {
            throw new IllegalArgumentException("HandsMap is null");
        }
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceHandsProvider<?, ?> handsMaintainer) {
            handsMap = new HashMap<>();
            this.handsMap = handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ") " +
                    "InterfaceHandsProvider expected.");
        }
    }
}