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

import juno.controller.ChangePanelAction;
import juno.controller.ExitAction;
import juno.model.data.io.output.ExitManager;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    /* Builds a MenuPanelConfigurator object */
    private MenuPanelConfigurator() {}

    /** Configure juno.view.pages.pre_access.access.menu.MenuPanel instance. */
    public static void configure() {

        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Sub components.
        AbstractButton createAnAccountButton = ButtonFactory.createButton(ButtonLibrary.CREATE_AN_ACCOUNT);
        AbstractButton logInButton = ButtonFactory.createButton(ButtonLibrary.LOG_IN);
        AbstractButton continueWithoutAnAccountButton = ButtonFactory.createButton(ButtonLibrary.CONTINUE_WITHOUT_AN_ACCOUNT);
        AbstractButton exitButton = ButtonFactory.createButton(ButtonLibrary.EXIT);

        // Image resizing.
        ImageResizer.resize(createAnAccountButton, 3.0);
        ImageResizer.resize(logInButton, 3.0);
        ImageResizer.resize(continueWithoutAnAccountButton, 3.0);
        ImageResizer.resize(exitButton, 3.0);

        // Main component setting.
        menuPanel.setCreateAnAccountButton(createAnAccountButton);
        menuPanel.setLogInButton(logInButton);
        menuPanel.setContinueWithoutAnAccountButton(continueWithoutAnAccountButton);
        menuPanel.setExitButton(exitButton);

        // Action listeners setting.
        createAnAccountButton.addActionListener(new ChangePanelAction(PreAccessCardPanel.getInstance(), PreAccessCardPanel.REGISTRATION_PANEL));
        continueWithoutAnAccountButton.addActionListener(null);
        exitButton.addActionListener(new ExitAction(ExitManager.getInstance()));

        // Border setting.
        RoundedBorder insideBorder = new RoundedBorder(50, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }
}