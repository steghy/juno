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

import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;

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
        JScrollPane cardPanel = new JScrollPane(NorthCardPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cardPanel.setPreferredSize(new Dimension(600, 150));
        cardPanel.setIgnoreRepaint(false);
        cardPanel.setMinimumSize(new Dimension(600, 150));
        cardPanel.getViewport().setOpaque(false);
        cardPanel.setOpaque(false);

        // Exit button.
        AbstractButton exitButton = ButtonCreator.getInstance().create(Button.EXIT);

        // Image resizing.
        ImageResizer.resize(exitButton, 4.0);

        // Action listener.
        exitButton.addActionListener(new ChangePanelAction(
                new PanelChanger(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MODE_PANEL)));

        // Setting components.
        northPanel.setFirstComponent(cardPanel); // Cards scrollable panel.
        northPanel.setSecondComponent(exitButton); // Exit button.

        // Main component initialization.
        northPanel.init();
    }
    
}