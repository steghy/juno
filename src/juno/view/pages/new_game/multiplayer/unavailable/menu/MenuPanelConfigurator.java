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

package juno.view.pages.new_game.multiplayer.unavailable.menu;

import juno.controller.util.ChangePanelAction;
import juno.controller.util.PanelChanger;
import juno.view.button.ButtonCreator;
import juno.view.button.Button;
import juno.view.pages.new_game.card.NewGameCardPanel;
import juno.view.util.ImageResizer;
import juno.view.util.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class MenuPanelConfigurator {

    // Builds a MenuPanelConfigurator object.
    private MenuPanelConfigurator() {}

    public static void configure() {
        // Main component.
        MenuPanel menuPanel = MenuPanel.getInstance();

        // Components.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton backButton = creator.create(Button.BACK);
        JLabel unavailableServiceLabel = new JLabel();

        // Image resizing.
        ImageResizer.resize(backButton, 4.0);

        // Unavailable service text.
        String unavailableServiceText =
                        "<html> We are sorry to inform you that unfortunately <br> this mode is not yet available, however <br> if you want to contribute to the development of <br> this video game, please visit the official repository <br>:'site here'.</html>";

        unavailableServiceLabel.setText(unavailableServiceText);
        unavailableServiceLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 19));
        unavailableServiceLabel.setForeground(Color.WHITE);

        // Unavailable service label size settings.
        unavailableServiceLabel.setPreferredSize(new Dimension(500, 500));

        // JScrollPane setting.
        JScrollPane unavailableServiceScrollPane = new JScrollPane(unavailableServiceLabel ,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        unavailableServiceScrollPane.setPreferredSize(new Dimension(450, 450));
        unavailableServiceScrollPane.setIgnoreRepaint(true);
        unavailableServiceScrollPane.setMinimumSize(new Dimension(450, 450));
        unavailableServiceScrollPane.getViewport().setOpaque(false);
        unavailableServiceScrollPane.setOpaque(false);

        // Components settings.
        menuPanel.setFirstComponent(unavailableServiceLabel); // Unavailable service label.
        menuPanel.setSecondComponent(backButton);             // Back button.

        // Border settings.
        RoundedBorder insideBorder = new RoundedBorder(
                10, 1, null, Color.WHITE);
        RoundedBorder outsideBorder = new RoundedBorder(
                25, 1, null, Color.RED);
        Border border = BorderFactory.createCompoundBorder(insideBorder, outsideBorder);
        menuPanel.setBorder(border);

        // Action listeners.
        backButton.addActionListener(new ChangePanelAction(
                new PanelChanger(NewGameCardPanel.getInstance(), NewGameCardPanel.NEW_GAME_PANEL)));

        // Main component initialization.
        menuPanel.init();
    }

}
