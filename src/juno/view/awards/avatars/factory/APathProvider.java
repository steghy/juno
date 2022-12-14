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

package juno.view.awards.avatars.factory;

import juno.init.Directories;
import juno.init.InterfaceDirectories;
import juno.model.data.awards.avatar.InterfaceAvatar;

/**
 * @author Simone Gentili
 */
public class APathProvider
        implements
        InterfaceAPathProvider<InterfaceAvatar> {

    // The AvatarPathProvider instance.
    private static APathProvider instance;

    // Builds the AvatarPathProvider instance.
    private APathProvider() {}

    /**
     * Returns the APathProvider instance.
     * @return The APathProvider instance.
     */
    public static APathProvider getInstance() {
        if(instance == null) instance = new APathProvider();
        return instance;
    }

    @Override
    public InterfaceDirectories getPath(InterfaceAvatar avatar) {
        return Directories.AVATARS;
    }

}