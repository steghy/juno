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

package juno.model.data.awards.frame;

import juno.model.data.goals.InterfaceGoal;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
@Deprecated
public enum AvatarFrame
        implements InterfaceAvatarFrame, Observer, Observable {

    /** The grey frame. */
    GREY_FRAME,

    /** The blue frame. */
    BLUE_FRAME,

    /** The gold frame. */
    GOLD_FRAME,

    /** The pink frame. */
    PINK_FRAME,

    /** The cyan green frame. */
    CYAN_GREEN_FRAME,

    /** The red frame. */
    RED_FRAME,

    /** The white frame. */
    WHITE_FRAME,

    /** The yellow frame. */
    YELLOW_FRAME,

    /** The black frame. */
    BLACK_FRAME;

    // The Observers List.
    private final List<Observer> observerList;

    // Unlock boolean value.
    private boolean unlock = false;

    // Builds an AvatarFrame object.
    AvatarFrame() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public boolean isUnlock() {
        return unlock;
    }

    @Override
    public void unlock() {
        if (unlock) throw new IllegalArgumentException(
                "This award is already unlocked.");
        unlock = true;
        updateAll();
    }

    void lock() {
        unlock = false;
        updateAll();
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
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGoal goal) {
            if(goal.isReached()) unlock();
            else lock();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGoal type expected.");
    }

}