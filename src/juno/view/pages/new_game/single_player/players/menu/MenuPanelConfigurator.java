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

package juno.view.pages.new_game.single_player.players.menu;

import juno.controller.new_game.PlayersSetter;
import juno.controller.util.ChangePanelAction;
import juno.controller.new_game.PlayersAction;
import juno.view.factories.ButtonCreator;
import juno.view.factories.Button;
import juno.view.pages.new_game.card.NewGameCardPanel;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
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
        AbstractButton twoPlayers = creator.create(Button.TWO_PLAYERS);
        AbstractButton threePlayers = creator.create(Button.THREE_PLAYERS);
        AbstractButton fourPlayers = creator.create(Button.FOUR_PLAYERS);
        AbstractButton backButton = creator.create(Button.BACK);

        // Images resizing.
        ImageResizer.resize(twoPlayers, 3.0);
        ImageResizer.resize(threePlayers, 3.0);
        ImageResizer.resize(fourPlayers, 3.0);
        ImageResizer.resize(backButton, 3.0);

        // Action listeners.
        // Change panel actions.
        twoPlayers.addActionListener(new ChangePanelAction(
                SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        threePlayers.addActionListener(new ChangePanelAction(
                SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        fourPlayers.addActionListener(new ChangePanelAction(
                SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL));
        backButton.addActionListener(new ChangePanelAction(
                NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL));

        // Difficulty actions.
        PlayersSetter playersSetter = PlayersSetter.getInstance();
        twoPlayers.addActionListener(new PlayersAction(2, playersSetter));
        threePlayers.addActionListener(new PlayersAction(3, playersSetter));
        fourPlayers.addActionListener(new PlayersAction(4, playersSetter));

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(
                50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        menuPanel.setBorder(border);

        // Components settings.
        menuPanel.setFirstComponent(twoPlayers);    // Two players button.
        menuPanel.setSecondComponent(threePlayers); // Three players button.
        menuPanel.setThirdComponent(fourPlayers);   // Four players button.
        menuPanel.setFourthComponent(backButton);   // Back button.

        // Main components initialization.
        menuPanel.init();
    }

}