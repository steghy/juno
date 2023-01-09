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

package juno.controller.new_game.restorer;

import juno.controller.util.Stoppable;
import juno.model.util.AbstractObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines a stopper
 * @author Simone Gentili
 */
public class Stopper
        extends AbstractObservable
        implements Stoppable {

    // The stoppable objects list.
    private final List<Stoppable> stoppableList;

    // The Stopper instance.
    private static Stopper instance;

    // Builds the Stopper instance.
    private Stopper() {
        stoppableList = new ArrayList<>();
    }

    /**
     * Returns the Stopper instance.
     * @return The Stopper instance.
     */
    public static Stopper getInstance() {
        if(instance == null) instance = new Stopper();
        return instance;
    }

    /**
     * Returns the stoppable objects list of this object.
     * @return A List object.
     */
    public List<Stoppable> getStoppableList() {
        return stoppableList;
    }

    @Override
    public void stop() {
        stoppableList.forEach(Stoppable::stop);
        updateAll();
    }

}