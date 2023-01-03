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

import juno.model.data.avatar.Avatar;
import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.avatar.AvatarNameSetter;
import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.util.Observer;
import juno.view.gobject.avatars.GAvatarImage;
import juno.view.gobject.avatars.GAvatarImageCreator;
import juno.view.gobject.frames.GAvatarFrame;
import juno.view.gobject.frames.GAvatarFrameCreator;
import juno.view.util.ImageResizer;

import javax.swing.*;

public class UserAvatarPanel
        extends AvatarPanel implements Observer {

    /**
     * Builds an AvatarPanel with the specified
     * dimension parameter.
     *
     * @param dimensionParameter A double value.
     */
    public UserAvatarPanel(double dimensionParameter) {
        super(dimensionParameter);
        AvatarNameSetter.getInstance().addObserver(this);
        AvatarImageSetter.getInstance().addObserver(this);
        AvatarFrameSetter.getInstance().addObserver(this);
        super.init();
    }

    @Override
    public void update(Object object) {
        Avatar avatar = Avatar.getInstance();
        // Avatar image case.
        if(object instanceof AvatarImageSetter) {
            GAvatarImage<InterfaceAvatarImage> gAvatarImage =
                    (GAvatarImage<InterfaceAvatarImage>) GAvatarImageCreator.getInstance()
                            .create(avatar.getAvatarImage(), null);
            ImageResizer.resize(gAvatarImage, getDimensionParameter() * 2);
            setAvatarImage(gAvatarImage);
        }

        // Avatar frame case.
        else if(object instanceof AvatarFrameSetter) {
            GAvatarFrame<InterfaceAvatarFrame> avatarFrame =
                    (GAvatarFrame<InterfaceAvatarFrame>) GAvatarFrameCreator.getInstance()
                            .create(avatar.getAvatarFrame(), null);
            ImageResizer.resize(avatarFrame, getDimensionParameter());
            setAvatarFrame(avatarFrame);
        }

        // Avatar name case.
        else if(object instanceof AvatarNameSetter) {
            setAvatarName(new JLabel(avatar.getAvatarName()));
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". AvatarImageSetter, AvatarFrameSetter or " +
                        "AvatarNameSetter type expected.");
        init();
        revalidate();
        repaint();
    }

}