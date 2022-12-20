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
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.gobject.AbstractGObjectCreator;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.gobject.InterfacePathObjectProvider;
import juno.model.requester.InterfacePathProviderAssembler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GAvatarFrameCreator
        extends AbstractGObjectCreator<InterfaceAvatarFrame>
        implements InterfaceGObjectCreator<InterfaceAvatarFrame> {

    // The GAvatarFrameCreator instance.
    private static GAvatarFrameCreator instance;

    // Builds the GAvatarFrameCreator instance.
    private GAvatarFrameCreator() {}

    /**
     * Returns the GAvatarFrameCreator instance.
     * @return The GAvatarFrameCreator instance.
     */
    public static GAvatarFrameCreator getInstance() {
        if(instance == null) instance = new GAvatarFrameCreator();
        return instance;
    }

    @Override
    public InterfaceGObject<InterfaceAvatarFrame> create(@NotNull InterfaceAvatarFrame frame) {
        GAvatarFrame<InterfaceAvatarFrame> graphicFrame = new GAvatarFrame<>(frame);
        InterfacePathProviderAssembler assembler = getAssembler();
        InterfacePathObjectProvider<InterfaceAvatarFrame> provider = getProvider();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(frame);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicFrame,
                assembler.assemble(pathObject, frame.name() + ".png"),
                assembler.assemble(pathObject, frame.name() + "_ROLLOVER" + ".png"));
        return graphicFrame;
    }

}