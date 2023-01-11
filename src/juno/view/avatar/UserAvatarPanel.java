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

import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.model.util.Provider;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.gobject.avatars.GAvatarImage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * This class defines the user avatar panel.
 * @author Simone Gentili
 * @param <T> The type of the avatar image.
 */
public class UserAvatarPanel<T>
        extends AvatarPanel
        implements Observer {

    // The avatar image setter.
    private final Observable avatarImageSetter;

    // The avatar name setter.
    private final Observable avatarNameSetter;

    // The graphic avatar image creator.
    private final InterfaceGObjectCreator<T> creator;

    // The avatar image provider.
    private final Provider<T> imageProvider;

    // The avatar name provider.
    private final Provider<String> nameProvider;

    /**
     * Builds a UserAvatarPanel with the specified parameters.
     * @param avatarNameSetter An Observable object.
     * @param avatarImageSetter An Observable object.
     * @param creator An InterfaceGObjectCreator object.
     * @param imageProvider A Provider object.
     * @param nameProvider A Provider object.
     */
    public UserAvatarPanel(@NotNull Observable avatarNameSetter,
                           @NotNull Observable avatarImageSetter,
                           @NotNull InterfaceGObjectCreator<T> creator,
                           @NotNull Provider<T> imageProvider,
                           @NotNull Provider<String> nameProvider) {
        super();
        // Avatar setters.
        this.avatarNameSetter = avatarNameSetter;
        this.avatarImageSetter = avatarImageSetter;
        this.avatarNameSetter.addObserver(this);
        this.avatarImageSetter.addObserver(this);
        // Creator.
        this.creator = creator;
        // Providers.
        this.imageProvider = imageProvider;
        this.nameProvider = nameProvider;
        super.init();
    }

    @Override
    public void update(Object object) {
        // Avatar image case.
        if(object == avatarImageSetter) {
            GAvatarImage<InterfaceAvatarImage> gAvatarImage =
                    (GAvatarImage<InterfaceAvatarImage>)
                    creator.create(imageProvider.provide(), null);
            setAvatarImage(gAvatarImage);
        }

        // Avatar name case.
        else if(object == avatarNameSetter) {
            setAvatarName(new JLabel(nameProvider.provide()));
        }

        // Invalid case.
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". AvatarImageSetter, AvatarFrameSetter or " +
                        "AvatarNameSetter type expected.");
        init();
        revalidate();
        repaint();
    }

}