/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.view.pages.main;

import juno.controller.log_out.AccountExiter;
import juno.controller.log_out.LogOutAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.model.data.achievements.InterfaceAvatarImage;
import juno.model.data.avatar.AvatarImageProvider;
import juno.model.data.avatar.AvatarImageSetter;
import juno.model.data.avatar.AvatarNameProvider;
import juno.model.data.avatar.AvatarNameSetter;
import juno.model.data.io.ProgramDirectory;
import juno.model.requester.PathProviderAssembler;
import juno.view.avatar.UserAvatarPanel;
import juno.view.button.ButtonCreator;
import juno.view.gobject.avatars.GAvatarImageCreator;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.view.pages.card.TopCardPanel;
import juno.view.pages.main.menu.MenuPanel;
import juno.view.pages.main.title.TitlePanel;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines a configurator.
 * @author Simone Gentili
 */
public class MainPanelConfigurator {

    // Builds a MainPanelConfigurator instance.
    private MainPanelConfigurator() {}

    /** Configures the MainPanel instance. */
    public static void configure() {
        // Main component.
        MainPanel mainPanel = MainPanel.getInstance();

        // Components.
        ImageResizer resizer = ImageResizer.getInstance();
        TitlePanel titlePanel = TitlePanel.getInstance();
        MenuPanel menuPanel = MenuPanel.getInstance();
        UserAvatarPanel<InterfaceAvatarImage> avatarPanel = new UserAvatarPanel<>(
                AvatarNameSetter.getInstance(),
                AvatarImageSetter.getInstance(),
                GAvatarImageCreator.getInstance(),
                AvatarImageProvider.getInstance(),
                AvatarNameProvider.getInstance());

        JLabel skeletonLeft = new JLabel();
        JLabel skeletonRight = new JLabel();

        ImageComponentInitializer imageComponentInitializer = ImageComponentInitializer.getInstance();

        // Skeleton left
        imageComponentInitializer.initialize(skeletonLeft,
                        PathProviderAssembler.getInstance().assemble(ProgramDirectory.GIFS, "skeleton-left.gif"),
                        null);
        // Skeleton right
        imageComponentInitializer.initialize(skeletonRight,
                PathProviderAssembler.getInstance().assemble(ProgramDirectory.GIFS, "skeleton-right.gif"),
                null);

        // Log out button.
        AbstractButton logOutButton = ButtonCreator.getInstance().create(juno.view.button.Button.LOG_OUT, null);

        // Image resizing.
        resizer.resize(logOutButton, 6.0);

        // Avatar label.
        JLabel label = new JLabel();
        label.setText("Logged as: ");
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));

        // Action listener.
        logOutButton.addActionListener(new LogOutAction(AccountExiter.getInstance()));
        logOutButton.addActionListener(new ChangePanelAction(new PanelChanger(TopCardPanel.getInstance(), TopCardPanel.PRE_ACCESS_PANEL)));

        // Components settings.
        mainPanel.setFirstComponent(titlePanel);   // title panel
        mainPanel.setSecondComponent(menuPanel);   // Menu panel.
        mainPanel.setThirdComponent(label);        // label.
        mainPanel.setFourthComponent(avatarPanel); // Avatar panel.
        mainPanel.setFifthComponent(logOutButton); // Log out button.
        mainPanel.setSixthComponent(skeletonLeft);
        mainPanel.setSeventhComponent(skeletonRight);

        // Main component initialization.
        mainPanel.init();
    }

}