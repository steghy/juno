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

package juno.view.pages.main.menu;

import juno.controller.audio.SoundAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.ExitAction;
import juno.controller.util.PanelChanger;
import juno.model.data.io.output.ExitManager;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.main.card.MainCardPanel;
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

        // Components
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton newGameButton = creator.create(Button.NEW_GAME, null);
        AbstractButton optionsButton = creator.create(Button.OPTIONS, null);
        AbstractButton scoreButton = creator.create(Button.SCORE, null);
        AbstractButton exitButton = creator.create(Button.EXIT, null);

        // Images resizing.
        ImageResizer.resize(newGameButton, 2.5);
        ImageResizer.resize(optionsButton, 2.5);
        ImageResizer.resize(scoreButton, 2.5);
        ImageResizer.resize(exitButton, 2.5);

        // Action listeners.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();
        newGameButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                        new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.NEW_GAME_PANEL))));
        scoreButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                        new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.SCORE_PANEL))));
        optionsButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                        new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.OPTIONS_PANEL))));
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // Border setting.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Components settings.
        menuPanel.setFirstComponent(newGameButton);  // New game button.
        menuPanel.setSecondComponent(optionsButton); // Options button.
        menuPanel.setThirdComponent(scoreButton);    // Score button
        menuPanel.setFourthComponent(exitButton);    // Exit button.

        // Main component initialization.
        menuPanel.init();
    }

}