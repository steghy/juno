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

import juno.model.data.avatar.AvatarFrameSetter;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.avatar.AvatarNameSetter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class AvatarPanelConfigurator {

    // Builds an AvatarPanelConfigurator object.
    private AvatarPanelConfigurator() {}

    /**
     * Configures the specified avatar panel object.
     * @param avatarPanel An AvatarPanel object.
     */
    public static void configure(@NotNull AvatarPanel avatarPanel) {
        // Avatar name component.
        JLabel avatarName = new JLabel();
        avatarName.setFont(new Font(Font.DIALOG, Font.ITALIC, 12));
        avatarName.setForeground(Color.WHITE);
        avatarName.setText(DefaultAvatarNameProvider.getInstance().avatarName());

        // Main component connections.
        avatarPanel.setAvatarFrame(DefaultAvatarFrameProvider.getInstance().getDefaultAvatarFrame());
        avatarPanel.setAvatarImage(DefaultAvatarImageProvider.getInstance().getDefaultAvatarImage());
        avatarPanel.setAvatarName(avatarName);

        // Observer / Observable connections.
        AvatarFrameSetter.getInstance().addObserver(avatarPanel);
        AvatarImageSetter.getInstance().addObserver(avatarPanel);
        AvatarNameSetter.getInstance().addObserver(avatarPanel);

        // Main component initialization.
        avatarPanel.init();
    }

}