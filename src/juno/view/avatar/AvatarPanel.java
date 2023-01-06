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
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class AvatarPanel
        extends JPanel {

    // The avatar image.
    private JButton avatarImage;

    // The avatar name.
    private JLabel avatarName;

    /**
     * Builds an AvatarPanel.
     */
    public AvatarPanel() {
        avatarImage = new JButton ();
        avatarName = new JLabel();
        init();
    }

    /** Initialize this AvatarPanel object */
    public void init() {
        removeAll();
        setOpaque(false);
        setLayout(new GridBagLayout());
        avatarName.setOpaque(false);
        avatarImage.setOpaque(false);
        avatarImage.setContentAreaFilled(false);
        avatarImage.setBorderPainted(false);
        GridBagConstraints gbc = new GridBagConstraints();

        // Avatar image.
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(avatarImage, gbc);

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
        revalidate();
        repaint();
    }

    /**
     * Sets the avatar image of this object.
     * @param avatarImage An ImageButton object.
     */
    public void setAvatarImage(@NotNull JButton avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     * Sets the avatar name of this object.
     * @param avatarName A JLabel object.
     */
    public void setAvatarName(@NotNull JLabel avatarName) {
        this.avatarName = avatarName;
    }

    /**
     * Returns the avatar image of this object.
     * @return A JButton instance.
     */
    @Nullable
    public JButton getAvatarImage() {
        return avatarImage;
    }

    /**
     * Returns the avatar name of this object.
     * @return A JLabel object.
     */
    @Nullable
    public JLabel getAvatarName() {
        return avatarName;
    }

}