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

import juno.model.requester.InterfacePathProvider;
import juno.model.requester.ProgramDirectory;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.gobject.InterfacePathObjectProvider;

/**
 * @author Simone Gentili
 */
public class AvatarFramePathProvider
        implements InterfacePathObjectProvider<InterfaceAvatarFrame> {

    // The AvatarFramePathProvider instance.
    private static AvatarFramePathProvider instance;

    // Builds the AvatarFramePathProvider instance.
    private AvatarFramePathProvider() {}

    /**
     * Returns the AvatarFramePathProvider instance.
     * @return The AvatarFramePathProvider instance.
     */
    public static AvatarFramePathProvider getInstance() {
        if(instance == null) instance = new AvatarFramePathProvider();
        return instance;
    }

    @Override
    public InterfacePathProvider getPathObjectOf(InterfaceAvatarFrame frame) {
        return ProgramDirectory.FRAMES;
    }

}