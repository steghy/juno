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

import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.util.AbstractObservable;
import juno.model.util.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 */
public class AvatarFrameSetter
        extends AbstractObservable
        implements Setter<InterfaceAvatarFrame> {

    // The AvatarFrameSetter instance.
    private static AvatarFrameSetter instance;

    // Builds the AvatarFrameSetter instance.
    private AvatarFrameSetter() {}

    /**
     * Returns the AvatarFrameSetter instance.
     * @return The AvatarFrameSetter instance.
     */
    public static AvatarFrameSetter getInstance() {
        if(instance == null) instance = new AvatarFrameSetter();
        return instance;
    }

    @Override
    public void set(@NotNull InterfaceAvatarFrame avatarFrame) {
        if(avatarFrame.isUnlock()) Avatar.getInstance().avatarFrame = avatarFrame;
        else throw new IllegalArgumentException(
                avatarFrame + " is not unlocked.");
        updateAll();
    }

}