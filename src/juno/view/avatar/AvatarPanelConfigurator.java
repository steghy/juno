package juno.view.avatar;

import javax.swing.*;

public class AvatarPanelConfigurator {

    private AvatarPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        AvatarPanel avatarPanel = AvatarPanel.getInstance();

        // SUB COMPONENT
        JLabel avatarLabel = null;

        // ADDING COMPONENT
        avatarPanel.setAvatar(avatarLabel);

        // INITIALIZATION
        avatarPanel.init();
    }
}