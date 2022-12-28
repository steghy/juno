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

package juno.view.gobject.color;

import juno.model.card.colors.InterfaceColor;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.view.gobject.AbstractGObjectFactory;
import juno.view.gobject.InterfaceGObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GColorFactory
        extends AbstractGObjectFactory<InterfaceColor>
        implements Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The graphic color objects.
    private List<InterfaceGObject<InterfaceColor>> gColors;

    // The GColorFactory instance.
    private static GColorFactory instance;

    // Builds the GColorFactory instance.
    private GColorFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the GColorFactory instance.
     * @return The GColorFactory instance.
     */
    public static GColorFactory getInstance() {
        if(instance == null) instance = new GColorFactory();
        return instance;
    }

    @Override @Nullable
    public List<InterfaceGObject<InterfaceColor>> getGObjects() {
        return gColors;
    }

    @Override
    public void generate(@NotNull List<InterfaceColor> colors) {
        this.gColors = colors.stream()
                .map(Objects.requireNonNull(getCreator())::create)
                .toList();
    }

    @Override
    public void addObserver(Observer observer) {
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
}