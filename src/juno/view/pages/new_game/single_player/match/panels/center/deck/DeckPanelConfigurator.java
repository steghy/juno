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

package juno.view.pages.new_game.single_player.match.panels.center.deck;

import juno.controller.new_game.human.DiscardedCardSetter;
import juno.controller.new_game.human.DrawAction;
import juno.init.ProgramDirectory;
import juno.model.requester.PathProviderAssembler;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.Provider;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.view.util.ImageButton;
import juno.view.util.ImageResizer;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class DeckPanelConfigurator {

    // Builds a DeckPanelConfigurator object.
    private DeckPanelConfigurator() {}

    /** Configure the DeckPanel instance. */
    @SuppressWarnings("unchecked")
    public static void configure() {
        // Main Component.
        DeckPanel<InterfacePlayer<?>> deckPanel =
                (DeckPanel<InterfacePlayer<?>>) DeckPanel.getInstance();

        // Component.
        ImageResizer resizer = ImageResizer.getInstance();
        AbstractButton deckButton = new ImageButton(resizer);
        ImageComponentInitializer.getInstance().initialize(
                deckButton,
                PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER.png"),
                PathProviderAssembler.getInstance().assemble(ProgramDirectory.COVER, "COVER_ROLLOVER.png"),
                null);

        // Image resizing.
        resizer.resize(deckButton, 3.5);

        // Action listener.
        deckButton.addActionListener(DrawAction.getInstance());

        // Observer / Observable.
        TurnMover.getInstance().addObserver(deckPanel);
        DrawAction.getInstance().addObserver(deckPanel);
        DiscardedCardSetter.getInstance().addObserver(deckPanel);

        // Settings.
        deckPanel.setProvider((Provider<InterfacePlayer<?>>) CurrentPlayerProvider.getInstance());
        deckPanel.setHumanPlayer(HumanPlayer.getInstance());
        deckPanel.setFirstComponent(deckButton);

        // Main component initialization.
        deckPanel.init();
    }

}