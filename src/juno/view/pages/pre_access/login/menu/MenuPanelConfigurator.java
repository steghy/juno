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

package juno.view.pages.pre_access.login.menu;

import juno.controller.audio.SoundAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.pages.pre_access.card.PreAccessCardPanel;
import juno.view.pages.pre_access.login.profiles_panel.ProfilesPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * This class defines a configurator.
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    /** Configures the MenuPanel instance. */
    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton backButton = creator.create(Button.BACK, null);

        // Image resizing.
        ImageResizer resizer = ImageResizer.getInstance();
        resizer.resize(backButton, 2.5);

        // Action listener.
        backButton.addActionListener(new SoundAction(ButtonSoundPlayer.getInstance(),
                new ChangePanelAction(new PanelChanger(PreAccessCardPanel.getInstance(), PreAccessCardPanel.ACCESS_PANEL))));

        // Components setting.
        JScrollPane profilesScrollPanel = new JScrollPane(ProfilesPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        profilesScrollPanel.setPreferredSize(new Dimension(150, 200));
        profilesScrollPanel.setIgnoreRepaint(true);
        profilesScrollPanel.setMinimumSize(new Dimension(150, 200));
        profilesScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        profilesScrollPanel.getViewport().setOpaque(false);
        profilesScrollPanel.setOpaque(false);
        JScrollBar bar = profilesScrollPanel.getVerticalScrollBar();
        bar.setOpaque(false);
        bar.setPreferredSize(new Dimension(5, 5));
        bar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GREEN;
            }
        });

        // Menu panel settings.
        menuPanel.setFirstComponent(profilesScrollPanel); // Profiles panel.
        menuPanel.setSecondComponent(backButton);   // Back button.

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.GREEN);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}