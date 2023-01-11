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

package juno.view.pages.new_game.single_player.difficulty.menu;

import juno.controller.audio.SoundAction;
import juno.controller.new_game.game_settings.DifficultySetter;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.controller.util.SetterAction;
import juno.model.sound.ButtonSoundPlayer;
import juno.model.subjects.ai.Difficulty;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This class describers a configurator.
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    /** Configures the MenuPanel instance */
    public static void configure() {
        // Main components.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton easyDifficultyButton   = creator.create(Button.EASY, null);
        AbstractButton mediumDifficultyButton = creator.create(Button.MEDIUM, null);
        AbstractButton hardDifficultyButton   = creator.create(Button.HARD, null);
        AbstractButton backButton   = creator.create(Button.BACK, null);

        // Images resizing.
        ImageResizer resizer = ImageResizer.getInstance();
        resizer.resize(easyDifficultyButton, 2.5);
        resizer.resize(mediumDifficultyButton, 2.5);
        resizer.resize(hardDifficultyButton, 2.5);
        resizer.resize(backButton, 2.5);

        // Action listeners.
        // Change panel actions.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();
        easyDifficultyButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL))));
        mediumDifficultyButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL))));
        hardDifficultyButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL))));
        backButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.PLAYERS_NUMBER_PANEL))));

        // Difficulty actions.
        DifficultySetter difficultySetter = DifficultySetter.getInstance();
        easyDifficultyButton.addActionListener(new SetterAction<>(Difficulty.EASY, difficultySetter));
        mediumDifficultyButton.addActionListener(new SetterAction<>(Difficulty.MEDIUM, difficultySetter));
        hardDifficultyButton.addActionListener(new SetterAction<>(Difficulty.HARD, difficultySetter));

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.GREEN);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Setting components.
        menuPanel.setFirstComponent(easyDifficultyButton);    // Easy difficulty button.
        menuPanel.setSecondComponent(mediumDifficultyButton); // Medium difficulty button.
        menuPanel.setThirdComponent(hardDifficultyButton);    // Hard difficulty button.
        menuPanel.setFourthComponent(backButton);   // Back button.

        // Main component initialization.
        menuPanel.init();
    }

}