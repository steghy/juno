package juno.view.pages.preaccess.login.menu;

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

        this.setOpaque(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
    }
}