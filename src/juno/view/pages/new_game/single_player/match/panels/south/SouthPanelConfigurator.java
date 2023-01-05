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

import juno.controller.new_game.GameStarter;
import juno.controller.new_game.dispenser.CardDispenser;
import juno.controller.new_game.human.DiscardedCardSetter;
import juno.init.ProgramDirectory;
import juno.model.card.InterfaceCard;
import juno.model.deck.CompatibilityChecker;
import juno.model.requester.PathProviderAssembler;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.Provider;
import juno.model.util.Setter;
import juno.view.avatar.UserAvatarPanel;
import juno.view.img_initializer.ImageComponentInitializer;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
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

        // Avatar panel.
        UserAvatarPanel avatarPanel = new UserAvatarPanel();
        avatarPanel.init();
        // The circle.
        JLabel circle = new JLabel();
        ImageComponentInitializer.getInstance()
                .initialize(circle,
                        PathProviderAssembler.getInstance().assemble(ProgramDirectory.GIFS, "circle.gif"),
                        null);
        circle.setVisible(false);

        // Human player.
        HumanPlayer<InterfaceCard> humanPlayer = (HumanPlayer<InterfaceCard>) HumanPlayer.getInstance();

        // Component.
        SouthCardPanel southCardPanel = SouthCardPanel.getInstance();
        CompatibleGCardEnabler compatibleGCardEnabler = CompatibleGCardEnabler.getInstance();

        // Card panel.
        JScrollPane southCardScrollPanel = new JScrollPane(southCardPanel,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        southCardScrollPanel.setPreferredSize(new Dimension(950, 150));
        southCardScrollPanel.setIgnoreRepaint(false);
        southCardScrollPanel.setMinimumSize(new Dimension(950, 150));
        southCardScrollPanel.getViewport().setOpaque(false);
        southCardScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        southCardScrollPanel.setOpaque(false);
        JScrollBar bar = southCardScrollPanel.getHorizontalScrollBar();
        bar.setOpaque(false);
        bar.setPreferredSize(new Dimension(5, 9));
        bar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GREEN;
            }
        });

        // Observer / Observable.
        GameStarter.getInstance().addObserver(southCardPanel);
        TurnMover.getInstance().addObserver(southCardPanel);
        CardDispenser.getInstance().addObserver(southCardPanel);
        humanPlayer.addObserver(southCardPanel);

        // Component setting.
        southCardPanel.setDiscardedCardSetter((Setter<InterfaceCard>) DiscardedCardSetter.getInstance());
        southCardPanel.setPlayableCardSetter(CompatibleGCardEnabler.getInstance());
        southCardPanel.setCurrentPlayerProvider((Provider<InterfacePlayer<InterfaceCard>>) CurrentPlayerProvider.getInstance());
        southCardPanel.setHumanPlayer(humanPlayer);

        compatibleGCardEnabler.setCompatibilityChecker(CompatibilityChecker.getInstance());

        // Setting components.
        southPanel.setFirstComponent(southCardScrollPanel);  // Card scroll panel.
        southPanel.setSecondComponent(avatarPanel);          // Avatar panel.
        southPanel.setThirdComponent(circle);                // Circle panel.

        // Main component initialization.
        southPanel.init();
    }

}