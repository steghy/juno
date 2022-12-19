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

package juno.view.gobject.profiles;

import juno.model.util.InterfaceFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.view.gobject.AbstractGObjectFactory;
import juno.view.gobject.InterfaceGObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GProfileFactory
        extends AbstractGObjectFactory<File>
        implements Observer, Observable {

    // The graphic profile objects.
    private List<InterfaceGObject<File>> gProfiles;

    // The Observers List.
    private final List<Observer> observerList;

    // The GProfileFactory instance.
    private static GProfileFactory instance;

    // Builds the GProfileFactory instance.
    private GProfileFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the GProfileFactory instance.
     * @return The GProfileFactory instance.
     */
    public static GProfileFactory getInstance() {
        if(instance == null) instance = new GProfileFactory();
        return instance;
    }

    @Override @Nullable
    public List<InterfaceGObject<File>> getGObjects() {
        return gProfiles;
    }

    @Override
    public void generate(@NotNull List<File> profiles) {
        gProfiles = profiles.stream()
                .map(Objects.requireNonNull(getCreator())::create)
                .toList();
        updateAll();
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

    @Override @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceFactory<?> factory)
            generate((List<File>) factory.getObjects());
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceFactory type expected.");
    }

}