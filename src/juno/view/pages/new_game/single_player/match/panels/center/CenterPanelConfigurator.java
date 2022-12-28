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

package juno.view.pages.new_game.single_player.match.panels.center;

import juno.view.pages.new_game.single_player.match.panels.center.actual_color.ActualColorPanel;
import juno.view.pages.new_game.single_player.match.panels.center.circle.CirclePanel;
import juno.view.pages.new_game.single_player.match.panels.center.deck.DeckPanel;
import juno.view.pages.new_game.single_player.match.panels.center.discarded_pile.DiscardedPilePanel;

/**
 * @author Simone Gentili
 */
public class CenterPanelConfigurator {

    // Builds a CenterPanelConfigurator object.
    private CenterPanelConfigurator() {}

    /** Configures the CenterPanel instance. */
    public static void configure() {
        // Main component.
        CenterPanel centerPanel = CenterPanel.getInstance();

        // Main component settings.
        centerPanel.setFirstComponent(CirclePanel.getInstance());
        centerPanel.setSecondComponent(DeckPanel.getInstance());
        centerPanel.setThirdComponent(DiscardedPilePanel.getInstance());
        centerPanel.setFourthComponent(ActualColorPanel.getInstance());

        // Initialization.
        centerPanel.init();
    }

}