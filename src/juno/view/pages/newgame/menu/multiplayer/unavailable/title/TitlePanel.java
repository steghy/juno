package juno.view.pages.newgame.menu.multiplayer.unavailable.title;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    AbstractButton titleButton;
    private static TitlePanel instance;

    private TitlePanel() {}

    public static TitlePanel getInstance() {
        if(instance == null) {
            instance = new TitlePanel();
        } return instance;
    }

    public void init() {
        if(titleButton == null) {
            throw new IllegalArgumentException("Title button is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE BUTTON
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        add(titleButton, gbc);
    }

    public void setTitleButton(AbstractButton titleButton) {
        this.titleButton = titleButton;
    }

    public AbstractButton getTitleButton() {
        return titleButton;
    }


}