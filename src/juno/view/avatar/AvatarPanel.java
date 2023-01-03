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

import juno.view.util.ImageButton;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class AvatarPanel
        extends JPanel {

    // The dimension parameter.
    private final double dimensionParameter;

    // The avatar image.
    private ImageButton avatarImage;

    // The avatar frame.
    private ImageButton avatarFrame;

    // The avatar name.
    private JLabel avatarName;

    /**
     * Builds an AvatarPanel.
     */
    public AvatarPanel(double dimensionParameter) {
        this.dimensionParameter = dimensionParameter;
        avatarFrame = new ImageButton();
        avatarImage = new ImageButton();
        avatarName = new JLabel();
        init();
    }

    /**
     * Builds an AvatarPanel with the specified
     * avatar frame, avatar image and avatar name
     * objects.
     * @param avatarImage An ImageLabel object.
     * @param avatarFrame An ImageLabel object.
     * @param avatarName A JLabel object.
     */
    public AvatarPanel(@NotNull ImageButton avatarImage,
                       @NotNull ImageButton avatarFrame,
                       @NotNull JLabel avatarName,
                       double dimensionParameter) {
        this.dimensionParameter = dimensionParameter;
        this.avatarFrame = avatarFrame;
        this.avatarImage = avatarImage;
        this.avatarName = avatarName;
    }

    /** Initialize this AvatarPanel object */
    public void init() {
        removeAll();
        avatarFrame.removeAll();
        setOpaque(false);
        setLayout(new GridBagLayout());
        avatarImage.setOpaque(false);
        avatarFrame.setOpaque(false);
        avatarName.setOpaque(false);
        avatarFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Avatar image in avatar frame.
        avatarFrame.add(avatarImage, gbc);

        // Avatar frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(avatarFrame, gbc);

        // Avatar name.
        avatarName.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        avatarName.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,0,0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(avatarName, gbc);
    }

    /**
     * Sets the avatar frame of this object.
     * @param avatarFrame An ImageButton object.
     */
    public void setAvatarFrame(@NotNull ImageButton avatarFrame) {
        ImageResizer.resize(avatarFrame, dimensionParameter);
        this.avatarFrame = avatarFrame;
    }

    /**
     * Sets the avatar image of this object.
     * @param avatarImage An ImageButton object.
     */
    public void setAvatarImage(@NotNull ImageButton avatarImage) {
        ImageResizer.resize(avatarImage, dimensionParameter * 2);
        this.avatarImage = avatarImage;
    }

    /**
     * Sets the avatar name of this object.
     * @param avatarName A JLabel object.
     */
    public void setAvatarName(@NotNull JLabel avatarName) {
        this.avatarName = avatarName;
    }

}