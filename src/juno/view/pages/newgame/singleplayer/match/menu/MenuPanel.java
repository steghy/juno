package juno.view.pages.newgame.singleplayer.match.menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private static MenuPanel instance;

    private MenuPanel() {}

    public static MenuPanel getInstance() {
        if(instance == null) {
            instance = new MenuPanel();
        } return instance;
    }

    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
    }
}