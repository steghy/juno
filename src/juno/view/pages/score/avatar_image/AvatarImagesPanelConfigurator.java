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

package juno.view.pages.score.avatar_image;

import juno.controller.util.SetterAction;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.view.gobject.avatars.GAvatarImage;
import juno.view.gobject.avatars.GAvatarImageFactory;

import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarImagesPanelConfigurator {

    // Builds a AvatarFramesPanelConfigurator object.
    private AvatarImagesPanelConfigurator() {}

    public static void configure() {
        // Main Component.
        AvatarImagesPanel avatarImagesPanel = AvatarImagesPanel.getInstance();

        // Component.
        GAvatarImageFactory gAvatarImageFactory = GAvatarImageFactory.getInstance();

        // Adding graphic avatar frames.
        // Generation.
        gAvatarImageFactory.generate(List.of(AvatarImage.values()));
        // Getting.
        Objects.requireNonNull(gAvatarImageFactory.getGObjects())
                .forEach(temp -> {
                    GAvatarImage<InterfaceAvatarImage> gAvatarImage = (GAvatarImage<InterfaceAvatarImage>) temp;
                    gAvatarImage.addActionListener(new SetterAction<>(gAvatarImage, AvatarImageSetter.getInstance()));
                    gAvatarImage.setEnabled(false);
                    AvatarImage.valueOf(gAvatarImage.getObject().name()).addObserver(gAvatarImage);
                    avatarImagesPanel.addAvatarImage(gAvatarImage);
                });

        // Main component initialization.
        avatarImagesPanel.init();
    }

}