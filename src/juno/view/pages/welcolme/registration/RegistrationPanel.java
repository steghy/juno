package juno.view.pages.welcolme.registration;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static RegistrationPanel instance;

    private RegistrationPanel() {}

    public static RegistrationPanel getInstance() {
        if(instance == null) {
            instance = new RegistrationPanel();
        } return instance;
    }

    public void init() {
        if(titlePanel == null) {
            throw new IllegalArgumentException("Title panel is null");
        } if(menuPanel == null) {
            throw new IllegalArgumentException("Menu panel is null");
        }

        setOpaque(true);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
    }

    public void setTitlePanel(@NotNull JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public void setMenuPanel(@NotNull JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
