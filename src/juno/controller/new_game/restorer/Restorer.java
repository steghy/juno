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

import juno.controller.log_out.Restorable;
import juno.controller.util.Stoppable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class Restorer
        implements Restorable, Observer {

    // The restorable objects list
    private final List<Restorable> restorableList;

    // The Restorer instance.
    private static Restorer instance;

    // Builds the Restorer instance.
    private Restorer() {
        restorableList = new ArrayList<>();
    }

    /**
     * Returns the Restorer instance.
     * @return The Restorer instance.
     */
    public static Restorer getInstance() {
        if(instance == null) instance = new Restorer();
        return instance;
    }

    /**
     * Returns the restorable objects list of this object.
     * @return A List object.
     */
    public List<Restorable> getRestorableList() {
        return restorableList;
    }

    @Override
    public void restore() {
        restorableList.forEach(Restorable::restore);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof Stoppable) {
            restore();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Stoppable type expected");
    }

}