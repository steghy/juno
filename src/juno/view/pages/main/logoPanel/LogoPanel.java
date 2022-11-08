package juno.view.pages.main.logoPanel;

import juno.view.logo.Logo;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LogoPanel extends JPanel {

    private static LogoPanel instance;

    private LogoPanel() {
       init();
    }

    public static LogoPanel getInstance() {
        if(instance == null) {
            instance = new LogoPanel();
        } return instance;
    }

    private void init() {
        this.setOpaque(false);
        this.setBackground(Color.YELLOW);
        this.setLayout(new GridBagLayout());

        AbstractButton logo = Logo.getInstance();

        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(logo, 1.3);

        ImageResizer.resize(map);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.anchor = GridBagConstraints.CENTER;

        this.add(logo, gbc);
    }
}