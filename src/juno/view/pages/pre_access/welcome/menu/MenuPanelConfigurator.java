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

package juno.view.pages.pre_access.welcome.menu;

import juno.controller.util.ExitAction;
import juno.controller.pre_access.loggers.GuestLogger;
import juno.model.data.io.output.ExitManager;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.pages.pre_access.registration.RegistrationPanel;
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
        // Main components.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton createAnAccountButton = creator.create(Button.CREATE_AN_ACCOUNT, RotatedIcon.Rotate.ABOUT_CENTER);
        AbstractButton continueWithoutAnAccountButton = creator.create(Button.CONTINUE_WITHOUT_AN_ACCOUNT, RotatedIcon.Rotate.ABOUT_CENTER);
        AbstractButton exitButton = creator.create(Button.EXIT, RotatedIcon.Rotate.ABOUT_CENTER);

        // Images resizing.
        ImageResizer.resize(createAnAccountButton, 3.0);
        ImageResizer.resize(continueWithoutAnAccountButton, 3.0);
        ImageResizer.resize(exitButton, 3.0);

        // Components settings.
        menuPanel.setFirstComponent(createAnAccountButton);           // 'Create an account' button.
        menuPanel.setSecondComponent(continueWithoutAnAccountButton); // 'Continue without an account' button.
        menuPanel.setThirdComponent(exitButton);                      // 'Exit' button.

        // Action listeners.
        createAnAccountButton.addActionListener(listener -> {
            RegistrationPanel.getInstance().setFromWelcomePanel(true);
            LayoutManager layoutManager = PreAccessCardPanel.getInstance().getLayout();
            if(layoutManager instanceof CardLayout cardLayout) {
                cardLayout.show(PreAccessCardPanel.getInstance(), PreAccessCardPanel.REGISTRATION_PANEL);
            } else {
                throw new IllegalArgumentException(
                        "Invalid layout type: " + layoutManager.getClass() +
                                ". CardLayout expected.");
            }
        });
        continueWithoutAnAccountButton.addActionListener(GuestLogger.getInstance());
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(
                50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}