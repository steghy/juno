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

package juno.view.pages.score.menu;

import juno.controller.audio.SoundAction;
import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;
import juno.model.sound.ButtonSoundPlayer;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.main.card.MainCardPanel;
import juno.view.pages.score.GamesWonPanel;
import juno.view.pages.score.LostGamesPanel;
import juno.view.pages.score.avatar.AvatarAwardPanel;
import juno.view.pages.score.avatar.AvatarImagesPanelConfigurator;
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

    // Builds the MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    /** Configures the MenuPanel instance. */
    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        GamesWonPanel gamesWonPanel = GamesWonPanel.getInstance();
        LostGamesPanel lostGamesPanel = LostGamesPanel.getInstance();
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton backButton = creator.create(Button.BACK, null);
        JLabel avatarImagesLabel  = new JLabel();

        // Points panel Observer-Observable connection.
        GamesWonCounter.getInstance().addObserver(gamesWonPanel);
        LostGamesCounter.getInstance().addObserver(lostGamesPanel);

        // Labels setting.
        // AvatarImagesLabel.
        avatarImagesLabel.setText("Avatar images");
        avatarImagesLabel.setOpaque(false);
        avatarImagesLabel.setForeground(Color.WHITE);
        avatarImagesLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));

        // Images resizing.
        ImageResizer resizer = ImageResizer.getInstance();
        resizer.resize(backButton, 2.5);

        // Components settings.
        // AvatarImagePanel.
        AvatarAwardPanel avatarImagesPanel = new AvatarAwardPanel();
        AvatarImagesPanelConfigurator.configure(avatarImagesPanel);
        JScrollPane avatarImagesScrollPanel = new JScrollPane(avatarImagesPanel,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        avatarImagesScrollPanel.setPreferredSize(new Dimension(650, 140));
        avatarImagesScrollPanel.setIgnoreRepaint(true);
        avatarImagesScrollPanel.setMinimumSize(new Dimension(650, 1400));
        avatarImagesScrollPanel.getViewport().setOpaque(false);
        avatarImagesScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        avatarImagesScrollPanel.setOpaque(false);
        JScrollBar bar = avatarImagesScrollPanel.getHorizontalScrollBar();
        bar.setOpaque(false);
        bar.setPreferredSize(new Dimension(5, 5));
        bar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GREEN;
            }
        });

        menuPanel.setFirstComponent(avatarImagesLabel);        // Avatar images label.
        menuPanel.setSecondComponent(avatarImagesScrollPanel); // Avatar images panel.
        menuPanel.setThirdComponent(backButton);               // Back button.

        // Action listeners.
        backButton.addActionListener(new SoundAction(ButtonSoundPlayer.getInstance(),
                new ChangePanelAction(new PanelChanger(MainCardPanel.getInstance(), MainCardPanel.MAIN_PANEL))));

        // Border settings
        RoundedBorder insideBorder = new RoundedBorder(10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(25, 1, null, Color.GREEN);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        gamesWonPanel.setBorder(insideBorder);
        lostGamesPanel.setBorder(insideBorder);
        menuPanel.setBorder(border);

        // Main component initialization.
        menuPanel.init();
    }

}