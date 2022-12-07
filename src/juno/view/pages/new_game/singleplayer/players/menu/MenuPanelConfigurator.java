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

package juno.view.pages.new_game.singleplayer.players.menu;

import juno.controller.util.ChangePanelAction;
import juno.controller.new_game.PlayersNumberAction;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.new_game.card.NewGameCardPanel;
import juno.view.pages.new_game.singleplayer.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        MenuPanel menuPanel = MenuPanel.getInstance();

        // SUB COMPONENTS
        AbstractButton twoPlayers = ButtonFactory.createButton(ButtonLibrary.TWO_PLAYERS);
        AbstractButton threePlayers = ButtonFactory.createButton(ButtonLibrary.THREE_PLAYERS);
        AbstractButton fourPlayers = ButtonFactory.createButton(ButtonLibrary.FOUR_PLAYERS);
        AbstractButton backButton = ButtonFactory.createButton(ButtonLibrary.BACK);

        // RESIZE IMAGES
        ImageResizer.resize(twoPlayers, 3.0);
        ImageResizer.resize(threePlayers, 3.0);
        ImageResizer.resize(fourPlayers, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // Action listeners.
        // Change panel actions.
        twoPlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        threePlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        fourPlayers.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        backButton.addActionListener(new ChangePanelAction(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // Difficulty actions.
        twoPlayers.addActionListener(new PlayersNumberAction(2));
        threePlayers.addActionListener(new PlayersNumberAction(3));
        fourPlayers.addActionListener(new PlayersNumberAction(4));

        // BORDER SETTING
        RoundedBorder insideBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        menuPanel.setBorder(border);

        // ADDING COMPONENTS
        menuPanel.setTwoPlayers(twoPlayers);
        menuPanel.setThreePlayers(threePlayers);
        menuPanel.setFourPlayers(fourPlayers);
        menuPanel.setBackButton(backButton);

        // INITIALIZATION
        menuPanel.init();
    }
}