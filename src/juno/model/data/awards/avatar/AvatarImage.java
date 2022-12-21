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

package juno.model.data.awards.avatar;

import juno.model.data.goals.InterfaceGoal;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simone Gentili
 */
public enum AvatarImage
        implements InterfaceAvatarImage, Observable, Observer {

    /** The default avatar image. */
    AVATAR_IMAGE_1,

    /** The avatar image 2. */
    AVATAR_IMAGE_2,

    /** The avatar image 3. */
    AVATAR_IMAGE_3,

    /** The avatar image 4. */
    AVATAR_IMAGE_4,

    /** The avatar image 5. */
    AVATAR_IMAGE_5,

    /** The avatar image 6. */
    AVATAR_IMAGE_6,

    /** The avatar image 7. */
    AVATAR_IMAGE_7,

    /** The avatar image 8. */
    AVATAR_IMAGE_8,

    /** The avatar image 9. */
    AVATAR_IMAGE_9;

    // The Observers List.
    private final List<Observer> observerList;

    // Unlock boolean value.
    private boolean unlock = false;

    // Builds an AvatarImage object.
    AvatarImage() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public boolean isUnlock() {
        return unlock;
    }

    @Override
    public void unlock() {
        if(unlock) throw new IllegalArgumentException(
                "This award is already unlocked.");
        unlock = true;
        updateAll();
    }

    void lock() {
        unlock = false;
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

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceGoal goal) {
            if(goal.isReached()) unlock();
            else lock();
        }
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceGoal type expected.");
    }

}