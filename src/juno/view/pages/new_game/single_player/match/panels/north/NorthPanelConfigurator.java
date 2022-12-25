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

package juno.view.pages.new_game.single_player.match.panels.north;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class NorthPanelConfigurator {
    
    // Builds a NorthPanelConfigurator object.
    private NorthPanelConfigurator() {}
    
    public static void configure() {
        // Main component.
        NorthPanel northPanel = NorthPanel.getInstance();

        // East card panel.
        JScrollPane northCardPanel = new JScrollPane(NorthCardPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        northCardPanel.setPreferredSize(new Dimension(600, 150));
        northCardPanel.setIgnoreRepaint(false);
        northCardPanel.setMinimumSize(new Dimension(600, 150));
        northCardPanel.getViewport().setOpaque(false);
        northCardPanel.setOpaque(false);

        northPanel.setFirstComponent(northCardPanel); // Cards scrollable panel.

        // Main component initialization.
        northPanel.init();
    }
    
}