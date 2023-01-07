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

package juno.view.pages.new_game.single_player.card;

import juno.view.pages.new_game.single_player.difficulty.DifficultyPanel;
import juno.view.pages.new_game.single_player.match.MatchPanel;
import juno.view.pages.new_game.single_player.winner.WinnerPanel;
import juno.view.pages.new_game.single_player.mode.ModePanel;
import juno.view.pages.new_game.single_player.players.PlayersNumberPanel;


/**
 * This class defines the single player card panel configurator.
 * @author Simone Gentili
 */
public class SinglePlayerCardPanelConfigurator {

    // Builds a SinglePlayerCardPanelConfigurator object.
    private SinglePlayerCardPanelConfigurator() {}

    /** Configures the SinglePlayerCardPanel instance. */
    public static void configure() {
        // Main component.
        SinglePlayerCardPanel singlePlayerCardPanel = SinglePlayerCardPanel.getInstance();

        // Components.
        PlayersNumberPanel playersNumberPanel = PlayersNumberPanel.getInstance();
        DifficultyPanel difficultyPanel = DifficultyPanel.getInstance();
        ModePanel modePanel = ModePanel.getInstance();
        MatchPanel matchPanel = MatchPanel.getInstance();
        WinnerPanel winnerPanel = WinnerPanel.getInstance();

        // Components settings.
        singlePlayerCardPanel.setFirstComponent(playersNumberPanel); // Players number panel.
        singlePlayerCardPanel.setSecondComponent(difficultyPanel);   // Difficulty panel.
        singlePlayerCardPanel.setThirdComponent(modePanel);          // Mode panel.
        singlePlayerCardPanel.setFourthComponent(matchPanel);        // Match panel.
        singlePlayerCardPanel.setFifthComponent(winnerPanel);        // Winner panel.

        // Main component initialization.
        singlePlayerCardPanel.init();
    }

}