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

import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.requester.InterfacePathProvider;
import juno.model.requester.InterfacePathProviderAssembler;
import juno.view.gobject.AbstractGObjectCreator;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines a graphic avatar image creator.
 * @author Simone Gentili
 */
public class GAvatarImageCreator
        extends AbstractGObjectCreator<InterfaceAvatarImage>
        implements InterfaceGObjectCreator<InterfaceAvatarImage> {

    /** The ending part of the path to use. */
    public String ending = "_ROLLOVER";

    /** The extension to use. */
    public String extension = ".gif";

    // The directory path provider.
    private InterfacePathProvider pathProvider;

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

    /**
     * Sets the directory path provider of this object.
     * @param pathProvider An interfacePathProvider object.
     */
    public void setProvider(@NotNull InterfacePathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

    @Override
    public InterfaceGObject<InterfaceAvatarImage> create(@NotNull InterfaceAvatarImage avatar, RotatedIcon.Rotate rotate) {
        GAvatarImage<InterfaceAvatarImage> graphicAvatar = new GAvatarImage<>(avatar);
        InterfacePathProviderAssembler assembler = getAssembler();
        Objects.requireNonNull(assembler);
        Objects.requireNonNull(getInitializer()).initialize(
                graphicAvatar,
                assembler.assemble(pathProvider, avatar.name() + extension),
                assembler.assemble(pathProvider, avatar.name() + ending + extension),
                rotate);
        return graphicAvatar;
    }

}