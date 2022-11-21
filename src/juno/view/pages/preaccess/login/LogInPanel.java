package juno.view.pages.preaccess.login;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class LogInPanel
        extends JPanel {

    private JPanel titlePanel;
    private JPanel menuPanel;
    private static LogInPanel instance;

    private LogInPanel() {}

    public static LogInPanel getInstance() {
        if(instance == null) instance = new LogInPanel();
        return instance;
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
}
