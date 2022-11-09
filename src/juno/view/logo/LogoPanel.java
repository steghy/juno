package juno.view.logo;

import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LogoPanel extends JPanel {

    public LogoPanel() {
        init();
    }

    private void init() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        // BORDER
        Border roundedBorder = new RoundedBorder(35, 1, null, Color.WHITE);
        // this.setBorder(roundedBorder);

        AbstractButton logo = new Logo();

        Map<AbstractButton, Double> map = new HashMap<>();
        map.put(logo, 1.8);

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