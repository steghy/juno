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

package juno.view.pages.new_game.single_player.match;

import juno.model.subjects.factory.AiFactory;
import juno.view.pages.new_game.single_player.match.panels.center.CenterPanel;
import juno.view.pages.new_game.single_player.match.panels.east.EastPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthPanel;
import juno.view.pages.new_game.single_player.match.panels.south.SouthPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestPanel;

/**
 * @author Simone Gentili
 */
public class MatchPanelConfigurator {

    // Builds the MatchPanelConfiguration.
    private MatchPanelConfigurator() {}

    /** Configures the MatchPanel instance. */
    public static void configure() {
        // Main component.
        MatchPanel matchPanel = MatchPanel.getInstance();

        // Observer / Observable.
        AiFactory.getInstance().addObserver(matchPanel);

        // Setting components.
        matchPanel.setFirstComponent(SouthPanel.getInstance());  // South panel
        matchPanel.setSecondComponent(WestPanel.getInstance());  // East panel.
        matchPanel.setThirdComponent(NorthPanel.getInstance());  // North panel.
        matchPanel.setFourthComponent(EastPanel.getInstance());  // West panel.
        matchPanel.setFifthComponent(CenterPanel.getInstance()); // Center panel.

        // Main component initialization.
        matchPanel.init();
    }

}