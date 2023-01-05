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

package juno.view.pages.new_game.single_player.winner;

import juno.controller.audio.SoundAction;
import juno.controller.new_game.GameInitializer;
import juno.controller.new_game.controller.WinnerManager;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.InitializeAction;
import juno.controller.util.PanelChanger;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.new_game.card.NewGameCardPanel;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * @author Simone Gentili
 */
public class WinnerPanelConfigurator {

    // Builds a WinnerPanelConfigurator object.
    private WinnerPanelConfigurator() {}

    /** Configures the WinnerPanel instance. */
    public static void configure() {
        // Component.
        WinnerPanel winnerPanel = WinnerPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton exitButton = creator.create(Button.EXIT, null);
        AbstractButton restartButton = creator.create(Button.RESTART, null);
        AbstractButton winnerButton = creator.create(Button.WINNER, null);
        WinnerAvatarPanel winnerAvatarPanel = WinnerAvatarPanel.getInstance();

        // Image resizing.
        ImageResizer.resize(exitButton, 2.8);
        ImageResizer.resize(restartButton, 2.8);
        ImageResizer.resize(winnerButton, 2.8);

        // Action listeners.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();

        // Exit button.
        exitButton.addActionListener(new SoundAction(buttonSoundPlayer,
                new ChangePanelAction(
                        new PanelChanger(SinglePlayerCardPanel.getInstance(),
                                SinglePlayerCardPanel.MODE_PANEL))));
        exitButton.addActionListener(new ChangePanelAction(
                        new PanelChanger(NewGameCardPanel.getInstance(),
                                NewGameCardPanel.SINGLE_PLAYER_PANEL)));
        exitButton.addActionListener(new ChangePanelAction(
                new PanelChanger(MainCardPanel.getInstance(),
                        MainCardPanel.MAIN_PANEL)));

        // Restart button.
        restartButton.addActionListener(new SoundAction(buttonSoundPlayer,
                new InitializeAction(GameInitializer.getInstance())));
        restartButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(),
                        SinglePlayerCardPanel.MATCH_PANEL)));

        // Winner avatar panel Observer connection.
        WinnerManager.getInstance().addObserver(winnerAvatarPanel);

        // Component settings.
        winnerPanel.setFirstComponent(winnerButton);
        winnerPanel.setSecondComponent(winnerAvatarPanel);
        winnerPanel.setThirdComponent(exitButton);
        winnerPanel.setFourthComponent(restartButton);

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.GREEN);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        winnerAvatarPanel.setBorder(border);

        // Main component initialization.
        winnerPanel.init();
    }

}