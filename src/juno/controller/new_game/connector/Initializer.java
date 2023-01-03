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

package juno.controller.new_game.connector;

import juno.controller.subscriber.AiPanelSubscriber;
import juno.controller.util.InterfaceInitializer;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.factory.AiPlayerFactory;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.Donut;
import juno.model.util.Provider;
import juno.view.pages.new_game.single_player.match.panels.east.EastCardPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.south.SouthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestCardPanel;

import java.util.Map;

/**
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // Builds the Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initialize() {
        // Players provider.
        Provider<?> provider = PlayersProvider.getInstance();

        // Panel illuminator.
        PanelIlluminator panelIlluminator = PanelIlluminator.getInstance();

        // Connector.
        Connector connector = Connector.getInstance();

        ///////////////////////////////////////////////////////////////////

        // Connector.
        AiPlayerFactory.getInstance().addObserver(connector);

        // Panel illuminator.
        panelIlluminator.setPlayersProvider((Provider<InterfacePlayer<?>>) CurrentPlayerProvider.getInstance());
        panelIlluminator.addEntry(Map.entry(HumanPlayer.getInstance(), SouthCardPanel.getInstance()));
        TurnMover.getInstance().addObserver(panelIlluminator);
        connector.addObserver(panelIlluminator);
    }

}