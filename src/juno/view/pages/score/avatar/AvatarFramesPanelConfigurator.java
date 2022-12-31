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

package juno.view.pages.score.avatar;

import juno.controller.util.GSetterAction;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.awards.frame.AvatarFrame;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.view.gobject.frames.GAvatarFrame;
import juno.view.gobject.frames.GAvatarFrameCreator;
import juno.view.util.ImageResizer;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class AvatarFramesPanelConfigurator {

    // Builds a AvatarFramesPanelConfigurator object.
    private AvatarFramesPanelConfigurator() {}

    public static void configure(AvatarAwardPanel panel) {
        // Creator.
        GAvatarFrameCreator creator = GAvatarFrameCreator.getInstance();
        AvatarFrameSetter avatarFrameSetter = AvatarFrameSetter.getInstance();
        List.of(AvatarFrame.values()).forEach(frame -> {
                    GAvatarFrame<InterfaceAvatarFrame> gAvatarFrame =
                            (GAvatarFrame<InterfaceAvatarFrame>) creator.create(frame, null);
                    gAvatarFrame.addActionListener(new GSetterAction<>(gAvatarFrame, avatarFrameSetter));
                    gAvatarFrame.setEnabled(false);
                    frame.addObserver(gAvatarFrame);
                    ImageResizer.resize(gAvatarFrame, 6.5);
                    panel.addComponent(gAvatarFrame);
                });
    }

}