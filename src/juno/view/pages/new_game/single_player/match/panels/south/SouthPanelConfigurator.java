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

import juno.controller.new_game.DiscardedCardSetter;
import juno.controller.new_game.GameInitializer;
import juno.controller.new_game.Mover;
import juno.model.card.InterfaceCard;
import juno.model.deck.CompatibilityChecker;
import juno.model.subjects.human.HumanPlayer;
import juno.model.util.InterfaceSetter;
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

    /** Configures the SouthPanel instance. */
    @SuppressWarnings("unchecked")
    public static void configure() {
        // Main component.
        SouthPanel southPanel = SouthPanel.getInstance();

        // Component.
        SouthCardPanel southCardPanel = SouthCardPanel.getInstance();
        CompatibleGCardEnabler compatibleGCardEnabler = CompatibleGCardEnabler.getInstance();

        // Card panel.
        JScrollPane southCardScrollPanel = new JScrollPane(southCardPanel,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        southCardScrollPanel.setPreferredSize(new Dimension(600, 150));
        southCardScrollPanel.setIgnoreRepaint(false);
        southCardScrollPanel.setMinimumSize(new Dimension(600, 150));
        southCardScrollPanel.getViewport().setOpaque(false);
        southCardScrollPanel.setOpaque(false);

        // Uno button. (Temporary)
        AbstractButton unoButton = ButtonCreator.getInstance().create(Button.JUNO);

        // Image resizing.
        ImageResizer.resize(unoButton, 4.0);

        // Observer / Observable.
        HumanPlayer<InterfaceCard> humanPlayer = (HumanPlayer<InterfaceCard>) HumanPlayer.getInstance();
        humanPlayer.addObserver(southCardPanel);
        GameInitializer.getInstance().addObserver(southCardPanel);
        Mover.getInstance().addObserver(southCardPanel);

        // Component setting.
        southCardPanel.setProvider(humanPlayer);
        southCardPanel.setDiscardedCardSetter((InterfaceSetter<InterfaceCard>) DiscardedCardSetter.getInstance());
        southCardPanel.setPlayableCardSetter(CompatibleGCardEnabler.getInstance());
        compatibleGCardEnabler.setCompatibilityChecker(CompatibilityChecker.getInstance());

        // Setting components.
        southPanel.setFirstComponent(southCardScrollPanel);  // Avatar panel.
        southPanel.setSecondComponent(unoButton);            // Uno button.

        // Main component initialization.
        southPanel.init();
    }

}