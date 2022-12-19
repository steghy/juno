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

import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.view.gobject.AbstractGObjectFactory;
import juno.view.gobject.InterfaceGObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GAvatarImageFactory
        extends AbstractGObjectFactory<InterfaceAvatarImage> {

    // The avatar images objects.
    private List<InterfaceGObject<InterfaceAvatarImage>> avatarImages;

    // The GAvatarImageFactory instance.
    private static GAvatarImageFactory instance;

    // Builds the GAvatarImageFactory instance.
    private GAvatarImageFactory() {}

    /**
     * Returns the GAvatarImageFactory instance.
     * @return The GAvatarImageFactory instance.
     */
    public static GAvatarImageFactory getInstance() {
        if(instance == null) instance = new GAvatarImageFactory();
        return instance;
    }

    @Override @Nullable
    public List<InterfaceGObject<InterfaceAvatarImage>> getGObjects() {
        return avatarImages;
    }

    @Override
    public void generate(@NotNull List<InterfaceAvatarImage> avatarImages) {
        this.avatarImages = avatarImages.stream()
                .map(Objects.requireNonNull(getCreator())::create)
                .toList();
    }

}