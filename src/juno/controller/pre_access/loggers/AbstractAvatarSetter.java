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

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This abstract class defines an abstract avatar setter.
 * @author Simone Gentili
 */
public abstract class AbstractAvatarSetter
        implements InterfaceAvatarSetter {

    /** Constructor. */
    public AbstractAvatarSetter() {}

    // The avatar image setter.
    private Setter<InterfaceAvatarImage> avatarImageSetter;

    // The avatar image.
    private InterfaceAvatarImage avatarImage;

    /**
     * Sets the avatar image setter of this object.
     * @param avatarImageSetter An InterfaceSetter object.
     */
    public void setAvatarImageSetter(@NotNull Setter<InterfaceAvatarImage> avatarImageSetter) {
        this.avatarImageSetter = avatarImageSetter;
    }

    /**
     * Sets the avatar image of this object.
     * @param avatarImage An InterfaceAvatarImage object.
     */
    public void setAvatarImage(@NotNull InterfaceAvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     * Returns the avatar image setter of this object.
     * @return An InterfaceSetter object.
     */
    @Nullable
    public Setter<InterfaceAvatarImage> getAvatarImageSetter() {
        return avatarImageSetter;
    }

    /**
     * Returns the avatar image of this object.
     * @return An InterfaceAvatarImage object.
     */
    @Nullable
    public InterfaceAvatarImage getAvatarImage() {
        return avatarImage;
    }


}