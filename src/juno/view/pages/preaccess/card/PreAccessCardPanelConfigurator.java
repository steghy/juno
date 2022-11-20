package juno.view.pages.preaccess.card;

import juno.init.Directories;
import juno.model.data.io.input.CConfigurationFilesProvider;
import juno.model.data.profile.Profile;
import juno.view.pages.preaccess.access.AccessPanel;
import juno.view.pages.preaccess.login.LogInPanel;
import juno.view.pages.preaccess.registration.RegistrationPanel;
import juno.view.pages.preaccess.welcome.WelcomePanel;

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
        preAccessInitialChooser.setDataCompatibilityChecker(null);
        PreAccessInitialChooser.getInstance().setFirstPanelToShow(Directories.PROFILES.absolutePath(), new Profile());
    }
}