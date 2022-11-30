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

package juno.view.pages.new_game.multiplayer.unavailable.menu;

import juno.controller.ChangePanelAction;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.new_game.card.NewGameCardPanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB COMPONENT
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);
        JLabel unavailableServiceLabel = new JLabel();

        // RESIZE IMAGE
        ImageResizer.resize(backButton, 2.0);

        // UNAVAILABLE SERVICE LABEL SETTING
        String unavailableServiceText =
                """
                        We are sorry to inform you that unfortunately\s
                        this mode is not yet available, however if you\s
                        want to contribute to the development of this video game,\s
                        please visit the site 'site here'.""";
        unavailableServiceLabel.setText(unavailableServiceText);
        unavailableServiceLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        unavailableServiceLabel.setForeground(Color.WHITE);

        // ADDING COMPONENTS
        menuPanel.setUnavailableServiceLabel(unavailableServiceLabel);
        menuPanel.setBackButton(backButton);

        // ACTION LISTENERS
        backButton.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // MAIN COMPONENT INITIALIZATION
        menuPanel.init();
    }
}