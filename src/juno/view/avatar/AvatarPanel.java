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

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarPanel
        extends JPanel {

    // The avatar model object.
    private final InterfaceAvatarModel avatarModel;

    /**
     * Builds an AvatarPanel object with the specified
     * avatar model object.
     * @param avatarModel An InterfaceAvatarModel object.
     */
    public AvatarPanel(@NotNull InterfaceAvatarModel avatarModel) {
        this.avatarModel = avatarModel;
        init();
    }

    /** Initialize this AvatarPanel object. */
    private void init() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        JLabel avatarFrame = avatarModel.getAvatarFrameImageLabel();

        avatarFrame.setLayout(new GridBagLayout()); GridBagConstraints gbc = new GridBagConstraints();

        // Avatar image label.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,10,0);
        avatarFrame.add(Objects.requireNonNull(avatarModel.getAvatarImageLabel()), gbc);

        // Avatar profile name label.
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,10,0);
        avatarFrame.add(Objects.requireNonNull(avatarModel.getAvatarProfileNameLabel()), gbc);

        // Avatar frame label.
        add(avatarFrame, BorderLayout.CENTER);
    }

}