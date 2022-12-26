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

package juno.view.pages.new_game.single_player.match.panels.east;

import juno.controller.new_game.GameInitializer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class EastPanelConfigurator {

    // Builds an EastPanelConfigurator object.
    private EastPanelConfigurator() {}

    /** Configures the EastPanel instance. */
    public static void configure() {
        // Main component.
        EastPanel eastPanel = EastPanel.getInstance();

        // Component.
        EastCardPanel eastCardPanel = EastCardPanel.getInstance();

        // East card panel.
        JScrollPane eastCardScrollPanel = new JScrollPane(eastCardPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        eastCardScrollPanel.setPreferredSize(new Dimension(150, 600));
        eastCardScrollPanel.setIgnoreRepaint(false);
        eastCardScrollPanel.setMinimumSize(new Dimension(150, 600));
        eastCardScrollPanel.getViewport().setOpaque(false);
        eastCardScrollPanel.setOpaque(false);

        // Observer / Observable.
        GameInitializer.getInstance().addObserver(eastCardPanel);

        // Setting components.
        eastPanel.setFirstComponent(eastCardScrollPanel);

        // Main component initialization.
        eastPanel.init();
    }

}