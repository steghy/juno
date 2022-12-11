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

package juno.view.pages.pre_access.card;

import juno.init.Directories;
import juno.model.data.io.input.configurable.CConfigurationFilesProvider;
import juno.model.data.profile.Profile;
import juno.view.pages.pre_access.access.AccessPanel;
import juno.view.pages.pre_access.login.LogInPanel;
import juno.view.pages.pre_access.registration.RegistrationPanel;
import juno.view.pages.pre_access.welcome.WelcomePanel;

/**
 * @author Simone Gentili
 */
public class PreAccessCardPanelConfigurator {

    // Builds a PreAccessCardPanelConfigurator object.
    private PreAccessCardPanelConfigurator() {}

    /* */
    public static void configure() {
        // Main components.
        PreAccessCardPanel preAccessCardPanel = PreAccessCardPanel.getInstance();

        // Components.
        PreAccessInitialChooser preAccessInitialChooser = PreAccessInitialChooser.getInstance();
        WelcomePanel welcomePanel = WelcomePanel.getInstance();
        AccessPanel accessPanel = AccessPanel.getInstance();
        RegistrationPanel registrationPanel = RegistrationPanel.getInstance();
        LogInPanel logInPanel = LogInPanel.getInstance();

        // Components settings
        preAccessCardPanel.setFirstComponent(welcomePanel);      // Welcome panel.
        preAccessCardPanel.setSecondComponent(accessPanel);      // Access panel.
        preAccessCardPanel.setThirdComponent(registrationPanel); // Registration panel.
        preAccessCardPanel.setFourthComponent(logInPanel);       // Log in panel.

        // Main components initialization.
        preAccessCardPanel.init();

        // Pre access initial chooser setting.
        preAccessInitialChooser.setConfigurationFilesProvider(CConfigurationFilesProvider.getInstance());

        // Call.
        PreAccessInitialChooser.getInstance()
                .setFirstPanelToShow(Directories.PROFILES.absolutePath(),
                                     Profile.getInstance());
    }

}