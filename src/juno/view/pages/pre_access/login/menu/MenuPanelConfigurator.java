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

package juno.view.pages.pre_access.login.menu;

import juno.controller.util.ChangePanelAction;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.pages.pre_access.login.profiles_panel.ProfilesPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton backButton = creator.create(Button.BACK);

        // Image resizing.
        ImageResizer.resize(backButton, 3.5);

        // Action listener.
        backButton.addActionListener(new ChangePanelAction(
                PreAccessCardPanel.getInstance(),
                PreAccessCardPanel.ACCESS_PANEL));

        // Components setting.
        JScrollPane profilesPanel = new JScrollPane(ProfilesPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        profilesPanel.setPreferredSize(new Dimension(200, 500));
        profilesPanel.setIgnoreRepaint(true);
        profilesPanel.setMinimumSize(new Dimension(200, 500));
        profilesPanel.getViewport().setOpaque(false);
        profilesPanel.setOpaque(false);
        menuPanel.setFirstComponent(profilesPanel); // Profiles panel.
        menuPanel.setSecondComponent(backButton); // Back button.

        // Main component initialization.
        menuPanel.init();
    }

}