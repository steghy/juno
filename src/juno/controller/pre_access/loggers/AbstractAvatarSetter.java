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
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Simone Gentili
 */
public abstract class AbstractAvatarSetter
        implements InterfaceAvatarSetter {

    // The avatar frame setter.
    private Setter<InterfaceAvatarFrame> avatarFrameSetter;

    // The avatar frame.
    private InterfaceAvatarFrame avatarFrame;

    // The avatar image setter.
    private Setter<InterfaceAvatarImage> avatarImageSetter;

    // The avatar image.
    private InterfaceAvatarImage avatarImage;

    /**
     * Sets the avatar frame setter of this object.
     * @param avatarFrameSetter An InterfaceSetter object.
     */
    public void setAvatarFrameSetter(@NotNull Setter<InterfaceAvatarFrame> avatarFrameSetter) {
        this.avatarFrameSetter =  avatarFrameSetter;
    }

    /**
     * Sets the avatar frame of this object.
     * @param avatarFrame An InterfaceAvatarFrame object.
     */
    public void setAvatarFrame(@NotNull InterfaceAvatarFrame avatarFrame) {
        this.avatarFrame = avatarFrame;
    }

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
     * Returns the avatar frame setter of this object.
     * @return An InterfaceSetter object.
     */
    @Nullable
    public Setter<InterfaceAvatarFrame> getAvatarFrameSetter() {
        return avatarFrameSetter;
    }

    /**
     * Returns the avatar frame of this object.
     * @return An InterfaceAvatarFrame object.
     */
    @Nullable
    public InterfaceAvatarFrame getAvatarFrame() {
        return avatarFrame;
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