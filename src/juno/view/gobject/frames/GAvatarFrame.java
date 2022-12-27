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

package juno.view.gobject.frames;

import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.util.Observer;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.InterfaceGObject;
import juno.view.util.ImageButton;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 * @param <T> The type of the avatar frames.
 */
public class GAvatarFrame<T> extends GObjectButton<T> {

    public GAvatarFrame(@NotNull T object) {
        super(object);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAvatarFrame avatarFrame)
            setEnabled(avatarFrame.isUnlock());
    }

}