package juno.view.avatar;

import juno.view.factories.buttons.ButtonFactory;
import juno.view.factories.buttons.ButtonLibrary;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AvatarsPanelConfigurator {

    private AvatarsPanelConfigurator() {}

    public static void configure() {
        // MAIN COMPONENT
        AvatarsPanel avatarsPanel = AvatarsPanel.getInstance();

        // INITIALIZATION
        avatarsPanel.init();

        // SUB COMPONENTS
        AbstractButton avatar1 = ButtonFactory.createButton(ButtonLibrary.AVATAR_1);
        AbstractButton avatar2 = ButtonFactory.createButton(ButtonLibrary.AVATAR_2);
        AbstractButton avatar3 = ButtonFactory.createButton(ButtonLibrary.AVATAR_3);
        AbstractButton avatar4 = ButtonFactory.createButton(ButtonLibrary.AVATAR_4);
        AbstractButton avatar5 = ButtonFactory.createButton(ButtonLibrary.AVATAR_5);
        AbstractButton avatar6 = ButtonFactory.createButton(ButtonLibrary.AVATAR_6);
        AbstractButton avatar7 = ButtonFactory.createButton(ButtonLibrary.AVATAR_7);
        AbstractButton avatar8 = ButtonFactory.createButton(ButtonLibrary.AVATAR_8);
        AbstractButton avatar9 = ButtonFactory.createButton(ButtonLibrary.AVATAR_9);
        AbstractButton avatar10 = ButtonFactory.createButton(ButtonLibrary.AVATAR_10);

        // ADDING COMPONENTS
        List<AbstractButton> avatarsList = Arrays.asList(
                avatar1,
                avatar2,
                avatar3,
                avatar4,
                avatar5,
                avatar6,
                avatar7,
                avatar8,
                avatar9,
                avatar10
        ); avatarsList.forEach(avatarsPanel::addAvatar);
    }
}