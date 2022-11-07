package juno.view.example2.panel.logoPanel;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {

    public LogoPanel() {
       init();
    }

    private void init() {
        // DEFAULT SETTINGS
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        Logo logo = new Logo();
        this.add(logo, gbc);
    }
}
