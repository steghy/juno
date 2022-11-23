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

package juno.model.subjects.shift;

import juno.model.subjects.players.InterfaceSubjectsProvider;
import juno.model.util.Donut;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FirstSubjectManager<T, E>
        extends AbstractFirstSubjectManager<T, E>
        implements Observable, Observer {

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static FirstSubjectManager<?, ?> instance;

    private FirstSubjectManager() {
       observerList = new ArrayList<>();
    }

    public static FirstSubjectManager<?, ?> getInstance() {
        if(instance == null) instance = new FirstSubjectManager<>();
        return instance;
    }


    @Override
    public void setFirst() {
        if(subjects != null) {
            if(super.getHandsManager() != null) {
                subjects.initialize(0);
                setFirstRecursive(null);
                updateAll();
            } else {
                throw new IllegalArgumentException("Hands Manager is null");
            }
        } else {
           throw new IllegalArgumentException("Subjects is null");
        }
    }

    private void setFirstRecursive(@NotNull Collection<T> subjects) {

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
        observerList.forEach(observer -> observer.update(null));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceSubjectsProvider<?> obj) {
            this.subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid Subject type (" + object.getClass() + ") " +
                    "InterfaceSubjectsProvider expected.");
        }
    }
}