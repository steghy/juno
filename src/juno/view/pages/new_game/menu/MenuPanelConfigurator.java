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

package juno.view.pages.new_game.menu;

import juno.controller.audio.SoundAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.new_game.card.NewGameCardPanel;
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

    /** Configures the MenuPanel instance. */
    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton singlePlayer = creator.create(Button.SINGLE_PLAYER, null);
        AbstractButton multiPlayer = creator.create(Button.MULTIPLAYER, null);
        AbstractButton backButton = creator.create(Button.BACK, null);

        // Images resizing.
        ImageResizer.resize(singlePlayer, 2.5);
        ImageResizer.resize(multiPlayer, 2.5);
        ImageResizer.resize(backButton, 2.5);

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Action listeners.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();
        singlePlayer.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(NewGameCardPanel.getInstance(), NewGameCardPanel.SINGLE_PLAYER_PANEL))));
        multiPlayer.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(NewGameCardPanel.getInstance(), NewGameCardPanel.MULTIPLAYER_PANEL))));
        backButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL))));

        // Components settings.
        menuPanel.setFirstComponent(singlePlayer);    // Single-player button.
        menuPanel.setSecondComponent(multiPlayer);    // Multiplayer button.
        menuPanel.setThirdComponent(backButton);      // Back button.

        // Main component initialization.
        menuPanel.init();
    }

}