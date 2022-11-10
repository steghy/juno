package juno.view.logo;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {

    private AbstractButton logo;

    private static LogoPanel instance;

    private LogoPanel() {}

    public static LogoPanel getInstance() {
        if(instance == null) {
            instance = new LogoPanel();
        } return instance;
    }

    public void init() {
        if(logo == null) {
            throw new IllegalArgumentException("Logo is null");
        }

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.anchor = GridBagConstraints.CENTER;

        this.add(logo, gbc);
    }

    public void setLogo(AbstractButton logo) {
        this.logo = logo;
    }
}