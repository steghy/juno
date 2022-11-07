package juno.view.pages.main.logoPanel;

import juno.view.logo.Logo;

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

        JButton logo = new Logo();

        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();
        double divisor = 1.7285;
        logo.setPreferredSize(new Dimension(
                (int) (logoWidth / divisor), (int) (logoHeight / divisor)
        ));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.PAGE_START;

        this.add(logo, gbc);
    }
}
