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
import juno.model.data.profile.Profile;
import juno.view.pages.pre_access.access.AccessPanel;
import juno.view.pages.pre_access.login.LogInPanel;
import juno.view.pages.pre_access.registration.RegistrationPanel;
import juno.view.pages.pre_access.welcome.WelcomePanel;

public class PreAccessCardPanelConfigurator {

    private PreAccessCardPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        PreAccessCardPanel preAccessCardPanel = PreAccessCardPanel.getInstance();

        // SUB COMPONENTS
        PreAccessInitialChooser preAccessInitialChooser = PreAccessInitialChooser.getInstance();
        WelcomePanel welcomePanel = WelcomePanel.getInstance();
        AccessPanel accessPanel = AccessPanel.getInstance();
        RegistrationPanel registrationPanel = RegistrationPanel.getInstance();
        LogInPanel logInPanel = LogInPanel.getInstance();

        // ADDING COMPONENTS
        preAccessCardPanel.setWelcomePanel(welcomePanel);
        preAccessCardPanel.setAccessPanel(accessPanel);
        preAccessCardPanel.setRegistrationPanel(registrationPanel);
        preAccessCardPanel.setLogInPanel(logInPanel);

        // MAIN COMPONENT INITIALIZATION
        preAccessCardPanel.init();

        // SELECTOR
        preAccessInitialChooser.setConfigurationFilesProvider(ConfigurationFilesProvider.getInstance());

        // CALL
        PreAccessInitialChooser.getInstance()
                .setFirstPanelToShow(Directories.PROFILES.absolutePath(),
                                     Profile.getInstance());
    }
}