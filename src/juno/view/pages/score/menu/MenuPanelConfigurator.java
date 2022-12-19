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
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.score.avatar_frames_panel.AvatarFramesPanel;
import juno.view.pages.score.avatar_frames_panel.AvatarFramesPanelConfigurator;
import juno.view.pages.score.avatar_images_panel.AvatarImagesPanel;
import juno.view.pages.score.avatar_images_panel.AvatarImagesPanelConfigurator;
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
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton backButton = creator.create(Button.BACK);

        // Images resizing.
        ImageResizer.resize(backButton, 3.5);

        // Components settings.
        // AvatarFramesPanel.
        JScrollPane avatarFramesPanel = new JScrollPane(AvatarFramesPanel.getInstance() ,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        avatarFramesPanel.setPreferredSize(new Dimension(750, 125));
        avatarFramesPanel.setIgnoreRepaint(true);
        avatarFramesPanel.setMinimumSize(new Dimension(500, 125));
        avatarFramesPanel.getViewport().setOpaque(false);
        avatarFramesPanel.setOpaque(false);

        // AvatarImagePanel.
        JScrollPane avatarImagesPanel = new JScrollPane(AvatarImagesPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        avatarImagesPanel.setPreferredSize(new Dimension(750, 125));
        avatarImagesPanel.setIgnoreRepaint(true);
        avatarImagesPanel.setMinimumSize(new Dimension(500, 125));
        avatarImagesPanel.getViewport().setOpaque(false);
        avatarImagesPanel.setOpaque(false);

        menuPanel.setFirstComponent(avatarFramesPanel);       // Avatar frames panel.
        menuPanel.setSecondComponent(avatarImagesPanel);      // Avatar images panel.
        menuPanel.setThirdComponent(backButton);              // Back button.

        // Action listeners.
        backButton.addActionListener(new ChangePanelAction(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL));

        // Border settings
        RoundedBorder insideBorder = new RoundedBorder(
                15, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // AvatarFramesPanel configuration.
        AvatarFramesPanelConfigurator.configure();

        // AvatarImagesPanel configuration.
        AvatarImagesPanelConfigurator.configure();

        // Main component initialization.
        menuPanel.init();
    }

}