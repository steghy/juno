package juno.view.pages.newgame.singleplayer.players.title;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    private AbstractButton title;
    private static TitlePanel instance;

    private TitlePanel() {}

    public static TitlePanel getInstance() {
        if(instance == null) {
            instance = new TitlePanel();
        } return instance;
    }

    public void init() {
        if(title == null) {
            throw new IllegalArgumentException("Title is null");
        }

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // TITLE
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.fill = GridBagConstraints.CENTER;

        this.add(title, gbc);
    }

    public void setTitle(AbstractButton title) {
        this.title = title;
    }

    public AbstractButton getTitle() {
        return title;
    }
}
