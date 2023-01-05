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

package juno.view.pages.new_game.single_player.mode.menu;

import juno.controller.audio.SoundAction;
import juno.controller.new_game.GameInitializer;
import juno.controller.util.InitializeAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.init.ProgramDirectory;
import juno.model.requester.PathProviderAssembler;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.img_initializer.ImageComponentInitializer;
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

    /** Configures the DifficultyPanel instance. */
    public static void configure() {
        // Main component.
        MenuPanel difficultyPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton classicModeButton = creator.create(Button.CLASSIC, null);
        JLabel classicModeArtwork = new JLabel();
        ImageComponentInitializer.getInstance().initialize(classicModeArtwork,
                PathProviderAssembler.getInstance().assemble(ProgramDirectory.GIFS, "skeleton.gif"),
                null);
        AbstractButton backButton = creator.create(Button.BACK, null);

        // Images resizing.
        ImageResizer.resize(classicModeButton, 2.5);
        ImageResizer.resize(backButton, 2.5);

        // Action listeners.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();
        classicModeButton.addActionListener(new SoundAction(buttonSoundPlayer,
                new InitializeAction(GameInitializer.getInstance())));
        classicModeButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(),
                        SinglePlayerCardPanel.MATCH_PANEL)));
        backButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.DIFFICULTY_PANEL))));

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        difficultyPanel.setBorder(border);

        // Components settings.
        difficultyPanel.setFirstComponent(classicModeButton); // Classic mode button.
        difficultyPanel.setSecondComponent(classicModeArtwork);
        difficultyPanel.setThirdComponent(backButton);         // Back button.

        // Main component initialization.
        difficultyPanel.init();
    }

}