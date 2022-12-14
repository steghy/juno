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

package juno.controller.pre_access.log_in;

import juno.model.data.achievements.UnlockableAchievement;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines abstract account setters.
 * @author Simone Gentili
 * @param <T> The type of the object to set.
 */
public abstract class AbstractAccountSetter<T>
        implements Setter<T> {

    /** Constructor. */
    public AbstractAccountSetter() {}

    // The setters list.
    private final List<Setter<T>> setters = new ArrayList<>();

    // The achievement.
    private UnlockableAchievement achievement;

    /**
     * Returns a list of setter objects.
     * @return A List object.
     */
    public List<Setter<T>> setters() {
        return setters;
    }

    /**
     * Sets the achievement of this object.
     * @param achievement An UnlockableAchievement object.
     */
    public void setAchievement(@NotNull UnlockableAchievement achievement) {
        this.achievement = achievement;
    }

    /**
     * Returns the achievement of this object.
     * @return An UnlockableAchievement object.
     */
    @Nullable
    public UnlockableAchievement getAchievement() {
        return achievement;
    }

}