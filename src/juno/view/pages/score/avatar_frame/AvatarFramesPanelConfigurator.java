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

package juno.view.pages.score.avatar_frame;

import juno.controller.awards.SetterAction;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.awards.frame.AvatarFrame;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.gobject.frames.GAvatarFrame;
import juno.view.gobject.frames.GAvatarFrameFactory;

import java.util.List;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarFramesPanelConfigurator {

    // Builds a AvatarFramesPanelConfigurator object.
    private AvatarFramesPanelConfigurator() {}

    public static void configure() {
        // Main Component.
        AvatarFramesPanel avatarFramesPanel = AvatarFramesPanel.getInstance();

        // Component.
        GAvatarFrameFactory gAvatarFramesFactory = GAvatarFrameFactory.getInstance();

        // Adding graphic avatar frames.
        // Generation.
        gAvatarFramesFactory.generate(List.of(AvatarFrame.values()));
        // Getting.
        Objects.requireNonNull(gAvatarFramesFactory.getGObjects())
                .forEach(temp -> {
                    GAvatarFrame<InterfaceAvatarFrame> gAvatarFrame = (GAvatarFrame<InterfaceAvatarFrame>) temp;
                    gAvatarFrame.addActionListener(new SetterAction<>(gAvatarFrame, AvatarFrameSetter.getInstance()));
                    gAvatarFrame.setEnabled(false);
                    AvatarFrame.valueOf(gAvatarFrame.getObject().name()).addObserver(gAvatarFrame);
                    avatarFramesPanel.addAvatarFrame(gAvatarFrame);
                });

        // Main component initialization.
        avatarFramesPanel.init();
    }

}