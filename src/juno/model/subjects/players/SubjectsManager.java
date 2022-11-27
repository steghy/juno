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

package juno.model.subjects.players;

import juno.model.util.Donut;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

public class SubjectsManager<T>
        implements InterfaceSubjectsManager<T>, Observer {

    private Donut<T> subjects;
    private static SubjectsManager<?> instance;

    private SubjectsManager() {}

     public static SubjectsManager<?> getInstance() {
        if(instance == null) instance = new SubjectsManager<>();
        return instance;
    }

    @Override
    public T currentSubject() {
        if(subjects != null) {
            return subjects.current();
        } else {
            throw new IllegalArgumentException("Players is null");
        }
    }

    @Override
    public T nextSubject() {
        if(subjects != null) {
            return subjects.peek();
        } else {
            throw new IllegalArgumentException("Players is null");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceSubjectsProvider<?> obj) {
            subjects = new Donut<>();
            this.subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid object type (" + object.getClass() +") " +
                    "InterfaceSubjectsProvider expected.");
        }
    }
}
