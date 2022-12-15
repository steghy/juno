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

import juno.model.data.avatar.*;
import juno.model.data.awards.avatar.InterfaceAvatarImage;
import juno.model.data.awards.frame.InterfaceAvatarFrame;
import juno.model.util.Observer;
import juno.view.awards.avatars.GAvatarImage;
import juno.view.awards.avatars.factory.GAvatarImageCreator;
import juno.view.awards.frames.GFrame;
import juno.view.awards.frames.factory.GFrameCreator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarPanel
        extends AbstractAvatarPanel<InterfaceAvatarImage, InterfaceAvatarFrame>
        implements Observer {

    // The dimension parameter.
    private final double dimensionParameter;

    /**
     * Builds an AvatarPanel with the specified
     * dimension parameter.
     * @param dimensionParameter A double value.
     */
    public AvatarPanel(double dimensionParameter) {
        this.dimensionParameter = dimensionParameter;
    }

    public void init() {
        this.setOpaque(false);
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Avatar image.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        panel.add(Objects.requireNonNull(getAvatarImage()), gbc);
        ImageResizer.resize(getAvatarImage(), dimensionParameter * 2);

        // Avatar name.
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        panel.add(Objects.requireNonNull(getAvatarName()), gbc);

        Objects.requireNonNull(getAvatarFrame()).setLayout(new BorderLayout());
        getAvatarFrame().add(panel, BorderLayout.CENTER);

        // Avatar frame.
        add(getAvatarFrame());
        ImageResizer.resize(getAvatarFrame(), dimensionParameter);
    }


    @Override
    public void update(Object object) {
        // Avatar image case.
        if(object instanceof InterfaceAvatarImageSetter<?>) {
            GAvatarImage<InterfaceAvatarImage> avatarImage = (GAvatarImage<InterfaceAvatarImage>) GAvatarImageCreator.getInstance().create(AvatarImageProvider.getInstance().avatarImage());
            ImageResizer.resize(avatarImage, dimensionParameter * 2);
            Objects.requireNonNull(getAvatarImage()).setIcon(avatarImage.getIcon());
        }

        // Avatar frame case.
        else if(object instanceof InterfaceAvatarFrameSetter<?>) {
            GFrame<InterfaceAvatarFrame> avatarFrame = (GFrame<InterfaceAvatarFrame>) GFrameCreator.getInstance().create(AvatarFrameProvider.getInstance().frame());
            ImageResizer.resize(avatarFrame, dimensionParameter);
            Objects.requireNonNull(getAvatarFrame()).setIcon(avatarFrame.getIcon());
        }

        // Avatar name case.
        else if(object instanceof InterfaceAvatarNameSetter) {
            Objects.requireNonNull(getAvatarName()).setText(AvatarNameProvider.getInstance().name());
        } else throw new IllegalArgumentException();
    }

}