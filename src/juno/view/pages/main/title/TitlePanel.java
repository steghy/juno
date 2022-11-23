package juno.view.pages.main.title;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TitlePanel
        extends JPanel {

    private AbstractButton logo;

    private static TitlePanel instance;

    private TitlePanel() {}

    public static TitlePanel getInstance() {
        if(instance == null) instance = new TitlePanel();
        return instance;
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

    public void setLogo(@NotNull AbstractButton logo) {
        this.logo = logo;
    }
}