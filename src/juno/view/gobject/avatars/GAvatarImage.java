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

package juno.view.gobject.avatars;

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.util.Observer;
import juno.view.gobject.InterfaceGObject;
import juno.view.util.ImageButton;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the avatars.
 */
public class GAvatarImage<T>
        extends ImageButton
        implements InterfaceGObject<T>, Observer {

    // The avatar.
    private final T avatar;

    /**
     * Builds a GAvatarImage object with
     * the specified avatar object.
     * @param avatar An avatar object.
     */
    public GAvatarImage(@NotNull T avatar) {
        this.avatar = avatar;
    }

    @Override
    public T object() {
        return avatar;
    }

    @Override
    public void update(Object object) {
        if(object instanceof InterfaceAvatarImage avatarImage) {
            setEnabled(avatarImage.isUnlock());
        }
    }

}