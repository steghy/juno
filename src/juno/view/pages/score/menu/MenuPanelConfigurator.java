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

package juno.view.pages.score.menu;

import juno.controller.util.ChangePanelAction;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.score.avatar_frame.AvatarFramesPanel;
import juno.view.pages.score.avatar_image.AvatarImagesPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds the MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        AvatarFramesPanel avatarFramesPanel = AvatarFramesPanel.getInstance();
        AvatarImagesPanel avatarImagesPanel = AvatarImagesPanel.getInstance();
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // Images resizing.
        ImageResizer.resize(backButton, 3.0);

        // Components settings.
        menuPanel.setFirstComponent(avatarFramesPanel);       // Avatar frames panel.
        menuPanel.setSecondComponent(avatarImagesPanel);      // Avatar images panel.
        menuPanel.setThirdComponent(backButton);              // Back button.

        // Action listeners.
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL));

        // Border settings
        RoundedBorder insideBorder = new RoundedBorder(
                50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}