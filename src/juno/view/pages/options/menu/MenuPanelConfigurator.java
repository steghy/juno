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

package juno.view.pages.options.menu;

import juno.controller.audio.AudioSwitchAction;
import juno.controller.audio.SoundAction;
import juno.controller.util.*;
import juno.model.sound.AudioPlayer;
import juno.model.sound.ButtonSoundPlayer;
import juno.model.sound.UnoSoundPlayer;
import juno.model.sound.WelcomeSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.frame.Frame;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This class defines a configurator.
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds the MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    /** Configures the MenuPanel instance. */
    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton audioMusicToggle = creator.create(Button.AUDIO_TOGGLE_MUSIC, null);
        AbstractButton audioEffectToggle = creator.create(Button.AUDIO_TOGGLE_EFFECTS, null);
        AbstractButton fullscreenToggle = creator.create(Button.FULLSCREEN_TOGGLE, null);
        AbstractButton backButton = creator.create(Button.BACK, null);

        // Images resizing.
        ImageResizer resizer = ImageResizer.getInstance();
        resizer.resize(audioMusicToggle, 2.5);
        resizer.resize(audioEffectToggle, 2.5);
        resizer.resize(fullscreenToggle, 2.5);
        resizer.resize(backButton, 2.5);

        // Components settings.
        menuPanel.setFirstComponent(audioMusicToggle);  // Audio music toggle button.
        menuPanel.setSecondComponent(audioEffectToggle);// Audio effects toggle button.
        menuPanel.setThirdComponent(fullscreenToggle);  // Full screen toggle button.
        menuPanel.setFourthComponent(backButton);       // Back button.

        // Action listeners.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();

        audioMusicToggle.addActionListener(new SoundAction(buttonSoundPlayer,
                new AudioSwitchAction(AudioPlayer.getInstance())));

        // Audio effect toggle.
        audioEffectToggle.addActionListener(new SoundAction(buttonSoundPlayer, new AudioSwitchAction(ButtonSoundPlayer.getInstance())));
        audioEffectToggle.addActionListener(new AudioSwitchAction(UnoSoundPlayer.getInstance()));
        audioEffectToggle.addActionListener(new AudioSwitchAction(WelcomeSoundPlayer.getInstance()));


        fullscreenToggle.addActionListener(new SoundAction(buttonSoundPlayer,
                new SetterAction<>(Frame.getInstance(), FullScreenSetter.getInstance())));

        backButton.addActionListener(new SoundAction(buttonSoundPlayer,
                new ChangePanelAction(new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL))));

        // Border settings
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.GREEN);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}