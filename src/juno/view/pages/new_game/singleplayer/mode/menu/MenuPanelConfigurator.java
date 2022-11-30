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

package juno.view.pages.new_game.singleplayer.mode.menu;

import juno.controller.ChangePanelAction;
import juno.view.factories.ButtonFactory;
import juno.view.factories.ButtonLibrary;
import juno.view.pages.new_game.singleplayer.card.SinglePlayerCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanelConfigurator {

    private MenuPanelConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENTS
        MenuPanel difficultyPanel = MenuPanel.getInstance();

        // SUB-COMPONENTS
        AbstractButton stackingModeButton = ButtonFactory.createButton(ButtonLibrary.STACKING);

        // RESIZE IMAGES
        ImageResizer.resize(stackingModeButton, 3.0);

        // ACTION LISTENERS
        stackingModeButton.addActionListener(new ChangePanelAction(SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.MATCH_PANEL));

        // BORDER
        RoundedBorder insideBorder = new RoundedBorder(50, 2, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(50, 2, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        difficultyPanel.setBorder(border);

        // ADDING COMPONENTS
        difficultyPanel.setStackingModeButton(stackingModeButton);

        // INITIALIZATION
        difficultyPanel.init();
    }
}