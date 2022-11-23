package juno.view.avatar;

import javax.swing.*;
import java.awt.*;

public class AvatarsPanel
        extends JPanel {

    private GridBagConstraints gbc;

    private static AvatarsPanel instance;

    private AvatarsPanel() {}

    public static AvatarsPanel getInstance() {
        if(instance == null) instance = new AvatarsPanel();
        return instance;
    }

    public void init() {
        setOpaque(false);
        setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        gbc.ipadx = 0;
        gbc.ipady = 0;

        gbc.insets = new Insets(0,0,0,0);

        gbc.anchor = GridBagConstraints.CENTER;
    }

    public void addAvatar(AbstractButton avatarButton) {
        add(avatarButton, gbc);
        if(gbc.gridx >= 3) {
            gbc.gridx = 0;
            gbc.gridy ++;
        } else {
            gbc.gridx ++;
        }
    }
}