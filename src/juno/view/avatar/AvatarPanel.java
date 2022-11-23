package juno.view.avatar;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class AvatarPanel
        extends JPanel {

    private JLabel avatar;

    private static AvatarPanel instance;

    private AvatarPanel() {}

    public static AvatarPanel getInstance() {
        if(instance == null) instance = new AvatarPanel();
        return instance;
    }

    public void init() {
        if(avatar == null) {
            throw new IllegalArgumentException("Avatar is null");
        }

        setOpaque(false);
        setLayout(new BorderLayout());
        add(avatar, BorderLayout.CENTER);
    }

    public void setAvatar(@NotNull JLabel avatar) {
        this.avatar = avatar;
    }
}