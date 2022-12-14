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

package juno.view.avatar;

import juno.model.data.avatar.InterfaceAvatarImageProvider;
import juno.model.data.avatar.InterfaceAvatarImageSetter;
import juno.model.util.Observer;
import juno.view.awards.avatars.GAvatarImage;
import juno.view.awards.avatars.factory.InterfaceGAvatarImageCreator;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarImagePanel<T>
        extends AbstractAvatarImagePanel<T>
        implements Observer {

    // The graphic avatar image creator.
    private final InterfaceGAvatarImageCreator<T> creator;

    // The avatar image provider.
    private final InterfaceAvatarImageProvider<T> provider;

    /**
     * Builds an AvatarImagePanel with the specified
     * graphic avatar image creator and avatar image
     * provider objects.
     * @param creator An InterfaceGAvatarImageCreator object.
     * @param provider An InterfaceAvatarImageProvider object.
     */
    public AvatarImagePanel(@NotNull InterfaceGAvatarImageCreator<T> creator,
                            @NotNull InterfaceAvatarImageProvider<T> provider) {
        this.creator = creator;
        this.provider = provider;
    }

    public void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
        add(Objects.requireNonNull(getAvatarImage()), BorderLayout.CENTER);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAvatarImageSetter<?>) {
            GAvatarImage<T> providerAvatarImage = (GAvatarImage<T>) creator.create(provider.avatarImage());
            Objects.requireNonNull(getAvatarImage()).setIcon(providerAvatarImage.getIcon());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceAvatarImageSetter type expected.");
    }

}