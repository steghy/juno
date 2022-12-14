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

package juno.view.awards.frames.factory;

import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.awards.frames.GFrame;
import juno.view.awards.frames.InterfaceGFrame;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
@SuppressWarnings("ALL")
public class GFrameCreator
        extends AbstractGFrameCreator<InterfaceAvatarFrame> {

    // The extension of the avatar image.
    private String extension = ".png";

    // The GFrameCreator instance.
    private static GFrameCreator instance;

    // Builds the GFrameCreator instance.
    private GFrameCreator() {}

    /**
     * Returns the GFrameCreator instance.
     * @return The GFrameCreator instance.
     */
    public static GFrameCreator getInstance() {
        if(instance == null) instance = new GFrameCreator();
        return instance;
    }

    @Override
    public InterfaceGFrame<InterfaceAvatarFrame> create(@NotNull InterfaceAvatarFrame frame) {
        GFrame<InterfaceAvatarFrame> graphicFrame = new GFrame<>(frame);
        ImageComponentInitializer.initialize(
                graphicFrame,
                Objects.requireNonNull(getProvider()).getPath(frame),
                false,
                frame.toString(),
                frame.name() + extension,
                null,
                Constant.THROW_EXCEPTION);
        return graphicFrame;
    }

}