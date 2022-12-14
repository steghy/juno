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

import juno.model.data.awards.avatar.InterfaceAvatar;
import juno.view.awards.avatars.GAvatar;
import juno.view.awards.avatars.InterfaceGAvatar;
import juno.view.util.Constant;
import juno.view.util.ImageComponentInitializer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
@SuppressWarnings("ALL")
public class GAvatarCreator
        extends AbstractGAvatarCreator<InterfaceAvatar>
        implements InterfaceGAvatarCreator<InterfaceAvatar> {

    // The extension of the avatar image.
    private String extension = ".png";

    // The GAvatarCreator instance.
    private static GAvatarCreator instance;

    // Builds the GAvatarCreator.
    private GAvatarCreator() {}

    /**
     * Returns the GAvatarCreator instance.
     * @return The GAvatarCreator instance.
     */
    public static GAvatarCreator getInstance() {
        if(instance == null) instance = new GAvatarCreator();
        return instance;
    }

    @Override
    public InterfaceGAvatar<InterfaceAvatar> create(@NotNull InterfaceAvatar avatar) {
        GAvatar<InterfaceAvatar> graphicAvatar = new GAvatar<>(avatar);
        ImageComponentInitializer.initialize(
                graphicAvatar,
                Objects.requireNonNull(getProvider()).getPath(avatar),
                false,
                avatar.toString(),
                avatar.name() + extension,
                null,
                Constant.THROW_EXCEPTION);
        return graphicAvatar;
    }

}