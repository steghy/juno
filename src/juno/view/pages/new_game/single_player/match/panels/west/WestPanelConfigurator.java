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

package juno.view.pages.new_game.single_player.match.panels.west;

import juno.controller.new_game.GameStarter;
import juno.view.avatar.AvatarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class WestPanelConfigurator {

    // Builds a WestPanelConfigurator object.
    private WestPanelConfigurator() {}

    /** Configures the WestPanel instance. */
    public static void configure() {
        // Main component.
        WestPanel westPanel = WestPanel.getInstance();

        // Component.
        WestCardPanel westCardPanel = WestCardPanel.getInstance();
        AvatarPanel avatarPanel = new AvatarPanel();

        // East card panel.
        JScrollPane westCardScrollPanel = new JScrollPane(westCardPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        westCardScrollPanel.setPreferredSize(new Dimension(150, 600));
        westCardScrollPanel.setIgnoreRepaint(false);
        westCardScrollPanel.setMinimumSize(new Dimension(150, 600));
        westCardScrollPanel.getViewport().setOpaque(false);
        westCardScrollPanel.setOpaque(false);

        // Observer / Observable.
        GameStarter.getInstance().addObserver(westCardPanel);

        // Setting components.
        westPanel.setFirstComponent(westCardScrollPanel); // Cards panel.
        westPanel.setSecondComponent(avatarPanel);        // Avatar panel.

        // Main component initialization.
        westPanel.init();
    }

}