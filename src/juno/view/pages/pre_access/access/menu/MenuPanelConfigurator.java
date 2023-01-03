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

package juno.view.pages.pre_access.access.menu;

import juno.controller.audio.SoundAction;
import juno.controller.pre_access.loggers.GuestLogger;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.ExitAction;
import juno.controller.util.PanelChanger;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
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
        AbstractButton createAnAccountButton = creator.create(Button.CREATE_AN_ACCOUNT, RotatedIcon.Rotate.ABOUT_CENTER);
        AbstractButton logInButton = creator.create(Button.LOG_IN, RotatedIcon.Rotate.ABOUT_CENTER);
        AbstractButton continueWithoutAnAccountButton = creator.create(Button.CONTINUE_WITHOUT_AN_ACCOUNT, RotatedIcon.Rotate.ABOUT_CENTER);
        AbstractButton exitButton = creator.create(Button.EXIT, RotatedIcon.Rotate.ABOUT_CENTER);

        // Images resizing.
        ImageResizer.resize(createAnAccountButton, 4.0);
        ImageResizer.resize(logInButton, 4.0);
        ImageResizer.resize(continueWithoutAnAccountButton, 4.0);
        ImageResizer.resize(exitButton, 4.0);

        // Main component setting.
        menuPanel.setFirstComponent(createAnAccountButton);          // 'Create an account' button.
        menuPanel.setSecondComponent(logInButton);                   // 'Log in' button.
        menuPanel.setThirdComponent(continueWithoutAnAccountButton); // 'Continue without an account' button.
        menuPanel.setFourthComponent(exitButton);                    // 'Exit' button.

        // Action listeners setting.
        ButtonSoundPlayer buttonSoundPlayer = ButtonSoundPlayer.getInstance();
        createAnAccountButton.addActionListener(new SoundAction(buttonSoundPlayer,
                new ChangePanelAction(new PanelChanger(PreAccessCardPanel.getInstance(), PreAccessCardPanel.REGISTRATION_PANEL))));
        logInButton.addActionListener(new SoundAction(buttonSoundPlayer, new ChangePanelAction(
                new PanelChanger(PreAccessCardPanel.getInstance(), PreAccessCardPanel.LOG_IN_PANEL))));
        continueWithoutAnAccountButton.addActionListener(new SoundAction(buttonSoundPlayer, GuestLogger.getInstance()));
        exitButton.addActionListener(new SoundAction(null, new ExitAction(null)));

        // Border setting.
        RoundedBorder insideBorder = new RoundedBorder(
                10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}