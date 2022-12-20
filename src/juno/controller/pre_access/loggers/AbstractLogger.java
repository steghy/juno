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

package juno.controller.pre_access.loggers;

import juno.controller.util.AbstractChangePanelUser;
import juno.model.data.goals.InterfaceGoal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractLogger
        extends AbstractChangePanelUser
        implements InterfaceLogger {

    // The registration goal.
    private InterfaceGoal registrationGoal;

    // The avatar setter.
    private InterfaceAvatarSetter avatarSetter;

    /**
     * Sets the registration goal of this object.
     * @param registrationGoal An InterfaceGoal object.
     */
    public void setRegistrationGoal(@NotNull InterfaceGoal registrationGoal) {
        this.registrationGoal = registrationGoal;
    }

    /**
     * Sets the avatar setter of this object.
     * @param avatarSetter An InterfaceAvatarSetter object.
     */
    public void setAvatarSetter(@NotNull InterfaceAvatarSetter avatarSetter) {
        this.avatarSetter = avatarSetter;
    }

    /**
     * Returns the registration goal of this object.
     * @return An InterfaceGoal object.
     */
    @Nullable
    public InterfaceGoal getRegistrationGoal() {
        return registrationGoal;
    }

    /**
     * Returns the avatar setter of this object.
     * @return An InterfaceAvatarSetter object.
     */
    @Nullable
    public InterfaceAvatarSetter getAvatarSetter() {
        return avatarSetter;
    }

}