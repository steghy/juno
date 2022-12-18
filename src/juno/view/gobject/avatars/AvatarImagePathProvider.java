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

import juno.init.InterfacePathProvider;
import juno.init.PathProvider;
import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.view.gobject.InterfacePathObjectProvider;

/**
 * @author Simone Gentili
 */
public class AvatarImagePathProvider
        implements InterfacePathObjectProvider<InterfaceAvatarImage> {

    // The AvatarImagePathProvider instance.
    private static AvatarImagePathProvider instance;

    // Builds the AvatarImagePathProvider instance.
    private AvatarImagePathProvider() {}

    /**
     * Returns the AvatarImagePathProvider instance.
     * @return The AvatarImagePathProvider instance.
     */
    public static AvatarImagePathProvider getInstance() {
        if(instance == null) instance = new AvatarImagePathProvider();
        return instance;
    }

    @Override
    public InterfacePathProvider getPathObjectOf(InterfaceAvatarImage avatar) {
        return PathProvider.AVATARS;
    }

}