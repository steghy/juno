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

package juno.model.data.avatar;

import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.util.AbstractObservable;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * This class defines the avatar image setter.
 * @author Simone Gentili
 */
public class AvatarImageSetter
        extends AbstractObservable
        implements Setter<InterfaceAvatarImage> {

    // The AvatarImageSetter instance.
    private static AvatarImageSetter instance;

    // Builds the AvatarImageSetter instance.
    private AvatarImageSetter() {}

    /**
     * Returns the AvatarImageSetter instance.
     * @return The AvatarImageSetter instance.
     */
    public static AvatarImageSetter getInstance() {
        if(instance == null) instance = new AvatarImageSetter();
        return instance;
    }

    @Override
    public void set(@NotNull InterfaceAvatarImage avatarImage) {
        if(avatarImage.isUnlocked()) Avatar.getInstance().avatarImage = avatarImage;
        else throw new IllegalArgumentException(
                avatarImage + " is not unlocked.");
        updateAll();
    }

}