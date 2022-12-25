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

package juno.view.pages.new_game.single_player.match.panels.south;

import juno.model.card.InterfaceCard;
import juno.model.subjects.human.HumanPlayer;
import juno.model.util.InterfaceProvider;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class SouthPanelConfigurator {

    // Builds a SouthPanelConfigurator object.
    private SouthPanelConfigurator() {}

    @SuppressWarnings("unchecked")
    public static void configure() {
        // Main component.
        SouthPanel southPanel = SouthPanel.getInstance();
        // Card panel.
        JScrollPane cardPanel = new JScrollPane(SouthCardPanel.getInstance(),
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cardPanel.setPreferredSize(new Dimension(600, 150));
        cardPanel.setIgnoreRepaint(false);
        cardPanel.setMinimumSize(new Dimension(600, 150));
        cardPanel.getViewport().setOpaque(false);
        cardPanel.setOpaque(false);
        // Uno button.
        AbstractButton unoButton = ButtonCreator.getInstance().create(Button.JUNO);
        ImageResizer.resize(unoButton, 4.0);

        // Observer / Observable.
        HumanPlayer.getInstance().addObserver(SouthCardPanel.getInstance());
        SouthCardPanel.getInstance().setProvider((InterfaceProvider<InterfaceCard>) HumanPlayer.getInstance());
        // Setting components.
        southPanel.setFirstComponent(cardPanel);  // Avatar panel.
        southPanel.setSecondComponent(unoButton); // Uno button.
        // Main component initialization.
        southPanel.init();
    }

}