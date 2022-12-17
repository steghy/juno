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
import juno.view.util.ImageButton;
import juno.view.util.ImageLabel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class AvatarPanel
        extends JPanel
        implements Observer {

    // The avatar image label.
    private final ImageLabel avatarImage;

    // The avatar frame label.
    private final ImageLabel avatarFrame;

    // The avatar name label.
    private final JLabel avatarName;

    // The dimension parameter.
    private final double dimensionParameter;

    /**
     * Builds an AvatarPanel with the specified
     * dimension parameter.
     * @param dimensionParameter A double value.
     */
    public AvatarPanel(double dimensionParameter) {
        this.dimensionParameter = dimensionParameter;
        avatarImage = new ImageLabel();
        avatarFrame = new ImageLabel();
        avatarName = new JLabel();
        // Observer / Observable connections.
        AvatarFrameSetter.getInstance().addObserver(this);
        AvatarImageSetter.getInstance().addObserver(this);
        AvatarNameSetter.getInstance().addObserver(this);
        init();
    }

    public void init() {
        setOpaque(false);
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        avatarImage.setOpaque(false);
        avatarFrame.setOpaque(false);
        avatarName.setOpaque(false);

        avatarFrame.setLayout(new BorderLayout());

        // Avatar image.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        panel.add(avatarImage, gbc);

        // Avatar name.
        avatarName.setFont(new Font(Font.DIALOG, Font.ITALIC, 12));
        avatarName.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        panel.add(avatarName, gbc);

        avatarFrame.add(panel, BorderLayout.CENTER);
        add(avatarFrame, BorderLayout.CENTER);
    }

    @Override
    public void update(Object object) {
        // Avatar image case.
        if(object instanceof InterfaceAvatarImageSetter<?>) {
            GAvatarImage<InterfaceAvatarImage> avatarImage = (GAvatarImage<InterfaceAvatarImage>) GAvatarImageCreator.getInstance().create(AvatarImageProvider.getInstance().avatarImage());
            ImageResizer.resize(avatarImage, dimensionParameter * 2);
            this.avatarImage.setIcon(avatarImage.getIcon());
        }

        // Avatar frame case.
        else if(object instanceof InterfaceAvatarFrameSetter<?>) {
            GFrame<InterfaceAvatarFrame> avatarFrame = (GFrame<InterfaceAvatarFrame>) GFrameCreator.getInstance().create(AvatarFrameProvider.getInstance().frame());
            ImageResizer.resize(avatarFrame, dimensionParameter);
            this.avatarFrame.setIcon(avatarFrame.getIcon());
        }

        // Avatar name case.
        else if(object instanceof InterfaceAvatarNameSetter) {
            this.avatarName.setText(AvatarNameProvider.getInstance().name());
        } else throw new IllegalArgumentException();
    }

}