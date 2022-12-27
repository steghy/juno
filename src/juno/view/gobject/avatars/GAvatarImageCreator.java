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

import juno.model.requester.InterfacePathProvider;
import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.view.gobject.AbstractGObjectCreator;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.gobject.InterfacePathObjectProvider;
import juno.model.requester.InterfacePathProviderAssembler;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GAvatarImageCreator
        extends AbstractGObjectCreator<InterfaceAvatarImage>
        implements InterfaceGObjectCreator<InterfaceAvatarImage> {

    // The GAvatarImageCreator instance.
    private static GAvatarImageCreator instance;

    // Builds the GAvatarImageCreator.
    private GAvatarImageCreator() {}

    /**
     * Returns the GAvatarImageCreator instance.
     * @return The GAvatarImageCreator instance.
     */
    public static GAvatarImageCreator getInstance() {
        if(instance == null) instance = new GAvatarImageCreator();
        return instance;
    }

    @Override
    public InterfaceGObject<InterfaceAvatarImage> create(@NotNull InterfaceAvatarImage avatar) {
        GAvatarImage<InterfaceAvatarImage> graphicAvatar = new GAvatarImage<>(avatar);
        InterfacePathProviderAssembler assembler = getAssembler();
        InterfacePathObjectProvider<InterfaceAvatarImage> provider = getProvider();
        InterfacePathProvider pathObject = Objects.requireNonNull(provider).getPathObjectOf(avatar);
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicAvatar,
                assembler.assemble(pathObject, avatar.name() + ".png"),
                assembler.assemble(pathObject, avatar.name() + "_ROLLOVER" + ".png"));
        return graphicAvatar;
    }

}