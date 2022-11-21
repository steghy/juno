package juno.view.pages.preaccess.card;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class PreAccessCardPanel
        extends JPanel {

    public static final String WELCOME_PANEL = "Welcome panel";
    public static final String ACCESS_PANEL = "Access panel";
    public static final String REGISTRATION_PANEL = "Registration panel";
    public static final String LOG_IN_PANEL = "Log in panel";

    private JPanel welcomePanel;
    private JPanel accessPanel;
    private JPanel registrationPanel;
    private JPanel logInPanel;

    private static PreAccessCardPanel instance;

    private PreAccessCardPanel() {}

    public static PreAccessCardPanel getInstance() {
        if(instance == null) instance = new PreAccessCardPanel();
        return instance;
    }

    public void init() {
        if(welcomePanel == null) {
            throw new IllegalArgumentException("Welcome panel is null");
        } if(accessPanel == null) {
            throw new IllegalArgumentException("Access panel is null");
        } if(registrationPanel == null) {
            throw new IllegalArgumentException("Registration panel is null");
        } if(logInPanel == null) {
            throw new IllegalArgumentException("Log in panel is null");
        }

        setOpaque(false);
        setLayout(new CardLayout());

        add(welcomePanel, WELCOME_PANEL);
        add(accessPanel, ACCESS_PANEL);
        add(registrationPanel, REGISTRATION_PANEL);
        add(logInPanel, LOG_IN_PANEL);
    }

    public void setWelcomePanel(@NotNull JPanel welcomePanel) {
        this.welcomePanel = welcomePanel;
    }

    public void setAccessPanel(@NotNull JPanel accessPanel) {
        this.accessPanel = accessPanel;
    }

    public void setRegistrationPanel(@NotNull JPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }

    public void setLogInPanel(@NotNull JPanel logInPanel) {
        this.logInPanel = logInPanel;
    }
}