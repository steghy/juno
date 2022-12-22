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

import juno.controller.new_game.DifficultySetter;
import juno.controller.util.ChangePanelAction;
import juno.controller.new_game.DifficultyAction;
import juno.controller.util.PanelChanger;
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
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    public static void configure() {
        // Main components.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton easyDifficultyButton   = creator.create(Button.EASY);
        AbstractButton mediumDifficultyButton = creator.create(Button.MEDIUM);
        AbstractButton hardDifficultyButton   = creator.create(Button.HARD);
        AbstractButton backButton   = creator.create(Button.BACK);
        AbstractButton startButton  = creator.create(Button.BACK);

        // Images resizing.
        ImageResizer.resize(easyDifficultyButton, 4.0);
        ImageResizer.resize(mediumDifficultyButton, 4.0);
        ImageResizer.resize(hardDifficultyButton, 4.0);
        ImageResizer.resize(backButton, 4.0);
        ImageResizer.resize(startButton, 4.0);

        // Action listeners.
        // Change panel actions.
        easyDifficultyButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL)));
        mediumDifficultyButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL)));
        hardDifficultyButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL)));
        backButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.PLAYERS_NUMBER_PANEL)));

        // Difficulty actions.
        DifficultySetter difficultySetter = DifficultySetter.getInstance();
        easyDifficultyButton.addActionListener(new DifficultyAction<>(Difficulty.EASY, difficultySetter));
        mediumDifficultyButton.addActionListener(new DifficultyAction<>(Difficulty.MEDIUM, difficultySetter));
        hardDifficultyButton.addActionListener(new DifficultyAction<>(Difficulty.HARD, difficultySetter));


        // Inside Border.
        RoundedBorder insideBorder = new RoundedBorder(
                50, 2, null, Color.WHITE);
        // Outside Border.
        RoundedBorder outsideBorder = new RoundedBorder(
                50, 2, null, Color.RED);
        // Composed Border.
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        menuPanel.setBorder(border);

        // Setting components.
        menuPanel.setFirstComponent(easyDifficultyButton);    // Easy difficulty button.
        menuPanel.setSecondComponent(mediumDifficultyButton); // Medium difficulty button.
        menuPanel.setThirdComponent(hardDifficultyButton);    // Hard difficulty button.
        menuPanel.setFourthComponent(backButton);   // Back button.
        menuPanel.setFifthComponent(startButton);   // Start button.

        // Main component initialization.
        menuPanel.init();
    }

}